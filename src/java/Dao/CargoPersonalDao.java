/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import entidades.Cargopersonal;
import interfaces.ICargopersonal;
import java.util.ArrayList;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import utilitarios.HibernateUtil;

/**
 *
 * @author USUARIOWIN10
 */
public class CargoPersonalDao implements ICargopersonal {

    @Override
    public boolean guardarCargopersonal(Cargopersonal cargopersonal) {
          //Construir una nueva session y una nueva transaccion
        boolean respuesta = true;
        Session sesion = HibernateUtil.getSessionFactory().openSession();
        Transaction transaccion = sesion.beginTransaction();
        //Rgistrar en la base de datos la cargoCargoPersonal

        try {
            sesion.save(cargopersonal);
            transaccion.commit();
        } catch (Exception e) {
            System.out.println("ERROR DE GUARFDAR::" + e);
            respuesta = false;
        }

        sesion.close();
        return respuesta;
    }

    @Override
    public ArrayList<Cargopersonal> listarCargopersonal() {
       Session sesion = HibernateUtil.getSessionFactory().openSession();
        ArrayList<Cargopersonal> milista = new ArrayList<>();
        //Create la consulta hacia la base de datos
        Query query = sesion.createQuery("from Cargopersonal");
        //Ejecutar la consulta y obtener la lista
        milista = (ArrayList<Cargopersonal>) query.list();
        sesion.close();
        return milista;  
   
    }

    @Override
    public boolean ActualizarCargoPersonal(Cargopersonal cargopersonal) {
             //System.out.println("error"+ cargoCargoPersonal.getNombre());
        boolean resp= true;
        Session sesion= null;
        try {
            sesion=HibernateUtil.getSessionFactory().openSession();
            Transaction transaction=sesion.beginTransaction();
            sesion.update(cargopersonal);
            transaction.commit();
        } catch (Exception e) {
            System.out.println("Error en actualizar::"+e);
        }finally{
            if(sesion != null){
                sesion.close();
            } 
        }
       return resp;
    }

    @Override
    public boolean eliminarCargoPersonal(Cargopersonal cargopersonal) {
             Session sesion = null;
        boolean resp = true;
        try {
            sesion = HibernateUtil.getSessionFactory().openSession();
            sesion.beginTransaction();
            sesion.delete(cargopersonal);
            sesion.getTransaction().commit();

        } catch (Exception e) {
            resp = false;
            System.out.println("ERROR EN ELIMINAR::" + e);
            sesion.getTransaction().rollback();
        } finally {
            if (sesion != null) {
                sesion.close();

            }

        }
        return resp;
    }

}
