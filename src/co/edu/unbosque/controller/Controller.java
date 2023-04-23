package co.edu.unbosque.controller;

import co.edu.unbosque.model.ContactoAmigo;
import co.edu.unbosque.model.ContactoTrabajo;

import java.util.Scanner;
// import co.edu.unbosque.model.ContactoTrabajo;

public class Controller {

    private Scanner scanner;
    private ContactoAmigo Camigo;
    private ContactoTrabajo Ctrabajo;

    public Controller() {
        scanner = new Scanner(System.in);
        Camigo = new ContactoAmigo(null, null, null, null);
        Ctrabajo = new ContactoTrabajo(null, null, null, null, null);
       
    }
    /**
	 * Método para listar el menú en consola y seleccionar el algoritmo de ordenamiento a ejecutar.
	 */
    
    public void start() {
        int option = 0;
        do {
            System.out.println("-------------------Escoge una opcion:");
            System.out.println("-------------------1. Ingresar Agenda Contactos Amigos: ");
            System.out.println("-------------------2. Ingresar Agenda Contactos Trabajo");
            System.out.println("-------------------3. Buscar y editar contacto amigo");
            System.out.println("-------------------4. Listar contactos");
            System.out.println("-------------------5. Eliminar contacto");
            System.out.println("-------------------6. Salir");
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
                    // Verificar si el nombre contiene caracteres no permitidos
                    while (nombreTrabajo.matches(".*\\d.*") || nombreTrabajo.matches(".*[^a-zA-Z\\s].*")) {
                        System.out.println("El nombre solo puede contener letras y espacios en blanco. Intente de nuevo.");
                        nombreTrabajo = scanner.nextLine();
                    }
                    
                    System.out.print("Empresa: ");
                    String nombreEmpresa = scanner.nextLine();
                    // Verificar si el nombre contiene caracteres no permitidos
                    while (nombreEmpresa.matches(".*\\d.*") || nombreEmpresa.matches(".*[^a-zA-Z\\s].*")) {
                        System.out.println("El nombre solo puede contener letras y espacios en blanco. Intente de nuevo.");
                        nombreEmpresa = scanner.nextLine();
                    }
                    // Verificar si el telefono contiene letras o caracteres no permitidos
                    System.out.print("Telefono: ");
                    String numeroseparadoTrabajo = "";
                    boolean esNumericoTrabajo = false;
                    while (!esNumericoTrabajo) {
                        numeroseparadoTrabajo = scanner.nextLine();
                        if (numeroseparadoTrabajo.matches("[0-9]+")) {
                            esNumericoTrabajo = true;
                        } else {
                            System.out.println("Por favor ingrese solo numeros.");
                            System.out.print("Telefono: ");
                        }
                    }
                    String telefonoTrabajo = numeroseparadoTrabajo.substring(0, 3) + "-" + numeroseparadoTrabajo.substring(3, 6) + "-" + numeroseparadoTrabajo.substring(6,9);
                    System.out.println(telefonoTrabajo);
                
                    //verificar que el correo cuente con el @
                    System.out.print("Correo: ");
                    String correoTrabajo = scanner.nextLine();
                    while (!correoTrabajo.contains("@")) {
                        System.out.println("El correo electrónico debe contener el símbolo '@'. Por favor, ingrese un correo válido:");
                        correoTrabajo = scanner.nextLine();
                    }
                
                    System.out.println("Países permitidos: " + Ctrabajo.paises);
                    String paisTrabajo = null;
                    while (paisTrabajo == null) {
                        System.out.print("Pais: ");
                        String input = scanner.nextLine();
                        if (Ctrabajo.paises.contains(input)) {
                            paisTrabajo = input;
                        } else {
                            System.out.println("Pais no valido. Por favor ingrese un pais valido.");
                        }
                    }
                
                    Ctrabajo.agregarContactoTrabajo(nombreTrabajo, nombreEmpresa, telefonoTrabajo, correoTrabajo, paisTrabajo);
                    // Persistir información en archivo binario
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
                        System.out.println("------------------------------");
                        System.out.println("Lista de contactos trabajo : ");
                        Ctrabajo.listarContactosTrabajo();
                    break;
                    case 5:
                        System.out.println("¿Qué tipo de contacto desea eliminar?");
                        System.out.println("1. Contacto Amigo");
                        System.out.println("2. Contacto Trabajo");
                        int opcion = scanner.nextInt();
                        scanner.nextLine(); // consume the newline character
                    switch (opcion) {
                        case 1:
                            System.out.print("Ingrese el nombre del contacto a eliminar: ");
                            String nombre = scanner.nextLine();
                            boolean eliminadoAmigo = Camigo.eliminarContacto(nombre);
                            if (eliminadoAmigo) {
                                System.out.println("El contacto " + nombre + " ha sido eliminado correctamente.");
                            } else {
                                System.out.println("No se pudo eliminar el contacto " + nombre + ". Verifique que el nombre sea correcto.");
                            }
                            break;
                        case 2:
                            System.out.print("Ingrese el nombre del contacto trabajo a eliminar: ");
                            String nombretrabajo = scanner.nextLine();
                            boolean eliminadoTrabajo = Ctrabajo.eliminarContactoTrabajo(nombretrabajo);
                            if (eliminadoTrabajo) {
                                System.out.println("El contacto trabajo (empresa) " + nombretrabajo + " ha sido eliminado correctamente.");
                            } else {
                                System.out.println("No se pudo eliminar el contacto trabajo " + nombretrabajo + ". Verifique que el nombre sea correcto.");
                            }
                            break;
                        default:
                            System.out.println("Opción inválida.");
                            break;
                    }
                    break;
                case 6:
                    System.out.println("Hasta pronto...");
                    break;
                default:
                    System.out.println("Opcion invalida...");
                    break;
            }
    
        } while (option != 4);
    }
}


