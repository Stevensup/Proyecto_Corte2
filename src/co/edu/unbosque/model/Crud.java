package co.edu.unbosque.model;

public class Crud {
    private List<Amigos> Amigos;

	public Crud() {
		Amigos = new ArrayList<>();
		inicializarPokemones();
	}

	private void inicializarPokemones() {
		Amigos.add(new Agua("Squirtle", "Pistola agua",
				new String[] { "Chorro de agua", "Rayo burbuja", "Pistola agua", "Mordida" }, 60, 70, "Wartortle",
				true));
		Amigos.add(new Agua("Magikarp", "Pistola agua",
				new String[] { "Burbuja", "Salpicadura", "Lanzarrocas", "Mordida" }, 20, 10, "Gyarados", false));
		Amigos.add(new Fuego("Charmander", "Fuego",
				new String[] { "Lanzallamas", "Fogonazo", "Golpe cuerpo", "Mordida" }, 70, 60, "Charmeleon", true));
	}

	private void iniciarPokedex() {
	    System.out.println("Iniciando Pokedex...");
	   // pokedex = new Pokedex(); // crear una instancia de la clase Pokedex y asignarla a la variable pokedex
	}

	public void registrarPokemon(Amigos newPokemon) {
		Amigos.add(newPokemon);
		System.out.println("Pokemon registrado exitosamente.");
	}
}
