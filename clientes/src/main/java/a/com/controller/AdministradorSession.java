/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package a.com.controller;

import a.com.modelo.Transaccion;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;

/**
 * Appication Scoped es usada para poder en este bean para poder ser llamado en
 * cualquier momento sin morir el porceso y desde cualquier lado
 *
 * @author Yesid
 * @author Laura
 */
@ManagedBean
@ApplicationScoped

public class AdministradorSession implements Serializable {

    /**
     * Creacion de la Lista donde almacenamos los datos de las transacciones que
     * se realizan en el sistema
     */
    private List<Transaccion> listaTra;

    /**
     * Inicializamos la lista para poder empezar a llenarla
     */
    public AdministradorSession() {

        listaTra = new ArrayList<>();
    }

    /**
     * Get para la respectiva lectura de la lista
     *
     * @return
     */
    public List<Transaccion> getListaTra() {
        return listaTra;
    }

    /**
     * Set para la respectiva escritura de la lista
     *
     * @param listaTra
     */
    public void setListaTra(List<Transaccion> listaTra) {
        this.listaTra = listaTra;
    }
}
