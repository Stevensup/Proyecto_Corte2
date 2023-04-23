package co.edu.unbosque.view;

import java.util.Scanner;
/**
     * Esta clase representa la vista de consola de la aplicación. Permite mostrar mensajes al usuario y leer datos desde la entrada estándar.
     */
public class VistaConsola{

	private Scanner leer;
/**
     * Constructor de la clase VistaConsola. Inicializa el Scanner para leer datos desde la entrada estándar.
     */

	public VistaConsola() {

		leer = new Scanner(System.in);
	}
/**
     * Muestra un mensaje por pantalla.
     * @param mensaje El mensaje a mostrar por pantalla.
     */
	public void mostrarInformacion(String mensaje) {
		System.out.println(mensaje);
	}
/**
     * Lee un entero desde la entrada estándar.
     * @param mensaje El mensaje a mostrar por pantalla antes de leer el entero.
     * @return El entero leído desde la entrada estándar.
     */
	public int leerDato(String mensaje) {
		mostrarInformacion(mensaje);
		int n = leer.nextInt();
		return n;
	}
 /**
     * Retorna el Scanner utilizado para leer datos desde la entrada estándar.
     * @return El Scanner utilizado para leer datos desde la entrada estándar.
     */
	public Scanner getLeer() {
		return leer;
	}
 /**
     * Establece el Scanner utilizado para leer datos desde la entrada estándar.
     * @param leer El nuevo Scanner a utilizar.
     */
	public void setLeer(Scanner leer) {
		this.leer = leer;
	}

}
