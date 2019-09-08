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
 *
 * @author Yesid
 */
@ManagedBean
@ApplicationScoped
public class AdministradorSession implements Serializable {

    private List<Transaccion> listaTra;

    public AdministradorSession() {

        listaTra = new ArrayList<>();
    }

    public List<Transaccion> getListaTra() {
        return listaTra;
    }

    public void listaAct() {
        getListaTra();
    }

    public void setListaTra(List<Transaccion> listaTra) {
        this.listaTra = listaTra;
    }
}
