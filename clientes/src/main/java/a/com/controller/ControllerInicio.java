/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package a.com.controller;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

/**
 * RequestScoped se usa una vez y se destruye
 *
 * @author Yesid
 * @author Laura
 */
@ManagedBean
@RequestScoped
public class ControllerInicio {

    /**
     * Variable que almacena el cliente el cual realiza la transaccion.
     * Identificador
     */
    private String cliente;

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
     * Metodo el cual se encarga de enviar al bean ControllerRegeistro la
     * variable cliente para su respectivo uso
     *
     * @return Retornamos un String el cual lleva el nombre de la pagina a la
     * que nos vamos a redirigir despues de haber cumplido el metodo
     */
    public String enviarDatos() {

        FacesContext context = FacesContext.getCurrentInstance();
        ControllerRegistro reg = context.getApplication().evaluateExpressionGet(context, "#{controllerRegistro}", ControllerRegistro.class);
        ControllerListar lis = context.getApplication().evaluateExpressionGet(context, "#{controllerListar}", ControllerListar.class);

        reg.setCliente(cliente);
        lis.setCliente(cliente);

        return "registro";

    }

}
