package co.edu.unbosque.controller;

import co.edu.unbosque.model.ContactoAmigo;
import java.util.Scanner;
// import co.edu.unbosque.model.ContactoTrabajo;

public class Controller {

    private Scanner scanner;
    private ContactoAmigo Camigo;
    // private ContactoTrabajo Ctrabajo;

    public Controller() {
        scanner = new Scanner(System.in);
        Camigo = new ContactoAmigo(null, null, null, null);
        // Ctrabajo = new ContactoTrabajo(null, null, null, null);
       
    }
    /**
	 * Método start para listar el menú en consola y seleccionar el algoritmo de ordenamiento a ejecutar.
	 */
    
    public void start() {
        int option = 0;
        do {
            System.out.println("-------------------Escoge una opcion:");
            System.out.println("-------------------1. Ingresar Agenda Contactos Amigos: ");
            System.out.println("-------------------2. Ingresar Agenda Contactos Trabajo");
            System.out.println("-------------------3. Buscar y editar contacto amigo");
            System.out.println("-------------------4. Listar contactos");
            System.out.println("-------------------5. Salir");
            System.out.print("-------------------Ingrese la opcion: ");
            option = scanner.nextInt();
            scanner.nextLine(); // consumir el salto de línea pendiente
    
            switch (option) {
                case 1:
                    System.out.println("Ingrese los datos del contacto amigo: ");
    
                    System.out.print("Nombre: ");
                    String nombreAmigo = scanner.nextLine();
                    // Verificar si el nombre contiene caracteres no permitidos
                    while (nombreAmigo.matches(".*\\d.*") || nombreAmigo.matches(".*[^a-zA-Z\\s].*")) {
                        System.out.println("El nombre solo puede contener letras y espacios en blanco. Intente de nuevo.");
                        nombreAmigo = scanner.nextLine();
                    }
                    // Verificar si el telefono contiene letras o caracteres no permitidos
                    System.out.print("Telefono: ");
                    String numeroseparado = "";
                    boolean esNumerico = false;
                    while (!esNumerico) {
                        numeroseparado = scanner.nextLine();
                        if (numeroseparado.matches("[0-9]+")) {
                            esNumerico = true;
                        } else {
                            System.out.println("Por favor ingrese solo numeros.");
                            System.out.print("Telefono: ");
                        }
                    }
                    String telefonoAmigo = numeroseparado.substring(0, 3) + "-" + numeroseparado.substring(3, 6) + "-" + numeroseparado.substring(6,9);
                    System.out.println(telefonoAmigo);
    
                    //verificar que el correo cuente con el @
                    System.out.print("Correo: ");
                    String correoAmigo = scanner.nextLine();
                    while (!correoAmigo.contains("@")) {
                        System.out.println("El correo electrónico debe contener el símbolo '@'. Por favor, ingrese un correo válido:");
                        correoAmigo = scanner.nextLine();
                    }

                    System.out.println("Países permitidos: " + Camigo.paises);
                    String paisAmigo = null;
                    while (paisAmigo == null) {
                        System.out.print("Pais: ");
                        String input = scanner.nextLine();
                        if (Camigo.paises.contains(input)) {
                            paisAmigo = input;
                        } else {
                            System.out.println("Pais no valido. Por favor ingrese un pais valido.");
                        }
                    }

    
                    Camigo.agregarContacto(nombreAmigo, telefonoAmigo, correoAmigo, paisAmigo);
                    break;
                case 2:
                    System.out.println("Ingrese los datos del contacto de trabajo: ");
    
                    System.out.print("Nombre: ");
                    String nombreTrabajo = scanner.nextLine();
    
                    System.out.print("Telefono: ");
                    String telefonoTrabajo = scanner.nextLine();
    
                    System.out.print("Correo: ");
                    String correoTrabajo = scanner.nextLine();
    
                    System.out.print("Pais: ");
                    String paisTrabajo = scanner.nextLine();
    
    
                    // Ctrabajo.agregarContactoTrabajo(nombreTrabajo, telefonoTrabajo, correoTrabajo, paisTrabajo);
                    break;
                case 3:
                    System.out.print("Ingrese el nombre del contacto amigo a buscar y editar: ");
                    String nombreBuscar = scanner.nextLine();
    
                    ContactoAmigo contacto = Camigo.buscarContacto(nombreBuscar);
                    if (contacto == null) {
                        System.out.println("No se encontró ningún contacto amigo con ese nombre.");
                    } else {
                        System.out.println("Contacto encontrado: " + contacto.toString());
                        System.out.println("Ingrese los nuevos datos del contacto amigo:");
    
                        System.out.print("Nombre: ");
                        String nuevoNombre = scanner.nextLine();
    
                        System.out.print("Telefono: ");
                        String nuevoTelefono = scanner.nextLine();
    
                        System.out.print("Correo: ");
                        String nuevoCorreo = scanner.nextLine();
    
                        System.out.print("Pais: ");
                        String nuevoPais = scanner.nextLine();
    
                        Camigo.editarContacto(nuevoNombre, nuevoTelefono, nuevoCorreo, nuevoPais);
                        System.out.println("Contacto amigo editado exitosamente.");
                    }
                    break;
                case 4:
                    System.out.println("Lista de contactos: ");
                    Camigo.listarContactos();
                    break;
                case 5:
                    System.out.println("Hasta pronto...");
                    break;
                default:
                    System.out.println("Opcion invalida...");
                    break;
            }
    
        } while (option != 4);
    }
}


