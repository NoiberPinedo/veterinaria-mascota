/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managedBean;

import dao.ReservacitaDao;
import dao.ClienteDao;
import dao.MascotaDao;
import dao.PersonalDao;
import dao.ReservacitaDao;
import dao.TiporeservaDao;
import dao.UsuarioDao;
import entidades.Reservacita;
import entidades.Cliente;
import entidades.Clientepormascota;
import entidades.ClientepormascotaId;
import entidades.Personal;
import entidades.Reservacita;
import entidades.Tiporeserva;
import entidades.Usuario;
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
public class ReservaCitaBean implements Serializable {

    private Reservacita reservacita;
    private boolean banderaSelect = false;

    private Cliente cliente;
    private ArrayList listaclientes;
    private int idCliente;

    private Tiporeserva tiporeserva;
    private ArrayList listatiporeservas;
    private int idTiporeserva;

    private Usuario usuario;
    private ArrayList listausuarios;
    private int idUsuario;

    public ReservaCitaBean() {
        reservacita = new Reservacita();
        cliente = new Cliente();
        tiporeserva = new Tiporeserva();
        usuario = new Usuario();
        listaclientes = new ArrayList();
        listatiporeservas = new ArrayList();
        listausuarios = new ArrayList();
        listarCombos();

    }

    public void listarCombos() {
        ClienteDao clientedao = new ClienteDao();
        TiporeservaDao tiporeservaDao = new TiporeservaDao();
        UsuarioDao usuariodao = new UsuarioDao();
        listaclientes = clientedao.listarCliente();
        listatiporeservas = tiporeservaDao.listarTiporeserva();
        listausuarios = usuariodao.listarUsuarios();

    }

    public String guardarReservacita() {
        try {
            ReservacitaDao reservacitadao = new ReservacitaDao();
            tiporeserva.setIdTipoReserva(idTiporeserva);
            cliente.setIdCliente(idCliente);
            usuario.setIdUsuario(idUsuario);
            reservacita.setCliente(cliente);
            reservacita.setTiporeserva(tiporeserva);
            reservacita.setUsuario(usuario);
            boolean respuesta = reservacitadao.guardarReservacita(reservacita);
            if (respuesta) {
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Se registro con éxito"));
            } else {
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("No se puede registrar"));
            }
        } catch (HibernateException e) {
            ///transation.rollback();  -- regresa a la anterior
            System.out.println("Error::: " + e);
        }
        return "/RegistroReservacita";
    }

    public String actualizarReservacita() {
        try {
            ReservacitaDao reservacitaDao = new ReservacitaDao();
            boolean respuesta = reservacitaDao.actualizarReservacita(reservacita);
            if (respuesta) {
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Se actualizo con exito"));
            } else {
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("No se puedo actualizar"));
            }
        } catch (HibernateException e) {
            ///transation.rollback();  -- regresa a la anterior
            System.out.println("Error::: " + e);
        }
        return "/RegistroReservacita";

    }

    public ArrayList<Reservacita> listarReservacitas() {
        ArrayList<Reservacita> lista = new ArrayList<>();
        ReservacitaDao reservacitaDao = new ReservacitaDao();
        lista = reservacitaDao.listarReservacitas();
        return lista;
    }

    public String eliminar() {
        ReservacitaDao reservacitaDao = new ReservacitaDao();
        boolean respuesta = reservacitaDao.eliminarReservacita(reservacita);
        if (respuesta) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Se elimino con exito"));
        } else {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("No se puedo eliminar"));
        }
        return "/RegistroReservacita";
    }

    public String limpiar() {
        banderaSelect = false;
        return "/RegistroReservacita";
    }

    public void selectBandera() {
        banderaSelect = true;
    }

    public boolean isBanderaSelect() {
        return banderaSelect;
    }

    public void setBanderaSelect(boolean banderaSelect) {
        this.banderaSelect = banderaSelect;
    }

    public Reservacita getReservacita() {
        return reservacita;
    }

    public void setReservacita(Reservacita reservacita) {
        this.reservacita = reservacita;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public ArrayList getListaclientes() {
        return listaclientes;
    }

    public void setListaclientes(ArrayList listaclientes) {
        this.listaclientes = listaclientes;
    }

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public Tiporeserva getTiporeserva() {
        return tiporeserva;
    }

    public void setTiporeserva(Tiporeserva tiporeserva) {
        this.tiporeserva = tiporeserva;
    }

    public ArrayList getListatiporeservas() {
        return listatiporeservas;
    }

    public void setListatiporeservas(ArrayList listatiporeservas) {
        this.listatiporeservas = listatiporeservas;
    }

    public int getIdTiporeserva() {
        return idTiporeserva;
    }

    public void setIdTiporeserva(int idTiporeserva) {
        this.idTiporeserva = idTiporeserva;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public ArrayList getListausuarios() {
        return listausuarios;
    }

    public void setListausuarios(ArrayList listausuarios) {
        this.listausuarios = listausuarios;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

}
