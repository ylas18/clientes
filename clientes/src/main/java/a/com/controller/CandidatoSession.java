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
 *
 * @author Yesid
 */
@ManagedBean
@SessionScoped
public class CandidatoSession implements Serializable {

    private List<Persona> listaPersonas;

    @ManagedProperty("#{administradorSession}")
    private AdministradorSession administradorSession;

    public AdministradorSession getAdministradorSession() {
        return administradorSession;
    }

    public void setAdministradorSession(AdministradorSession administradorSession) {
        this.administradorSession = administradorSession;
    }

    public CandidatoSession() {
        listaPersonas = new ArrayList<>();

    }

    public List<Persona> getListaPersonas() {
        return listaPersonas;
    }

    public void setListaPersonas(List<Persona> listaPersonas) {
        this.listaPersonas = listaPersonas;
    }

    public void listaAdminAgregar(String cliente, String nombre) {
        administradorSession.getListaTra().add(new Transaccion(cliente, "Agregar", nombre));
    }

    public void listaAdminEditar(String cliente, String nombre) {
        administradorSession.getListaTra().add(new Transaccion(cliente, "Edicion", nombre));
    }

    public void listaAdminEliminar(String cliente, String nombre) {
        administradorSession.getListaTra().add(new Transaccion(cliente, "Eliminacion", nombre));
    }

    public void listaAdminCancelar(String cliente, String nombre) {
        administradorSession.getListaTra().add(new Transaccion(cliente, "Edicion Cancelada", nombre));
    }
}
