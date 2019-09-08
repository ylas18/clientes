/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package a.com.controller;

import a.com.modelo.Persona;
import a.com.modelo.Transaccion;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.Size;
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
    private AdministradorSession administradorSession;

    private Persona persona;
    
    private String cliente;
    
    @Min(100)
    @Max(1170970279)
    private int cedula;

    @Size(min = 1, max = 15)
    private String nombre;

    @Size(min = 1, max = 15)
    private String apellido;

    @Min(18)
    @Max(50)
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

    public String getCliente() {
        return cliente;
    }

    public void setCliente(String cliente) {
        this.cliente = cliente;
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
        p.setApellido(apellido);
        p.setEdad(edad);
        administradorSession.getListaTra().add(new Transaccion(cliente, "Edicion", nombre));
        FacesMessage msg = new FacesMessage("Edicion Exitosa", ((Persona) event.getObject()).getNombre());
        FacesContext.getCurrentInstance().addMessage(null, msg);

    }

    public void cancelar(RowEditEvent event) {
        administradorSession.getListaTra().add(new Transaccion(cliente, "Cancelacion", nombre));
        FacesMessage msg = new FacesMessage("Edicion Cancelada", ((Persona) event.getObject()).getNombre());
        FacesContext.getCurrentInstance().addMessage(null, msg);

    }

    public void eliminar(Persona p) {
        
        List<Persona> listaPersona = candidatoSession.getListaPersonas();
        listaPersona.remove(p);
        administradorSession.getListaTra().add(new Transaccion(cliente, "Eliminacion", nombre));
        FacesContext context = FacesContext.getCurrentInstance();
        context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Información",
                "Persona Eliminada de su lista"));

    }

}
