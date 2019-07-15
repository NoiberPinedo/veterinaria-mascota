/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managedBean;

import dao.TipoAtencionDao;
import entidades.Tipoatencion;
import java.io.Serializable;
import java.util.ArrayList;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import org.hibernate.HibernateException;

/**
 *
 * @author USUARIO
 */
@ManagedBean
@ViewScoped
public class TipoAtencionBean implements Serializable {

    private Tipoatencion tipoatenciones;
    private boolean banderaSelect=false;

    public TipoAtencionBean() {
        this.tipoatenciones = new Tipoatencion();
    }


    public String guardarTipoatencion() {
        try {

            TipoAtencionDao tipoatencionDao = new TipoAtencionDao();
            boolean respuesta = tipoatencionDao.guardarTipoAtencion(tipoatenciones);
            if (respuesta) {
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Se registro correctamente"));
            } else {
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("No se puedo registrar"));
            }
        } catch (HibernateException e) {
            ///transation.rollback();  -- regresa a la anterior
            System.out.println("Error::: " + e);
        }
        return "/RegistroTipoAtencion";
    }

    public String actualizarTipoAtencion() {
        try {
            TipoAtencionDao tipoatencionDao = new TipoAtencionDao();
            boolean respuesta = tipoatencionDao.actualizarTipoAtencion(tipoatenciones);
            if (respuesta) {
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Se actualizo correctamente"));
            } else {
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("No se puedo actualizar"));
            }
        } catch (HibernateException e) {
            ///transation.rollback();  -- regresa a la anterior
            System.out.println("Error::: " + e);
        }
        return "/RegistroTipoAtencion";

    }

    public ArrayList<Tipoatencion> listarTipoAtencion() {
        ArrayList<Tipoatencion> lista = new ArrayList<>();
        TipoAtencionDao tipoatencionDao = new TipoAtencionDao();
        lista = tipoatencionDao.listarTipoatencion();
        return lista;
    }

    public String eliminarTipoAtencion() {
        TipoAtencionDao tipoatencionDao = new TipoAtencionDao();
        boolean respuesta = tipoatencionDao.eliminarTipoAtencion(tipoatenciones);
        if (respuesta) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Se elimino correctamente"));
        } else {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("No se puedo eliminar"));
        }
        return "/RegistroTipoAtencion";
    }

       public String limpiar() {
        banderaSelect=false;
        return "/RegistroTipoAtencion";
    }
   public void selectBandera(){
    banderaSelect=true;
   }

    public boolean isBanderaSelect() {
        return banderaSelect;
    }

    public void setBanderaSelect(boolean banderaSelect) {
        this.banderaSelect = banderaSelect;
    }

    public Tipoatencion getTipoatenciones() {
        return tipoatenciones;
    }

    public void setTipoatenciones(Tipoatencion tipoatenciones) {
        this.tipoatenciones = tipoatenciones;
    }

}
