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
    
    
}
