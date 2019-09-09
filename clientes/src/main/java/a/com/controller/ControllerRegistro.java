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
import javax.faces.bean.SessionScoped;
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

    /**
     * Se utiliza @ManagedProperty para la inyección de dependencia (DI) de un
     * bean administrado en la propiedad de otro bean administrado.
     */
    @ManagedProperty("#{candidatoSession}")
    private CandidatoSession candidatoSession;

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
     * Metodo el cual almacena la informacion de los datos ingresados en la
     * lista de personas. Tambien realiza la insercion en la lsita de
     * Administrador en la cual se ingresa las transacciones que se han
     * realizado por los diferentes clientes Muestra su respectivo mensaje de
     * persona agregada.
     */
    public void guardar() {

        candidatoSession.getListaPersonas().add(new Persona(cliente, cedula, nombre, apellido, edad));
        candidatoSession.listaAdminAgregar(cliente, nombre);
        FacesContext context = FacesContext.getCurrentInstance();
        context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Información",
                "Persona Agregada a su lista"));
    }

}
