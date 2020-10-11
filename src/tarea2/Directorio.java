/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tarea2;

import static java.lang.System.in;
import java.util.Scanner;

/**
 *
 * @author ruben
 */
public class Directorio {
    private Contacto contacto[];
    private int na;
    private Scanner lector;
    private Scanner lector1;
    
    public Directorio(int a){
        contacto = new Contacto[(a>0) ? a:20];
        na=0;
        lector = new Scanner(in);
        lector1 = new Scanner(in).useDelimiter("\n");
    }
    
    public Directorio(){
    this(20);
    }
    
  /**
   * Método para saber si el arreglo de Contactos esta vacío
   * @return boolean true sí está vacío, false en caso contrario
   */
    public boolean estaVacio(){
        return na == 0;
  }
  
  /**
   * Método para saber si el arreglo de Contactos esta lleno
   * @return boolean true sí está lleno, false en otro caso
   */
    public boolean estaLleno(){
        return na == contacto.length;
    }
  
    private void crecerArreglo(int ncas){
        int nuevoTam = contacto.length + ncas; //Definimos el nuevo tamanio
        Contacto temp[] = new Contacto[nuevoTam];
        for(int i = 0;i < contacto.length;i++) //Copiamos los elementos desde el arreglo original al nuevo
            temp[i] = contacto[i];
        //Actualizar el arreglo orginal, sustituyéndolo por el nuevo
        contacto = temp;
    }  
  
  /**
   * Método para agregar un Contacto
   * @param a El artículo que se va a agregar
   */
    public void agregar(Contacto a){
        if(estaLleno())//Aumenta tamanio si está lleno
            crecerArreglo(1);
        if(!estaLleno()) //Verifica si hay espacio
            contacto[na++] = a;
  } 
    
    
    /*
    *Método para mostrar información completa de un contacto
    */
    public String mostrarContacto(String nom){
        int i;
        int total=0;
        String info="";
        if (!estaVacio()){
            for (i=0;i<na;i++){
                if(contacto[i].getNombre().equalsIgnoreCase(nom)){
                    if(contacto[i] instanceof Amigo)
                        info+=((Amigo)contacto[i]).toString() +  "\n********************\n";
                    if(contacto[i] instanceof Cliente)
                        info+=((Cliente)contacto[i]).toString() +  "\n********************\n";
                    if(contacto[i] instanceof Familiar)
                        info+=((Familiar)contacto[i]).toString() +  "\n********************\n";
                    total++;    
                }
           }
            switch (total) {
                case 0:
                    return "No se encontró el contacto";
                case 1:
                    return "Contacto encontrado\n" + info;
                default:
                    return "Se encontraron " + total + " contactos\n"+info;
            }
            
        }else 
            return "No hay contactos almacenados";
    }
    
    
    private String sep(){
        return "\n********************\n";
    }
    
    
 /**
    *Método que recibe nombre del contacto y categoria; devuelve String con datos de el/los contactos o informa que no se encontró
     * @param nom Nombre del contacto
     * @param  Categoria String entre {"Amigos","Cliente","Familiar"} si no se encuentra este valor habrá error. (Se hace control de errores en menú)
     * 
    */   
    public String mostrarNomCat(String nom, String Categoria){
        int i; 
        int total=0;
        String info=""; 
        switch(Categoria.toLowerCase()){
            case "amigos":
                for(i=0;i<na;i++){
                    if (((Amigo)contacto[i]).getNombre().equalsIgnoreCase(nom)){
                        info+=((Amigo)contacto[i]).toString() + sep();
                    total++;
                    }
                }
                switch(total){
                    case 0:
                        return "No se encontraron amigos";
                    case 1:
                        return "Amigo encontrado\n" + info;
                    default:
                        return "Se encontraron " + total + " amigos\n\n" + info;
                }
            case "familiar":
                for(i=0;i<na;i++){
                    if (((Familiar)contacto[i]).getNombre().equalsIgnoreCase(nom)){
                        info+=((Familiar)contacto[i]).toString() + sep();
                    total++;
                    }
                }
                switch(total){
                    case 0:
                        return "No se encontraron familiares";
                    case 1:
                        return "Familiar encontrado\n" + info;
                    default:
                        return "Se encontraron " + total + " familiares\n" + info;
                        
                }
            case "cliente":
                for(i=0;i<na;i++){
                    if (((Cliente)contacto[i]).getNombre().equalsIgnoreCase(nom)){
                        info+=((Cliente)contacto[i]).toString() + sep();
                    total++;
                    }
                }
                switch(total){
                    case 0:
                        return "No se encontraron clientes";
                    case 1:
                        return "Cliente encontrado\n" + info;
                    default:
                        return "Se encontraron " + total + " clientes\n\n" + info;
                }
        }
        return "Error";
    }
    
    
    
}
