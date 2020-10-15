/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Directorio;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import static java.lang.System.in;
import static java.lang.System.out;
import java.util.Scanner;

/**
 *
 * @author 
 */
public class Directorio {

    private Contacto[] contacto;
    private int na;
    private Scanner lector;
    private Scanner lector1;

    public Directorio(int a) {
        contacto = new Contacto[(a > 0) ? a : 20];
        na = 0;
        lector = new Scanner(in);
        lector1 = new Scanner(in).useDelimiter("\n");
    }

    public Directorio() {
        this(20);
    }

    /**
     * Método para saber si el arreglo de Contactos esta vacío
     *
     * @return boolean true sí está vacío, false en caso contrario
     */
    public boolean estaVacio() {
        return na == 0;
    }

    /**
     * Método para saber si el arreglo de Contactos esta lleno
     *
     * @return boolean true sí está lleno, false en otro caso
     */
    public boolean estaLleno() {
        return na == contacto.length;
    }

    private void crecerArreglo(int ncas) {
        int nuevoTam = contacto.length + ncas; //Definimos el nuevo tamanio
        Contacto temp[] = new Contacto[nuevoTam];
        for (int i = 0; i < contacto.length; i++) //Copiamos los elementos desde el arreglo original al nuevo
        {
            temp[i] = contacto[i];
        }
        //Actualizar el arreglo orginal, sustituyéndolo por el nuevo
        contacto = temp;
    }

    /**
     * Método para agregar un Contacto
     *
     * @param a El artículo que se va a agregar
     */
    public void agregar(Contacto a) {
        if (estaLleno())//Aumenta tamanio si está lleno
        {
            crecerArreglo(1);
        }
        if (!estaLleno()) //Verifica si hay espacio
        {
            contacto[na++] = a;
        }
    }

    /*
    *Método para mostrar información completa de un contacto
     */
    public String mostrarContacto(String nom) {
        int i;
        int total = 0;
        String info = "";
        if (!estaVacio()) {
            for (i = 0; i < na; i++) {
                if (contacto[i].getNombre().equalsIgnoreCase(nom)) {
                    if (contacto[i] instanceof Amigos) {
                        info += ((Amigos) contacto[i]).toString() + "\n********************\n";
                    }
                    if (contacto[i] instanceof Clientes) {
                        info += ((Clientes) contacto[i]).toString() + "\n********************\n";
                    }
                    if (contacto[i] instanceof Familiares) {
                        info += ((Familiares) contacto[i]).toString() + "\n********************\n";
                    }
                    total++;
                }
            }
            switch (total) {
                case 0:
                    return "No se encontró el contacto";
                case 1:
                    return "Contacto encontrado\n" + info;
                default:
                    return "Se encontraron " + total + " contactos\n" + info;
            }

        } else {
            return "No hay contactos almacenados";
        }
    }

    private String sep() {
        return "\n********************\n";
    }

