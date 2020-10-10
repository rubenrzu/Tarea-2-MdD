/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tarea2;

/**
 *
 * 
 */
public class Familiar {
    private int parentesco;
    private int telCasa;
    private int cumple;

    public Familiar(int parentesco, int telCasa, int cumple) {
        this.parentesco = parentesco;
        this.telCasa = telCasa;
        this.cumple = cumple;
    }
    
    

    public int getCumple() {
        return cumple;
    }

    public int getParentesco() {
        return parentesco;
    }

    public int getTelCasa() {
        return telCasa;
    }

    public void setCumple(int cumple) {
        this.cumple = cumple;
    }

    public void setParentesco(int parentesco) {
        this.parentesco = parentesco;
    }

    public void setTelCasa(int telCasa) {
        this.telCasa = telCasa;
    }

    @Override
    public String toString() {
         String familiares = "";
        familiares = super.toString()
                + "Parentesco: " + parentesco + "\n"
                + "Telefono Casa: " + telCasa + "\n"
                + "Cumpleaños: " + cumple + "\n";

        return familiares;
    }
    
    
    
}

