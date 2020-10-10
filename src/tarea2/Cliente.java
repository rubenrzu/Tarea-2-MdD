/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tarea2;

/**
 *
 */
public class Cliente extends Contacto {

    private String compañia;
    private int telefonoOficina;
    private int extension;
    private int celular;
    private String correo;
    private String paginaWeb;

    public Cliente(String n, String c, int tel, int e, int cel, String correo,
            String pag) {
        super(n);
        this.compañia = c;
        this.telefonoOficina = tel;
        this.extension = e;
        this.celular = cel;
        this.correo = correo;
        this.paginaWeb = pag;

    }

    public int getCelular() {
        return celular;
    }

    public String getCompañia() {
        return compañia;
    }

    public String getCorreo() {
        return correo;
    }

    public int getExtension() {
        return extension;
    }

    public String getPaginaWeb() {
        return paginaWeb;
    }

    public int getTelefonoOficina() {
        return telefonoOficina;
    }

    public void setCelular(int celular) {
        this.celular = celular;
    }

    public void setCompañia(String compañia) {
        this.compañia = compañia;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public void setExtension(int extension) {
        this.extension = extension;
    }

    public void setPaginaWeb(String paginaWeb) {
        this.paginaWeb = paginaWeb;
    }

    public void setTelefonoOficina(int telefonoOficina) {
        this.telefonoOficina = telefonoOficina;
    }

    @Override
    public String toString() {
        String clientes = "";
        clientes = super.toString()+"Compañia: " + compañia + "\n"
                + "Telefono Oficina: " + telefonoOficina + "\n"
                + "Extension: " + extension + "\n"
                + "Celular: " + celular + "\n"
                + "Correo Electronico: " + correo + "\n"
                + "Pagina Web: " + paginaWeb + "\n";
        return clientes;
    }

}

