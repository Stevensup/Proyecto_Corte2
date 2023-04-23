package co.edu.unbosque.controller;

import co.edu.unbosque.model.ContactoAmigo;
import co.edu.unbosque.model.ContactoTrabajo;
import co.edu.unbosque.view.VistaConsola;

import java.util.Scanner;
// import co.edu.unbosque.model.ContactoTrabajo;

public class Controller {

    private Scanner scanner;
    private ContactoAmigo Camigo;
    private ContactoTrabajo Ctrabajo;
    private VistaConsola vista;
/**
      * Constructor de la clase Controller, inicializa los modelos a utilizar.
      */
	
    public Controller() {
        scanner = new Scanner(System.in);
        vista = new VistaConsola();
        Camigo = new ContactoAmigo(null, null, null, null);
        Ctrabajo = new ContactoTrabajo(null, null, null, null, null);
       
    }
    /**
	 * Método para listar el menú en consola y seleccionar el algoritmo de ordenamiento a ejecutar.
	 */
    
    public void start() {
        int option = 0;
        do {
            vista.mostrarInformacion("-------------------Escoge una opcion:");
            vista.mostrarInformacion("-------------------1. Ingresar Agenda Contactos Amigos: ");
            vista.mostrarInformacion("-------------------2. Ingresar Agenda Contactos Trabajo");
            vista.mostrarInformacion("-------------------3. Buscar y editar contacto amigo");
            vista.mostrarInformacion("-------------------4. Listar contactos");
            vista.mostrarInformacion("-------------------5. Eliminar contacto");
            vista.mostrarInformacion("-------------------6. Salir");
            System.out.print("-------------------Ingrese la opcion: ");
            option = scanner.nextInt();
            scanner.nextLine(); // consumir el salto de línea pendiente
    /**
	 * Ingreso de datos de un contacto amigo.
	 * @param option La opción seleccionada por el usuario.
	 */
            switch (option) {
                case 1:
                    vista.mostrarInformacion("Ingrese los datos del contacto amigo: ");
    
                    System.out.print("Nombre: ");
                    String nombreAmigo = scanner.nextLine();
                    // Verificar si el nombre contiene caracteres no permitidos
                    while (nombreAmigo.matches(".*\\d.*") || nombreAmigo.matches(".*[^a-zA-Z\\s].*")) {
                        vista.mostrarInformacion("El nombre solo puede contener letras y espacios en blanco. Intente de nuevo.");
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
                            vista.mostrarInformacion("Por favor ingrese solo numeros.");
                            System.out.print("Telefono: ");
                        }
                    }
                    String telefonoAmigo = numeroseparado.substring(0, 3) + "-" + numeroseparado.substring(3, 6) + "-" + numeroseparado.substring(6,9);
                    vista.mostrarInformacion(telefonoAmigo);
    
                    //verificar que el correo cuente con el @
                    System.out.print("Correo: ");
                    String correoAmigo = scanner.nextLine();
                    while (!correoAmigo.contains("@")) {
                        vista.mostrarInformacion("El correo electrónico debe contener el símbolo '@'. Por favor, ingrese un correo válido:");
                        correoAmigo = scanner.nextLine();
                    }

                    vista.mostrarInformacion("Países permitidos: " + Camigo.paises);
                    String paisAmigo = null;
                    while (paisAmigo == null) {
                        System.out.print("Pais: ");
                        String input = scanner.nextLine();
                        if (Camigo.paises.contains(input)) {
                            paisAmigo = input;
                        } else {
                            vista.mostrarInformacion("Pais no valido. Por favor ingrese un pais valido.");
                        }
                    }

    
                    Camigo.agregarContacto(nombreAmigo, telefonoAmigo, correoAmigo, paisAmigo);
                    break;
			
 /**
	 * Ingreso de los datos del contacto de trabajo y los valida.
	 * Si los datos son válidos, se agrega un nuevo contacto de trabajo a Ctrabajo y se persiste la información en un archivo binario.
	 */
			    
                case 2:    
                    vista.mostrarInformacion("Ingrese los datos del contacto de trabajo: ");
                
                    System.out.print("Nombre: ");
                    String nombreTrabajo = scanner.nextLine();
                    // Verificar si el nombre contiene caracteres no permitidos
                    while (nombreTrabajo.matches(".*\\d.*") || nombreTrabajo.matches(".*[^a-zA-Z\\s].*")) {
                        vista.mostrarInformacion("El nombre solo puede contener letras y espacios en blanco. Intente de nuevo.");
                        nombreTrabajo = scanner.nextLine();
                    }
                    
                    System.out.print("Empresa: ");
                    String nombreEmpresa = scanner.nextLine();
                    // Verificar si el nombre contiene caracteres no permitidos
                    while (nombreEmpresa.matches(".*\\d.*") || nombreEmpresa.matches(".*[^a-zA-Z\\s].*")) {
                        vista.mostrarInformacion("El nombre solo puede contener letras y espacios en blanco. Intente de nuevo.");
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
                            vista.mostrarInformacion("Por favor ingrese solo numeros.");
                            System.out.print("Telefono: ");
                        }
                    }
                    String telefonoTrabajo = numeroseparadoTrabajo.substring(0, 3) + "-" + numeroseparadoTrabajo.substring(3, 6) + "-" + numeroseparadoTrabajo.substring(6,9);
                    vista.mostrarInformacion(telefonoTrabajo);
                
                    //verificar que el correo cuente con el @
                    System.out.print("Correo: ");
                    String correoTrabajo = scanner.nextLine();
                    while (!correoTrabajo.contains("@")) {
                        vista.mostrarInformacion("El correo electrónico debe contener el símbolo '@'. Por favor, ingrese un correo válido:");
                        correoTrabajo = scanner.nextLine();
                    }
                
                    vista.mostrarInformacion("Países permitidos: " + Ctrabajo.paises);
                    String paisTrabajo = null;
                    while (paisTrabajo == null) {
                        System.out.print("Pais: ");
                        String input = scanner.nextLine();
                        if (Ctrabajo.paises.contains(input)) {
                            paisTrabajo = input;
                        } else {
                            vista.mostrarInformacion("Pais no valido. Por favor ingrese un pais valido.");
                        }
                    }
                
                    Ctrabajo.agregarContactoTrabajo(nombreTrabajo, nombreEmpresa, telefonoTrabajo, correoTrabajo, paisTrabajo);
                    // Persistir información en archivo binario
                    break;
/**
	 * Método que busca y edita un contacto amigo.
	 * @param scanner objeto Scanner para recibir entrada del usuario.
	 * @param Camigo objeto de la clase AgendaAmigos que contiene los contactos amigos
	 */
                case 3:
                    System.out.print("Ingrese el nombre del contacto amigo a buscar y editar: ");
                    String nombreBuscar = scanner.nextLine();
  		 // Buscar el contacto amigo en la AgendaAmigos
                    ContactoAmigo contacto = Camigo.buscarContacto(nombreBuscar);
                    if (contacto == null) {
                        vista.mostrarInformacion("No se encontró ningún contacto amigo con ese nombre.");
                    } else {
                        vista.mostrarInformacion("Contacto encontrado: " + contacto.toString());
                        vista.mostrarInformacion("Ingrese los nuevos datos del contacto amigo:");
    
                        System.out.print("Nombre: ");
                        String nuevoNombre = scanner.nextLine();
    
                        System.out.print("Telefono: ");
                        String nuevoTelefono = scanner.nextLine();
    
                        System.out.print("Correo: ");
                        String nuevoCorreo = scanner.nextLine();
    
                        System.out.print("Pais: ");
                        String nuevoPais = scanner.nextLine();
    
                        Camigo.editarContacto(nuevoNombre, nuevoTelefono, nuevoCorreo, nuevoPais);
                        vista.mostrarInformacion("Contacto amigo editado exitosamente.");
                    }
                    break;
/**
	 * Método que maneja las opciones del menú principal de la agenda de contactos
	 * @param option La opción seleccionada por el usuario en el menú principal
	 * @param scanner El objeto scanner para leer la entrada del usuario.
	 * @param Camigo El objeto AgendaContactosAmigos para manejar los contactos amigos
	 * @param Ctrabajo El objeto AgendaContactosTrabajo para manejar los contactos de trabajo
	 */	 
			    
                case 4:
                        vista.mostrarInformacion("Lista de contactos: ");
                        Camigo.listarContactos();
                        vista.mostrarInformacion("------------------------------");
                        vista.mostrarInformacion("Lista de contactos trabajo : ");
                        Ctrabajo.listarContactosTrabajo();
                    break;
                    case 5:
                        vista.mostrarInformacion("¿Qué tipo de contacto desea eliminar?");
                        vista.mostrarInformacion("1. Contacto Amigo");
                        vista.mostrarInformacion("2. Contacto Trabajo");
                        int opcion = scanner.nextInt();
                        scanner.nextLine(); // consume the newline character
                    switch (opcion) {
                        case 1:
                            System.out.print("Ingrese el nombre del contacto a eliminar: ");
                            String nombre = scanner.nextLine();
                            boolean eliminadoAmigo = Camigo.eliminarContacto(nombre);
                            if (eliminadoAmigo) {
                                vista.mostrarInformacion("El contacto " + nombre + " ha sido eliminado correctamente.");
                            } else {
                                vista.mostrarInformacion("No se pudo eliminar el contacto " + nombre + ". Verifique que el nombre sea correcto.");
                            }
                            break;
                        case 2:
                            System.out.print("Ingrese el nombre del contacto trabajo a eliminar: ");
                            String nombretrabajo = scanner.nextLine();
                            boolean eliminadoTrabajo = Ctrabajo.eliminarContactoTrabajo(nombretrabajo);
                            if (eliminadoTrabajo) {
                                vista.mostrarInformacion("El contacto trabajo (empresa) " + nombretrabajo + " ha sido eliminado correctamente.");
                            } else {
                                vista.mostrarInformacion("No se pudo eliminar el contacto trabajo " + nombretrabajo + ". Verifique que el nombre sea correcto.");
                            }
                            break;
                        default:
                            vista.mostrarInformacion("Opción inválida.");
                            break;
                    }
                    break;
                case 6:
                    vista.mostrarInformacion("Hasta pronto...");
                    break;
                default:
                    vista.mostrarInformacion("Opcion invalida...");
                    break;
            }
    
        } while (option != 4);
    }
}


