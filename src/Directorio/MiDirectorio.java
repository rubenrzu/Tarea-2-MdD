package Directorio;

import java.io.FileNotFoundException;
import java.io.IOException;
import static java.lang.System.in;
import java.util.Scanner;

/**
 *
 * @author HP CSS30IXX
 */
public class MiDirectorio {

    public static void main(String[] args) throws FileNotFoundException,
            IOException {
        String nombre, apodo, correo, face, twit, parentezco, compañia, paginaWeb;
        int opcion, nart, telefonoCasa, cel, dia, mes, telefonoOficina, extension, op1, op2;
        Menus m = new Menus();
        Directorio directorio = null;
        Scanner lector = new Scanner(System.in);
        Scanner lector1 = new Scanner(in).useDelimiter("\n");
        String archivo = null;
        boolean cond = true;
        boolean cond1 = true;
        do {
            System.out.println("\t*********BIENVENIDO*******");
            System.out.println("a. Cargar un contacto");
            System.out.println("b. Agregar contactos directamente");
            System.out.println("Escriba una opcion: ");
            opcion = lector.next().toLowerCase().charAt(0);
            switch (opcion) {
                case 'a':
                    directorio = new Directorio();
                    System.out.println("Escribe el nombre del contacto");
                    archivo = lector.next();
                    directorio.archivoAArreglo(archivo);
                    cond1 = false;
                    break;
                case 'b':
                    System.out.println("Numero de contactos a almacenar:");
                    nart = lector.nextInt();
                    directorio = new Directorio(nart);
                    cond1 = false;
                    break;
                default:
                    System.out.println("Opcion invalida!");
                    break;
            }
        } while (cond1);

        do {
            m.menuprincipal();
            System.out.println("Ingrese el numero de la opcion que desee");
            op1 = lector.nextInt();
            switch (op1) {
                case 1:
                    do {
                        m.menuContactos();
                        op2 = lector.nextInt();
                        switch (op2) {
                            case 1:
                                System.out.println("Escriba el nombre:");
                                nombre = lector1.next().toUpperCase();
                                System.out.println("Ponga su apodo:");
                                apodo = lector1.next().toUpperCase();
                                System.out.print("Ingresa el telefono de casa\n(55)");
                                telefonoCasa = lector.nextInt();
                                System.out.print("Ingresa el celular de " + nombre + "\n(55)");
                                cel = lector.nextInt();
                                System.out.println("Ingresa el cumpleaños de " + nombre);
                                System.out.println("Dia:");
                                dia = lector.nextInt();
                                System.out.println("Mes:");
                                m.menuMeses();
                                mes = lector.nextInt();
                                System.out.println("Ingrese su correo");
                                correo = lector1.next().toUpperCase();
                                System.out.println("Ingrese su Facebook");
                                face = lector1.next().toUpperCase();
                                System.out.println("Ingrese su Twitter");
                                twit = lector1.next().toUpperCase();
                                directorio.agregar(new Amigos(nombre, apodo, telefonoCasa, cel,
                                        dia, mes, correo, face, twit));

                                break;
                            case 2:
                                System.out.println("Escriba el nombre:");
                                nombre = lector1.next().toUpperCase();
                                System.out.println("Ponga el parentezco que tiene con su familar:");
                                parentezco = lector1.next().toUpperCase();
                                System.out.print("Ingresa el telefono de casa\n(55)");
                                telefonoCasa = lector.nextInt();
                                System.out.println("Ingresa el cumpleaños de tu " + parentezco);
                                System.out.println("Dia:");
                                dia = lector.nextInt();
                                System.out.println("Mes:");
                                m.menuMeses();
                                mes = lector.nextInt();
//                                directorio.agregar(new Familiares(nombre, parentezco,
//                                        telefonoCasa, dia, mes));
                                break;
                            case 3:
                                System.out.println("Escriba el nombre:");
                                nombre = lector1.next().toUpperCase();
                                System.out.println("Compañia en la que labora:");
                                compañia = lector1.next().toUpperCase();
                                System.out.print("Ingresa el telefono de Oficina:\n(55)");
                                telefonoOficina = lector.nextInt();
                                System.out.print("Extension:(Ext)");
                                extension = lector.nextInt();
                                System.out.print("Ingresa el celular de:" + nombre + "\n(55)");
                                cel = lector.nextInt();
                                System.out.println("Ingrese su correo");
                                correo = lector1.next().toUpperCase();
                                System.out.println("Ingrese la pagina Web de " + nombre);
                                paginaWeb = lector1.next().toUpperCase();
                                directorio.agregar(new Clientes(nombre, compañia, telefonoOficina, extension, cel,
                                        correo, paginaWeb));
                                break;
                            case 4: //Salir
                                System.out.println("Saliendo del menu agregar");
                                break;
                            default:
                                System.out.println("Opcion invalida!");
                                break;
                        }

                    } while (op2 != 4);
                    break;

                case 2: //Eliminar 
                    do {
                        if (directorio.estaVacio()) {
                            System.out.println("No hay ningun articulo almacenado");
                            break; //regresamos al menu principal
                        }
                        m.menuEliminar();
                        opcion = lector.nextInt();
                        switch (opcion) {
                            case 1: //primer contacto
                                System.out.println("Ingresa el nombtre del contacto que deseas eliminar:");
                                nombre = lector1.next().toUpperCase();
//                                directorio.eliminarPrimero(nombre);
                                break;

                            case 2: //eliminar todos los contactos
                                System.out.println("Ingresa el nombre de los contactos que desea eliminar:");
                                nombre = lector1.next().toUpperCase();
                                //                            directorio.eliminarTodos(nombre);
                                break;

                            case 3: //Eliminar amigo dando el nombre
                                System.out.println("Dame el nombre del amigo que quieres eliminar");
                                nombre = lector1.next().toUpperCase();
                                //                            directorio.eliminarAmigo(nombre);
                                break;

                            case 4: // Eliminar cliente dado el nombre
                                System.out.println("Dame el nombre del cliente que desee eliminar");
                                nombre = lector1.next().toUpperCase();
                                //                             directorio.eliminarCliente(nombre);
                                break;

                            case 5: //Elimina familiar dando el nombre
                                System.out.println("Dame el nombre del familiar que desea eliminar");
                                nombre = lector1.next().toUpperCase();
                                //                           directorio.eliminarFamiliar(nombre);
                                break;

                            case 6: //eliminar todos los amigos
                                //                               directorio.eliminarTodoAmigos();
                                break;

                            case 7: //Eliminar todos los clientes
                                //                              directorio.eliminarTodoClientes();
                                break;

                            case 8: //Eliminar todos los familiares
                                //                               directorio.eliminarTodoFamiliares();
                                break;

                            case 9: //salir 
                                System.out.println("Saliendo del menu eliminar");
                                break;

                            default: //control de errores
                                System.out.println("Opcion invalida!");
                                break;
                        }

                    } while (opcion != 9);
                    break;
            }
            cond = false;

        } while (cond);
    }

}
