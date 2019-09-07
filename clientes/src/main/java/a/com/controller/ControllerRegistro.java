/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package a.com.controller;

import a.com.modelo.Persona;
import java.io.Serializable;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.Size;

/**
 *
 * @author Yesid
 */
@ManagedBean
@RequestScoped
public class ControllerRegistro implements Serializable {

    @ManagedProperty("#{candidatoSession}")
    private CandidatoSession candidatoSession;

    @Size(min = 1, max = 15)
    private String nombre;

    @Size(min = 1, max = 15)
    private String apellido;

    @Min(1)
    @Max(1170970279)
    private Integer cedula;

    @Min(18)
    @Max(50)
    private Integer edad;

    public CandidatoSession getCandidatoSession() {
        return candidatoSession;
    }

    public void setCandidatoSession(CandidatoSession candidatoSession) {
        this.candidatoSession = candidatoSession;
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

    public Integer getCedula() {
        return cedula;
    }

    public void setCedula(Integer cedula) {
        this.cedula = cedula;
    }

    public Integer getEdad() {
        return edad;
    }

    public void setEdad(Integer edad) {
        this.edad = edad;
    }
    
    

    public void guargar() {

        candidatoSession.getListaPersonas().add(new Persona(cedula, nombre, apellido, edad));
        FacesContext context = FacesContext.getCurrentInstance();
        context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Información",
                "Persona Agregada a su lista"));
    }

    public ControllerRegistro() {
    }

}
