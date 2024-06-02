/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.sql.Timestamp;

/**
 *
 * @author Desktop
 */
public class Venda {
    
    private int codigo;
    private double total;
    private Timestamp datav;
    private int codcli;

    /**
     * @return the codigo
     */
    public int getCodigo() {
        return codigo;
    }

    /**
     * @param codigo the codigo to set
     */
    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }
    
    public void setCodigo(String codigo) {
        this.setCodigo(Integer.parseInt(codigo));
    }

    /**
     * @return the total
     */
    public double getTotal() {
        return total;
    }

    /**
     * @param total the total to set
     */
    public void setTotal(double total) {
        this.total = total;
    }
    
    public void getTotal(String total) {
        this.setTotal(Double.parseDouble(total));
    }

    /**
     * @return the datav
     */
    public Timestamp getDatav() {
        return datav;
    }

    /**
     * @param datav the datav to set
     */
    public void setDatav(Timestamp datav) {
        this.datav = datav;
    }
    
    public void setDatav(String datav) {
        this.setDatav(Timestamp.valueOf(datav));
    }

    /**
     * @return the codcli
     */
    public int getCodcli() {
        return codcli;
    }

    /**
     * @param codcli the codcli to set
     */
    public void setCodcli(int codcli) {
        this.codcli = codcli;
    }

    public void setCodcli(String codcli) {
        this.setCodcli(Integer.parseInt(codcli));
    }
}
