/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package a.com.controller;

import a.com.modelo.Persona;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import org.primefaces.event.RowEditEvent;

/**
 *
 * @author Yesid
 */
@ManagedBean
@RequestScoped
public class ControllerListar {

    @ManagedProperty("#{candidatoSession}")
    private CandidatoSession candidatoSession;

    private Persona persona;
    @Min(100)
    @Max(1170970279)
    private int cedula;
    private String nombre;
    private String apellido;
    private int edad;

    public CandidatoSession getCandidatoSession() {
        return candidatoSession;
    }

    public void setCandidatoSession(CandidatoSession candidatoSession) {
        this.candidatoSession = candidatoSession;
    }

    public Persona getPersona() {
        return persona;
    }

    public void setPersona(Persona persona) {
        this.persona = persona;
    }

    public int getCedula() {
        return cedula;
    }

    public void setCedula(int cedula) {
        this.cedula = cedula;
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

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public void editar(RowEditEvent event) {
        Persona p = (Persona) event.getObject();
        p.setCedula(cedula);
        p.setNombre(nombre);
        FacesMessage msg = new FacesMessage("Edicion Exitosa", ((Persona) event.getObject()).getNombre());
        FacesContext.getCurrentInstance().addMessage(null, msg);

    }

    public void cancelar(RowEditEvent event) {
        FacesMessage msg = new FacesMessage("Edicion Cancelada", ((Persona) event.getObject()).getNombre());
        FacesContext.getCurrentInstance().addMessage(null, msg);

    }
}
