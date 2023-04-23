package co.edu.unbosque.controller;

public class AplMain {

	/**
 * Método principal que inicia la aplicación.
 * Crea un objeto de la clase Controller y llama a su método run() para manejar
 * la lógica del programa.
 * 
 * @param args Argumentos de línea de comando (no se utilizan).
 */
	
	public static void main(String[] args) {
		Controller control = new Controller();
		control.start();
	}

}
