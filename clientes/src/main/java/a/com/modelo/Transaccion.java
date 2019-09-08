/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package a.com.modelo;

/**
 *
 * @author Yesid
 */
public class Transaccion {

    private String cliente;
    private String procedimiento;
    private String objeto;

    public Transaccion(String cliente, String procedimiento, String objeto) {
        this.cliente = cliente;
        this.procedimiento = procedimiento;
        this.objeto = objeto;
    }

    
    public String getCliente() {
        return cliente;
    }

    public void setCliente(String cliente) {
        this.cliente = cliente;
    }

    public String getProcedimiento() {
        return procedimiento;
    }

    public void setProcedimiento(String procedimiento) {
        this.procedimiento = procedimiento;
    }

    public String getObjeto() {
        return objeto;
    }

    public void setObjeto(String objeto) {
        this.objeto = objeto;
    }
    
    
}
