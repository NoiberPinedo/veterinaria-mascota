package entidades;
// Generated 19/07/2019 08:48:56 AM by Hibernate Tools 4.3.1


import java.util.Date;

/**
 * Atencion generated by hbm2java
 */
public class Atencion  implements java.io.Serializable {


     private Integer idAtencion;
     private Clientepormascota clientepormascota;
     private Personal personal;
     private Tipoatencion tipoatencion;
     private Date fechaAtencion;
     private String diagnostico;
     private Date horaAtencion;

    public Atencion() {
    }

    public Atencion(Clientepormascota clientepormascota, Personal personal, Tipoatencion tipoatencion, Date fechaAtencion, String diagnostico, Date horaAtencion) {
       this.clientepormascota = clientepormascota;
       this.personal = personal;
       this.tipoatencion = tipoatencion;
       this.fechaAtencion = fechaAtencion;
       this.diagnostico = diagnostico;
       this.horaAtencion = horaAtencion;
    }
   
    public Integer getIdAtencion() {
        return this.idAtencion;
    }
    
    public void setIdAtencion(Integer idAtencion) {
        this.idAtencion = idAtencion;
    }
    public Clientepormascota getClientepormascota() {
        return this.clientepormascota;
    }
    
    public void setClientepormascota(Clientepormascota clientepormascota) {
        this.clientepormascota = clientepormascota;
    }
    public Personal getPersonal() {
        return this.personal;
    }
    
    public void setPersonal(Personal personal) {
        this.personal = personal;
    }
    public Tipoatencion getTipoatencion() {
        return this.tipoatencion;
    }
    
    public void setTipoatencion(Tipoatencion tipoatencion) {
        this.tipoatencion = tipoatencion;
    }
    public Date getFechaAtencion() {
        return this.fechaAtencion;
    }
    
    public void setFechaAtencion(Date fechaAtencion) {
        this.fechaAtencion = fechaAtencion;
    }
    public String getDiagnostico() {
        return this.diagnostico;
    }
    
    public void setDiagnostico(String diagnostico) {
        this.diagnostico = diagnostico;
    }
    public Date getHoraAtencion() {
        return this.horaAtencion;
    }
    
    public void setHoraAtencion(Date horaAtencion) {
        this.horaAtencion = horaAtencion;
    }




}


