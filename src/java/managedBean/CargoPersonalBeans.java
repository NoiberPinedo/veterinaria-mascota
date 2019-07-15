/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managedBean;

import Dao.CargoPersonalDao;
import Dao.PersonalDao;
import entidades.Cargopersonal;
import entidades.Personal;
import java.util.ArrayList;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import org.hibernate.HibernateException;

/**
 *
 * @author USUARIOWIN10
 */
@ManagedBean
@ViewScoped
public class CargoPersonalBeans {
    private Cargopersonal cargopersonal;
    private boolean banderaSelect = false;
    
    private ArrayList listapersonal;
    private int idPersonal;
    
    private Personal personal;
    
    public CargoPersonalBeans() {
        this.cargopersonal = new Cargopersonal();
        listapersonal = new ArrayList();
        listarCombo();
    }
    
    public void listarCombo (){
        PersonalDao personalDao= new PersonalDao();
        listapersonal= personalDao.listarPersonal();
    }

    public String guardarCargoPersonal() {
        CargoPersonalDao dao = new CargoPersonalDao();
        personal.setIdPersonal(idPersonal);
        boolean respuesta = dao.guardarCargopersonal(cargopersonal);
        if (respuesta) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Se guardo correctamente"));
        } else {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("No se pudo registrar"));
        }
        return "/CargoPersonal";

    }

    public String actualizarCargoPersonal() {
        try {
            CargoPersonalDao cargopersonaldao = new CargoPersonalDao();
            boolean resp = cargopersonaldao.ActualizarCargoPersonal(cargopersonal);
            if (resp) {
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Se actualizo correctamente"));
            } else {
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("No se Pudo Actualizar"));

            }
            // cargopersonaldao.ActualizarCargoPersonal(cargopersonal);
        } catch (HibernateException e) {
            System.out.println("Error::" + e);
        }
        return "/CargoPersonal";
    }

    public ArrayList<Cargopersonal> listarCargoPersonal() {
        ArrayList<Cargopersonal> milista = new ArrayList<>();
        CargoPersonalDao dao = new CargoPersonalDao();
        milista = dao.listarCargopersonal();
        return milista;

    }

    public String eliminar(Cargopersonal data) {
        CargoPersonalDao personadao = new CargoPersonalDao();
        boolean respuesta = personadao.eliminarCargoPersonal(data);
        if (respuesta) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Se elimino correctamente"));
        } else {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("No se pudo eliminar"));
        }
        return "/CargoPersonal";
    }

      public String limpiar (){
        banderaSelect = false;
        return "/CargoPersonal";
    }
       public void selectBandera(){
        banderaSelect=true;    
    }

    public Cargopersonal getCargopersonal() {
        return cargopersonal;
    }

    public void setCargopersonal(Cargopersonal cargopersonal) {
        this.cargopersonal = cargopersonal;
    }

    public boolean isBanderaSelect() {
        return banderaSelect;
    }

    public void setBanderaSelect(boolean banderaSelect) {
        this.banderaSelect = banderaSelect;
    }

    public ArrayList getListapersonal() {
        return listapersonal;
    }

    public void setListapersonal(ArrayList listapersonal) {
        this.listapersonal = listapersonal;
    }

    public int getIdPersonal() {
        return idPersonal;
    }

    public void setIdPersonal(int idPersonal) {
        this.idPersonal = idPersonal;
    }

    public Personal getPersonal() {
        return personal;
    }

    public void setPersonal(Personal personal) {
        this.personal = personal;
    }

}
