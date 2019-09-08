/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package a.com.controller;

import a.com.modelo.Persona;
import a.com.modelo.Transaccion;
import java.io.Serializable;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.Size;

/**
 *
 * @author Yesid
 */
@ManagedBean
@SessionScoped
public class ControllerRegistro implements Serializable {

    @ManagedProperty("#{candidatoSession}")
    private CandidatoSession candidatoSession;

    @Min(100)
    @Max(1170970279)
    private Integer cedula;

    private String cliente;

    @Size(min = 1, max = 15)
    private String nombre;

    @Size(min = 1, max = 15)
    private String apellido;

    @Min(18)
    @Max(50)
    private Integer edad;

    public CandidatoSession getCandidatoSession() {
        return candidatoSession;
    }

    public void setCandidatoSession(CandidatoSession candidatoSession) {
        this.candidatoSession = candidatoSession;
    }

    public Integer getCedula() {
        return cedula;
    }

    public void setCedula(Integer cedula) {
        this.cedula = cedula;
    }

    public String getCliente() {
        return cliente;
    }

    public void setCliente(String cliente) {
        this.cliente = cliente;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public Integer getEdad() {
        return edad;
    }

    public void setEdad(Integer edad) {
        this.edad = edad;
    }

    public void guardar() {

        candidatoSession.getListaPersonas().add(new Persona(cliente, cedula, nombre, apellido, edad));
        candidatoSession.listaAdminAgregar(cliente, nombre);

        FacesContext context = FacesContext.getCurrentInstance();
        context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Información",
                "Persona Agregada a su lista"));
    }

}
