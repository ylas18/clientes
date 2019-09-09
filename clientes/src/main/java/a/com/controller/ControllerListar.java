/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package a.com.controller;

import a.com.modelo.Persona;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.Size;
import org.primefaces.event.RowEditEvent;

/**
 * Usamos Session para mantener viva en la session el cliente que inicia el
 * proceso y asi mismo guardarlo para su respectivo uso en la lista del
 * Administrador
 *
 * @author Yesid
 * @author Laura
 */
@ManagedBean
@SessionScoped
public class ControllerListar {

    /**
     * Se utiliza @ManagedProperty para la inyección de dependencia (DI) de un
     * bean administrado en la propiedad de otro bean administrado.
     */
    @ManagedProperty("#{candidatoSession}")
    private CandidatoSession candidatoSession;
    /**
     * Creamos el objeto persona
     */
    private Persona persona;
    /**
     * Variable donde almacenamos el cliente el cual realiza la transaccion
     */
    private String cliente;
    /**
     * Variable donde almacenamos la cedula. Minimo de 100 y maximo de
     * 1170970279
     */
    @Min(100)
    @Max(1170970279)
    private int cedula;
    /**
     * Variable donde almacenamos el nombre. Controlamos el tamaño de caracteres
     * entre 1 y 15
     */
    @Size(min = 1, max = 15)
    private String nombre;
    /**
     * Variable donde almacenamos el apellido. Controlamos el tamaño de
     * caracteres de 1 a 15
     */
    @Size(min = 1, max = 15)
    private String apellido;
    /**
     * Variable donde almacenamos la edad. Con un numero mazimo de 18 y minimo
     * de 50
     */
    @Min(18)
    @Max(50)
    private int edad;

    /**
     * Get para su respectiva lectura
     *
     * @return
     */
    public CandidatoSession getCandidatoSession() {
        return candidatoSession;
    }

    /**
     * Set para su respectiva escritura
     *
     * @param candidatoSession
     */
    public void setCandidatoSession(CandidatoSession candidatoSession) {
        this.candidatoSession = candidatoSession;
    }

    /**
     * Get para su respectiva lectura
     *
     * @return
     */
    public Persona getPersona() {
        return persona;
    }

    /**
     * Set para su respectiva escritura
     *
     * @param persona
     */
    public void setPersona(Persona persona) {
        this.persona = persona;
    }

    /**
     * Get para su respectiva lectura
     *
     * @return
     */
    public String getCliente() {
        return cliente;
    }

    /**
     * Set para su respectiva escritura
     *
     * @param cliente
     */
    public void setCliente(String cliente) {
        this.cliente = cliente;
    }

    /**
     * Get para su respectiva lectura
     *
     * @return
     */
    public int getCedula() {
        return cedula;
    }

    /**
     * Set para su respectiva escritura
     *
     * @param cedula
     */
    public void setCedula(int cedula) {
        this.cedula = cedula;
    }

    /**
     * Get para su respectiva lectura
     *
     * @return
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Set para su respectiva escritura
     *
     * @param nombre
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Get para su respectiva lectura
     *
     * @return
     */
    public String getApellido() {
        return apellido;
    }

    /**
     * Set para su respectiva escritura
     *
     * @param apellido
     */
    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    /**
     * Get para su respectiva lectura
     *
     * @return
     */
    public int getEdad() {
        return edad;
    }

    /**
     * Set para su respectiva escritura
     *
     * @param edad
     */
    public void setEdad(int edad) {
        this.edad = edad;
    }

    /**
     * Metodo que se encarga de realizar la edicion de
     *
     * @param event
     */
    public void editar(RowEditEvent event) {
        Persona p = (Persona) event.getObject();
        p.setCedula(cedula);
        p.setNombre(nombre);
        p.setApellido(apellido);
        p.setEdad(edad);
        candidatoSession.listaAdminEditar(cliente, nombre);
        FacesMessage msg = new FacesMessage("Edicion Exitosa", ((Persona) event.getObject()).getNombre());
        FacesContext.getCurrentInstance().addMessage(null, msg);

    }

    /**
     * Metodo que cancela la edicion y arroja el mensaje
     *
     * @param event
     */
    public void cancelar(RowEditEvent event) {
        candidatoSession.listaAdminCancelar(cliente, nombre);
        FacesMessage msg = new FacesMessage("Edicion Cancelada", ((Persona) event.getObject()).getNombre());
        FacesContext.getCurrentInstance().addMessage(null, msg);

    }

    /**
     * Metodo que elimina
     *
     * @param p Objeto persona
     */
    public void eliminar(Persona p) {

        List<Persona> listaPersona = candidatoSession.getListaPersonas();
        listaPersona.remove(p);
        candidatoSession.listaAdminEliminar(cliente, p.getNombre());
        FacesContext context = FacesContext.getCurrentInstance();
        context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Información",
                "Persona Eliminada de su lista"));

    }

}
