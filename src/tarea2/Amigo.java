//   Hola Abi!!
//  Hola!!
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tarea2;

/**
 *
 */
public class Amigo extends Contacto {

    private String apodo;
    private int telefonoCasa;
    private int celular;
    private int cumpleanos;
    private String correo;
    private String face;
    private String twitter;

    
    public Amigo(String n, int telefonoCasa, int cel, int cumple, String correo,
            String face, String twit) {
        super(n);
        this.telefonoCasa = telefonoCasa;
        this.celular = cel;
        this.cumpleanos = cumple;
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

    public int getCumpleanos() {
        return cumpleanos;
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

    public void setCumpleanos(int cumpleanos) {
        this.cumpleanos = cumpleanos;
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
                + "Cumpleaños: " + cumpleanos + "\n"
                + "Correo Electronico: " + correo + "\n"
                + "Facebook: " + face + "\n"
                + "Twitter: " + twitter + "\n";

        return amigos;
    }

}

