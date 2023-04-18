package co.edu.unbosque.controller;

import java.util.Scanner;

import co.edu.unbosque.model.Crud;

public class Controller {

    private Scanner scanner;
    private Crud crud;

    public Controller() {
        scanner = new Scanner(System.in);
        crud = new Crud();
    }

    public void start() {
        int option = 0;
        do {
            System.out.println("-------------------Escoge una opcion:");
            System.out.println("-------------------1. Registrar");
            System.out.println("-------------------2. Buscar");
            System.out.println("-------------------3. Listar");
            System.out.println("-------------------4. Modificar");
            System.out.println("-------------------5. Borrar");
            System.out.println("-------------------6. Salir");
            System.out.print("-------------------Ingrese la opcion: ");
            option = scanner.nextInt();
            scanner.nextLine(); // consumir el salto de línea pendiente

            switch (option) {
                case 1:
                    System.out.println("Ingrese los datos: ");

                    System.out.print("Nombre: ");
                    String nombre = scanner.nextLine();

                    System.out.print("Pais: ");
                    String pais = scanner.nextLine();

                    System.out.print("telefono: ");
                    String telefono = scanner.nextLine();

                    System.out.print("correo: ");
                    int correo = scanner.nextInt();

                    scanner.nextLine(); // consumir el salto de línea pendiente

                    // Pokemon nuevoPokemon = new Pokemon(nombre, pais, telefono, correo);
                    // crud.registerNewPokemon(nuevoPokemon);
                    break;
                    break;
                case 2:
                    System.out.print("Ingrese el nombre del pokemon a buscar: ");
                    break;
                case 3:
                    System.out.print("Ingrese el tipo de Pokemon: ");
                    break;
                case 4:
                    System.out.print("Ingrese el nombre del pokemon a eliminar: ");
                    break;
                case 5:
                    System.out.println("Hasta pronto...");
                    break;
                case 6:
                    System.out.println("Hasta pronto...");
                    break;
                default:
                    System.out.println("Opcion invalida...");
                    break;
            }

        } while (option != 5);
    }

}
