package co.edu.unbosque.controller;

import java.util.Scanner;

import co.edu.unbosque.view.VistaConsola;

public class Controller {

    private VistaConsola console;
    private Scanner scanner;

    public Controller() {
        console = new VistaConsola();
        scanner = new Scanner(System.in);
    }

    public void start() {
        int option = 0;
        do {
            System.out.println("-------------------Escoge una opcion:");
            System.out.println("-------------------1. Registrar");
            System.out.println("-------------------2. Buscar");
            System.out.println("-------------------3. Listar");
            System.out.println("-------------------4. Borrar");
            System.out.println("-------------------5. Salir");
            System.out.print("-------------------Ingrese la opcion: ");
            option = scanner.nextInt();
            scanner.nextLine(); // consumir el salto de línea pendiente

            switch (option) {
                case 1:
                    System.out.println("Ingrese los datos: ");
                    System.out.print("Nombre: ");
                    String nombre = scanner.nextLine();
                    System.out.print("Tipo: ");
                    String tipo = scanner.nextLine();
                    System.out.print("Habilidades (separadas por comas): ");
                    String[] habilidades = scanner.nextLine().split(",");
                    System.out.print("Ataque: ");
                    int ataque = scanner.nextInt();
                    System.out.print("Defensa: ");
                    int defensa = scanner.nextInt();
                    scanner.nextLine(); // consumir el salto de línea pendiente
                    System.out.print("Nombre de la evolución: ");
                    String nombreEvolucion = scanner.nextLine();
                    // Pokemon nuevoPokemon = new Pokemon(nombre, tipo, habilidades, ataque, defensa, nombreEvolucion);
                    // pok.registerNewPokemon(nuevoPokemon);
                    break;
                case 2:
                    System.out.print("Ingrese el nombre del pokemon a buscar: ");
                    String nombreBuscar = scanner.nextLine();
                    // Pokemon pokemonEncontrado = pok.searchPokemonByName(nombreBuscar);
                    // if (pokemonEncontrado != null) {
                    //     System.out.println("Pokemon encontrado: " + pokemonEncontrado.toString());
                    // } else {
                    //     System.out.println("Pokemon no encontrado.");
                    // }
                    // break;
                case 3:
                    System.out.print("Ingrese el tipo de Pokemon: ");
                    String tipoPokemon = scanner.nextLine();
                    // ArrayList<Pokemon> pokemonesTipo = pok.filtrarPorTipo(tipoPokemon);
                    // for (Pokemon pokemon : pokemonesTipo) {
                    //     System.out.println(pokemon.toString());
                    // }
                    break;
                case 4:
                    System.out.print("Ingrese el nombre del pokemon a eliminar: ");
                    String nombreEliminar = scanner.nextLine();
                    // Pokemon pokemonEliminar = pok.searchPokemonByName(nombreEliminar);
                    // if (pokemonEliminar != null) {
                    //     pok.deletePokemon(pokemonEliminar);
                    //     System.out.println("Pokemon eliminado exitosamente.");
                    // } else {
                    //     System.out.println("Pokemon no encontrado.");
                    // }
                    break;
                case 5:
                    System.out.println("Hasta pronto...");
                    break;
                default:
                    System.out.println("Opcion invalida...");
                    break;
            }

        } while (option != 5);
    }

}
