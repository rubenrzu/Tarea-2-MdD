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
    private Contacto contactos[];
    private int na;
    private Scanner lector;
    private Scanner lector1;
    
    public Directorio(int a){
        contactos = new Contacto[(a>0) ? a:20];
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
        return na == contactos.length;
    }
  
    private void crecerArreglo(int ncas){
        int nuevoTam = contactos.length + ncas; //Definimos el nuevo tamanio
        Contacto temp[] = new Contacto[nuevoTam];
        for(int i = 0;i < contactos.length;i++) //Copiamos los elementos desde el arreglo original al nuevo
            temp[i] = contactos[i];
        //Actualizar el arreglo orginal, sustituyéndolo por el nuevo
        contactos = temp;
    }  
  
  /**
   * Método para agregar un Contacto
   * @param a El artículo que se va a agregar
   */
    public void agregar(Contacto a){
        if(estaLleno())//Aumenta tamanio si está lleno
            crecerArreglo(1);
        if(!estaLleno()) //Verifica si hay espacio
            contactos[na++] = a;
  }    
}
