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
public class Amigos extends Contacto {

    private String apodo;
    private int telefonoCasa;
    private int celular;
    private int diacumpleanos;
    private int mescumpleanos;
    private String correo;
    private String face;
    private String twitter;

    public Amigos(String n, String apodo, int telefonoCasa, int cel, int dia,
            int mes, String correo, String face, String twit) {
        super(n);
        this.apodo = apodo;
        this.telefonoCasa = telefonoCasa;
        this.celular = cel;
        this.diacumpleanos = dia;
        this.mescumpleanos = mes;
        this.correo = correo;
        this.face = face;
        this.twitter = twit;

    }

    public String getApodo() {
        return apodo;
    }

    public int getCelular() {
        return celular;
    }

    public String getCorreo() {
        return correo;
    }

    public int getDiacumpleanos() {
        return diacumpleanos;
    }

    public int getMescumpleanos() {
        return mescumpleanos;
    }

    public String getFace() {
        return face;
    }

    @Override
    public String getNombre() {
        return super.getNombre(); //To change body of generated methods, choose Tools | Templates.
    }

    public int getTelefonoCasa() {
        return telefonoCasa;
    }

    public String getTwitter() {
        return twitter;
    }

    public void setApodo(String apodo) {
        this.apodo = apodo;
    }

    public void setCelular(int celular) {
        this.celular = celular;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public void setDiacumpleanos(int diacumpleanos) {
        this.diacumpleanos = diacumpleanos;
    }

    public void setMescumpleanos(int mescumpleanos) {
        this.mescumpleanos = mescumpleanos;
    }

    public void setFace(String face) {
        this.face = face;
    }

    @Override
    public void setNombre(String nombre) {
        super.setNombre(nombre); //To change body of generated methods, choose Tools | Templates.
    }

    public void setTelefonoCasa(int telefonoCasa) {
        this.telefonoCasa = telefonoCasa;
    }

    public void setTwitter(String twitter) {
        this.twitter = twitter;
    }

    @Override
    public String toString() {
        String amigos = "";
        amigos = super.toString()
                + "Apodo: " + apodo + "\n"
                + "Telefono Casa: " + telefonoCasa + "\n"
                + "Celular: " + celular + "\n"
                + "Cumpleaños: " + diacumpleanos + "/" + mescumpleanos + "\n"
                + "Correo Electronico: " + correo + "\n"
                + "Facebook: " + face + "\n"
                + "Twitter: " + twitter + "\n";

        return amigos;
    }

}
