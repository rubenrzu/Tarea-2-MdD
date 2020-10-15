/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Directorio;

/**
 *
 * @author HP CSS30IXX
 */
public class Familiares extends Contacto {

    private String parentezco;
    private int telCasa;
    private int diacumpleanos;
    private int mescumpleanos;

    public Familiares(String n, String parentezco, int telCasa, int diacumpleanos,
            int mescumpleanos) {
        super(n);
        this.parentezco = parentezco;
        this.telCasa = telCasa;
        this.diacumpleanos = diacumpleanos;
        this.mescumpleanos = mescumpleanos;
    }

    public int getDiacumpleanos() {
        return diacumpleanos;
    }

    public int getMescumpleanos() {
        return mescumpleanos;
    }

    public String getParentezco() {
        return parentezco;
    }

    public int getTelCasa() {
        return telCasa;
    }

    public void setDiacumpleanos(int diacumpleanos) {
        this.diacumpleanos = diacumpleanos;
    }

    public void setMescumpleanos(int mescumpleanos) {
        this.mescumpleanos = mescumpleanos;
    }

    public void setParentezco(String parentezco) {
        this.parentezco = parentezco;
    }

    public void setTelCasa(int telCasa) {
        this.telCasa = telCasa;
    }

    @Override
    public String toString() {
        String familiares = "";
        familiares = super.toString()
                + "Parentezco: " + parentezco + "\n"
                + "Telefono Casa: " + telCasa + "\n"
                + "Cumpleaños: " + diacumpleanos + "/" + mescumpleanos + "\n";

        return familiares;
    }

}
