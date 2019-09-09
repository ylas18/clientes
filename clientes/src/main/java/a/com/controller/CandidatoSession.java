/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package a.com.controller;

import a.com.modelo.Persona;
import a.com.modelo.Transaccion;
import javax.inject.Named;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;

/**
 * Session el cual mantiene vivo el bean hasta que se termine la aplicacion. Se
 * usa para alamcenar los datos de los difetentes cleintes que estan realizando
 * insercion, edicion, eliminacion y cancelacion
 *
 * @author Yesid
 */
@ManagedBean
@SessionScoped
public class CandidatoSession implements Serializable {

    private List<Persona> listaPersonas;
    /**
     * Se utiliza @ManagedProperty para la inyección de dependencia (DI) de un
     * bean administrado en la propiedad de otro bean administrado.
     */
    @ManagedProperty("#{administradorSession}")
    private AdministradorSession administradorSession;

    /**
     * Creamos el get para darle su uso de lectura
     *
     * @return
     */
    public AdministradorSession getAdministradorSession() {
        return administradorSession;
    }

    /**
     * Creamos el set para darle su uso de escritura
     *
     * @return
     */
    public void setAdministradorSession(AdministradorSession administradorSession) {
        this.administradorSession = administradorSession;
    }

    /**
     * Contructor donde se crea la lista para su respectivo uso
     */
    public CandidatoSession() {
        listaPersonas = new ArrayList<>();

    }

    /**
     * Get de la lista para su respectiva lectura
     *
     * @return
     */
    public List<Persona> getListaPersonas() {
        return listaPersonas;
    }

    /**
     * set para su respectiva escritura
     *
     * @param listaPersonas
     */
    public void setListaPersonas(List<Persona> listaPersonas) {
        this.listaPersonas = listaPersonas;
    }

    /**
     * Metodo usado para guardar en la lista de administrador la transaccion de
     * agregar
     *
     * @param cliente cliente el cual esta realizando la transaccion
     * @param nombre nombre del campo el cual se agrego
     */
    public void listaAdminAgregar(String cliente, String nombre) {
        administradorSession.getListaTra().add(new Transaccion(cliente, "Agregar", nombre));
    }

    /**
     * Metodo usado para guardar en la lista de administrador la transaccion de
     * Editar
     *
     * @param cliente cliente el cual esta realizando la transaccion
     * @param nombre nombre del campo el cual se agrego
     */
    public void listaAdminEditar(String cliente, String nombre) {
        administradorSession.getListaTra().add(new Transaccion(cliente, "Edicion", nombre));
    }

    /**
     * Metodo usado para guardar en la lista de administrador la transaccion de
     * Eliminar
     *
     * @param cliente cliente el cual esta realizando la transaccion
     * @param nombre nombre del campo el cual se agrego
     */
    public void listaAdminEliminar(String cliente, String nombre) {
        administradorSession.getListaTra().add(new Transaccion(cliente, "Eliminacion", nombre));
    }

    /**
     * Metodo usado para guardar en la lista de administrador la transaccion de
     * Cancelar Edicion
     *
     * @param cliente cliente el cual esta realizando la transaccion
     * @param nombre nombre del campo el cual se agrego
     */
    public void listaAdminCancelar(String cliente, String nombre) {
        administradorSession.getListaTra().add(new Transaccion(cliente, "Edicion Cancelada", nombre));
    }

}