    /**
     * Método que recibe nombre del contacto y categoria; devuelve String con
     * datos de el/los contactos o informa que no se encontró
     *
     * @param nom Nombre del contacto
     * @param Categoria String entre {"Amigos","Cliente","Familiar"} si no se
     * encuentra este valor habrá error. (Se hace control de errores en menú)
     *
     */
    public String mostrarNomCat(String nom, String Categoria) {
        int i;
        int total = 0;
        String info = "";
        switch (Categoria.toLowerCase()) {
            case "amigos":
                for (i = 0; i < na; i++) {
                    if (((Amigos) contacto[i]).getNombre().equalsIgnoreCase(nom)) {
                        info += ((Amigos) contacto[i]).toString() + sep();
                        total++;
                    }
                }
                switch (total) {
                    case 0:
                        return "No se encontraron amigos";
                    case 1:
                        return "Amigo encontrado\n" + info;
                    default:
                        return "Se encontraron " + total + " amigos\n\n" + info;
                }
            case "familiar":
                for (i = 0; i < na; i++) {
                    if (((Familiares) contacto[i]).getNombre().equalsIgnoreCase(nom)) {
                        info += ((Familiares) contacto[i]).toString() + sep();
                        total++;
                    }
                }
                switch (total) {
                    case 0:
                        return "No se encontraron familiares";
                    case 1:
                        return "Familiar encontrado\n" + info;
                    default:
                        return "Se encontraron " + total + " familiares\n" + info;

                }
            case "cliente":
                for (i = 0; i < na; i++) {
                    if (((Clientes) contacto[i]).getNombre().equalsIgnoreCase(nom)) {
                        info += ((Clientes) contacto[i]).toString() + sep();
                        total++;
                    }
                }
                switch (total) {
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

    
      public void eliminarPrimero(String nombre){
    int i;
    boolean borro = false;
    if(!estaVacio()){ //Si hay Articulos almacenados
      for(i = 0;i < na;i++) //Buscamos el Articulo
        if(nombre.equals(contacto[i].getNombre())){ //Lo encontró
          if(i == (na - 1)) //El Artículo está al final
            na--;
          else //El Artículo no es el último elemento
            contacto[i] = contacto[--na]; //Deja inaccesible al último valor
          borro = true;
          break; //Ya no seguimos buscando
        }
      if(i == na && !borro) //En caso de que no exista el Articulo
        out.println("El contacto con nombre \"" + nombre + "\" no existe!\n");
    }
    else
      out.println("No hay contactos almacenados\n");
  }
    
      
    private boolean contiene(String nombre){
    boolean respuesta = false;
    if(!estaVacio()) //Si hay contactos almacenados
      for(int i = 0;i < na;i++) //Buscamos el contacto
        if(nombre.equals(contacto[i].getNombre())){ //Lo encontro
          respuesta = true;
          break;
      }
    return respuesta;
  }
    
    public void eliminarTodos(String nombre){
    int i;
    boolean borro = false;
    if(!estaVacio()){ //Si hay Contactos almacenados
      do{
        for(i = 0;i < na;i++) //Buscamos el Contacto
          if(nombre.equals(contacto[i].getNombre())){ //Lo encontro
            if(i == (na - 1)) //El Contacto está al final
              na--;
            else //El Contacto no es el último elemento
              contacto[i] = contacto[--na]; //Deja inaccesible al último valor
            borro = true;
            break;
          }
      }while(contiene(nombre));
      if(!borro) //En caso de que ningún Contacto exista
       out.println("No existe ningun Contacto con el nombre " + nombre + "\n");
    }
    else
      out.println("No hay contactos almacenados\n");
  }
    
    
    private void actualizaAmigo(Contacto b){
    int op,an,on;
    String au;
    Amigos a = (Amigos)b;
    do{
      out.println("1. Nombre");  
      out.println("2. Apodo");
      out.println("3. Telefono de casa");
      out.println("4. Celular");
      out.println("5. Cumpleaños");
      out.println("6. Correo electronico");
      out.println("7. Facebook");
      out.println("8. Twitter");
      out.println("9. Salir");
      out.println("Escribe una opcion:");
      op = lector.nextInt();
      switch(op){
        case 1: //Actualizar Nombre
              out.println("Escribe el nombre del contacto");
              au = lector1.next().toUpperCase();
              a.setNombre(au);
          break;  
        case 2: //Actualizar el apodo
          out.println("Escribe el apodo del contacto");
          au = lector1.next().toUpperCase();
          a.setApodo(au);
        break;
        case 3: //Actualizar el tel casa
          out.println("Escribe el telefono de casa del contacto");
          an = lector.nextInt();
          a.setTelefonoCasa(an);
        break;
        case 4: //Actualizar el celular
          out.println("Escribe el celular");
          an = lector.nextInt();
          a.setCelular(an);
        break;
        case 5: //Actualizar cumpleaños
            out.println("Escriba el día del cumpleaños (número)");
            an = lector.nextInt();
            out.println("Escriba el mes del cumpleaños (número)");
            on = lector.nextInt();
            a.setDiacumpleanos(an);
            a.setMescumpleanos(on);
        break;
        case 6: // Actualizar correo
              out.println("Escribe el correo");
              au = lector1.next().toUpperCase();
              a.setCorreo(au);
          break;
        
        case 7: // Actualizar facebook
              out.println("Escribe el Facebook");
              au = lector1.next().toUpperCase();
              a.setFace(au);
          break;
          
        case 8: // Actualizar correo
              out.println("Escribe el Twitter");
              au = lector1.next().toUpperCase();
              a.setTwitter(au);
          break;
          
        case 9: //Saliendo de menú de actualización
          out.println("Saliendo de edicion de Libro");
        break;
        default: //Control de errores
          out.println("Opción no valida");
      }
    }while(op != 9);
  }
    
    
    
    private void actualizarFamiliares(Contacto b){
int op, an, dia ,mes;
String aux;
Familiares a = (Familiares)b;
do{
out.println("1.Parentesco:");
out.println("2.Nombre:");
out.println("3.Telefono de casa:");
out.println("4.Cumpleaños");
out.println("5.Salir");

out.println("Escribe una opcion");
op = lector.nextInt();
switch(op){

case 1: //Actualizarparentesco
out.println("Escribe el parentesco del familiar");
aux = lector1.next().toUpperCase();
a.setParentezco(aux);
break;

case 2:
out.println("Escriba el nombre del contacto");
aux = lector1.next().toUpperCase();
a.setNombre(aux);
break;

case 3:
out.println("Escriba el telefono de casa del contacto");
an = lector.nextInt();
a.setTelCasa(an);
break;

case 4:
out.println("Escriba el cumpleaños del contacto\n");
out.println("Escriba el dia: ");
dia = lector.nextInt();
out.println("Escriba el mes: ");
mes = lector.nextInt();
a.setDiacumpleanos(dia);
a.setMescumpleanos(mes);
break;

case 5:
out.println("Saliendo de menu actualizar");
break;

default:
out.println("Opcion no valida");
}

}while (op != 5);
    }


    
    public String mostrarCompania(String comp){
      int i;
      String clien = "";
      if(!estaVacio()){ //Si hay contactos
        for(i = 0;i < na;i++) //Lo buscamos
          if(contacto[i] instanceof Clientes &&
             ((Clientes)contacto[i]).getCompañia().equals(comp)) //Si la compania conincide
                clien += ((Clientes)contacto[i]).toString() + "\n********************\n";
        if(clien.equals(""))//No se encontraron clientes
          return "No hay contactos que mostrar!\n********************\n";
        return "Clientes:\n" + clien;
      }
      else
        return "No hay contactos almacenados";
    }
    
    
    private Contacto [] Ordenar() {
        Contacto aux;
        Contacto []x = new Contacto[na];
        //copiamos al nuevo array;
        for(int i = 0; i<na;i++)
            x[i]=contacto[i];
        
        for (int i = 0; i < na-1; i++) 
            for (int j = i + 1; j < na; j++) 
                if (x[i].getNombre().compareToIgnoreCase(x[j].getNombre()) > 0) {
                    aux = x[i];
                    x[i] = x[j];
                    x[j] = aux;
                }
        return x;
            
    } 
    
    private String mostrarAmigos(){
      Contacto [] ord = Ordenar();       
      int i;
      String ami = "";
      if(!estaVacio()){ //Si hay Contactos
        for(i = 0;i < na;i++) //Los recorremos todos
          if(ord[i] instanceof Amigos) //Es amigo
             ami += ((Amigos)ord[i]).toString() + "\n********************\n"; 
        if(ami.equals(""))//No se encontraron amigos
          ami = "No hay amigos que mostrar!\n********************\n";
        
        return ami;
      }
      else
        return null; 
    
    }
    
    private String mostrarFamiliares(){
      Contacto [] ord = Ordenar();       
      int i;
      String fam = "";
      if(!estaVacio()){ //Si hay Contactos
        for(i = 0;i < na;i++) //Los recorremos todos
          if(ord[i] instanceof Familiares) //Es amigo
             fam += ((Familiares)ord[i]).toString() + "\n********************\n"; 
        if(fam.equals(""))//No se encontraron familiares
          fam = "No hay familiares que mostrar!\n********************\n";
        
        return fam;
      }
      else
        return null; 
    
    }
    
    private String mostrarClientes(){
      Contacto [] ord = Ordenar();       
      int i;
      String cli = "";
      if(!estaVacio()){ //Si hay Contactos
        for(i = 0;i < na;i++) //Los recorremos todos
          if(ord[i] instanceof Clientes) //Es cliente
             cli += ((Clientes)ord[i]).toString() + "\n********************\n"; 
        if(cli.equals(""))//No se encontraron clientes
          cli = null;
        
        return  cli;
      }
      else
        return null; 
    
    }
    
    
    public String mostrarCorreo(){
        
        if(!estaVacio()){ //Si hay Contactos
            String correo="\t\tContactos con Correo\n"; 
            if(mostrarClientes()!=null || mostrarAmigos()!=null ){
                if(mostrarClientes()!=null)
                    correo+= "Clientes\n" + mostrarClientes();
                if (mostrarAmigos()!=null)
                    correo+="Amigos\n" + mostrarAmigos();  
            return correo;
            }
            else 
                return "No hay contactos con correo electrónico";  
        }
        else 
            return "No hay contactos almacenados!";
    }
    
    
    public String mostrarFbTw(){
        if(!estaVacio()){
            if(mostrarAmigos()!=null)
                return "\t\tContactos con Facebook y Twitter\n" + mostrarAmigos();
            else
                return "No hay contactos con Facebook y Twitter!";  
        }
        else
            return "No hay contactos almacenados!";
    }
    
    public String mostrarXcategoria(int i){
        switch(i){
            case 1:
                if(mostrarAmigos()==null)
                    return "No tienes contactos de amigos):";
                else
                    return "\t\tAmigos" + mostrarAmigos();
            case 2: 
                if(mostrarFamiliares()==null)
                    return "No tienes contactos de familiares";
                else
                    return "\t\tFamiliares" + mostrarFamiliares();
            case 3: 
                if(mostrarClientes()==null)
                    return "No hay contactos de clientes";
                else
                    return "\t\tClientes" + mostrarClientes();
    }
        return null;
    }
    
    private void eliminarPornumero(int numero){
        int i;
        boolean borra = false;
        if(!estaVacio()){
            for (i = 0; i < na; i++){
                if(contacto[i] instanceof Amigos && (((Amigos)contacto[i]).getCelular() == numero  ||  ((Amigos)contacto[i]).getTelefonoCasa()==numero)){
                    if(i == (na - 1))
                        na--;
                    else
                        contacto[i] = contacto[--na];
     
                    borra = true;
                    break;
                }
   
  
                if(contacto[i]instanceof Familiares && ((Familiares)contacto[i]).getTelCasa() == numero){
                    if(i == (na - 1))
                        na--;
                    else
                        contacto[i] = contacto[--na];
                    borra = true;
                    break;
                }

                if(contacto[i] instanceof Clientes && (((Clientes)contacto[i]).getCelular() == numero || ((Clientes)contacto[i]).getTelefonoOficina()==numero)){
                    if(i == (na - 1))
                        na--;
                    else
                        contacto[i] = contacto[--na];
                    borra = true;
                    break;
                }
            }
            if(i == na && !borra)
                out.println("El numero " + numero + " no está asociado con ningún contacto");
        }else 
            out.println("No hay numeros almacenados");

}
    
    
   private String BuscarPornumero(int numero){
        int i;
        String cont="";
        boolean encontrado = false;
        if(!estaVacio()){
            for (i = 0; i < na; i++){
                if(contacto[i] instanceof Amigos && (((Amigos)contacto[i]).getCelular() == numero  ||  ((Amigos)contacto[i]).getTelefonoCasa()==numero)){
                    cont=((Amigos)contacto[i]).toString();     
                    encontrado = true;
                    break;
                }
   
  
                if(contacto[i]instanceof Familiares && ((Familiares)contacto[i]).getTelCasa() == numero){
                    cont=((Familiares)contacto[i]).toString();     
                    encontrado = true;
                    break;
                }

                if(contacto[i] instanceof Clientes && (((Clientes)contacto[i]).getCelular() == numero || ((Clientes)contacto[i]).getTelefonoOficina()==numero)){
                    cont=((Clientes)contacto[i]).toString();     
                    encontrado = true;
                    break;
                }
            }
            if(i == na && !encontrado)
                return "El numero " + numero +  " no está asociado con ningún contacto";
            else
                return "\t\tContacto encontrado!\n" + cont;
        }else 
            return"No hay numeros almacenados";
}
    
    
    
    
    
    
    
    
    
    
    public int contarLineas(String archivo) throws FileNotFoundException,
            IOException {
        FileReader fr = new FileReader(archivo); //Indentifica el archivo para lectura
        BufferedReader bfr = new BufferedReader(fr); //Se crea el buffer de lectura
        String linea;
        int nlineas = 0;
        linea = bfr.readLine(); //Leemos la primera línea
        while (linea != null) { //Mientras no lleguemos al EOF
            nlineas++; //Contamos la linea leída
            linea = bfr.readLine(); //Leemos la siguiente línea
        }
        return nlineas; //Devolvemos el total de lineas contadas
    }

    public void archivoAArreglo(String archivo) throws FileNotFoundException,
            IOException {
        //Creamos el arreglo en función de las líneas que se hayan leído
        contacto = new Contacto[contarLineas(archivo) + 20];
        FileReader fr = new FileReader(archivo); //Creamos el archivo de lectura
        BufferedReader bfr = new BufferedReader(fr); //Creamos el buffer de lectura
        String linea, cad[];
        linea = bfr.readLine(); //Leemos la primera linea
        while (linea != null) { //Mientras no lleguemos al EOF
            cad = linea.split(","); //Separamos la cadena

            if (cad[0].equals("A"))//Se trata de un Libro
            {
                agregar(new Amigos(cad[1].toUpperCase(),
                        cad[2].toUpperCase(), //Quien lo escribió
                        Integer.parseInt(cad[3]), //Año
                        Integer.parseInt(cad[4]),//Editorial
                        Integer.parseInt(cad[5]),//Pais
                        Integer.parseInt(cad[6]),//Pais
                        cad[7].toUpperCase(),
                        cad[8].toUpperCase(),
                        cad[9].toUpperCase()));
            } else if (cad[0].equals("C"))//Se trata de un Disco
            {
                agregar(new Clientes(cad[1].toUpperCase(), //Titulo
                        cad[2].toUpperCase(), //Quien lo escribió
                        Integer.parseInt(cad[3]), //Año
                        Integer.parseInt(cad[4]),//Editorial
                        Integer.parseInt(cad[5]),//Pais
                        cad[6].toUpperCase(),
                        cad[7].toUpperCase())); //Tema
            } else if (cad[0].equals("F"))//Se trata de una Pelicula
            {
                agregar(new Familiares(cad[1].toUpperCase(), //Título
                        cad[2].toUpperCase(), //Actor principal
                        Integer.parseInt(cad[3]),
                        Integer.parseInt(cad[4]),
                        Integer.parseInt(cad[5])));//Subtitulos
            }

            linea = bfr.readLine(); //Leemos la siguiente línea
        }
    }

    
   
    
}


