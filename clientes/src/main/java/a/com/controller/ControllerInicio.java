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
 *
 * @author Yesid
 */
@ManagedBean
@RequestScoped
public class ControllerInicio {

    private String cliente;

    public String getCliente() {
        return cliente;
    }

    public void setCliente(String cliente) {
        this.cliente = cliente;
    }

    public String enviarDatos() {
        
         FacesContext context = FacesContext.getCurrentInstance();
        ControllerRegistro res = context.getApplication().evaluateExpressionGet(context, "#{controllerRegistro}", ControllerRegistro.class);
        
        res.setCliente(cliente);
         
        return "registro";

    }

}
