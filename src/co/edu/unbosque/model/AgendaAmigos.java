package co.edu.unbosque.model;

import java.util.ArrayList;
import java.io.Serializable;

 /**
     * Clase AgendaAmigos implementa la interfaz "Serializable". Los objetos de esta clase pueden ser serializados o deserializados.
     */
public class AgendaAmigos implements Serializable {

    private ArrayList<ContactoAmigo> contactosAmigos;
/**
     * Constructor que inicializa la lista de contactos de amigos vacia.
     */

    public AgendaAmigos() {
        contactosAmigos = new ArrayList<ContactoAmigo>();
    }
/**
     * Método que devuelve la lista de contacto de amigos almacenado en la agenda.
     * @return la lista de contactos de amigos almacenados en la agenda.
     */
    public ArrayList<ContactoAmigo> getContactosAmigos() {
        return contactosAmigos;
    }
  /**
     * Método que establece la lista de contacto de amigos almacenados en la agenda.
     * @param contactosAmigos la nueva lista de contactos de amigos a almacenar en la agenda.
     */
    public void setContactosAmigos(ArrayList<ContactoAmigo> contactosAmigos) {
        this.contactosAmigos = contactosAmigos;
    }
    
/**
     * Método toString devuelve una cadena de texto que representa la agenda de amigos.
     * @return Cadena de texto que representa la agenda de amigos.
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Agenda de amigos:\n");
        for (ContactoAmigo c : contactosAmigos) {
            sb.append("Nombre: ").append(c.getNombre()).append(", ");
            sb.append("Teléfono: ").append(c.getTelefono()).append(", ");
            sb.append("Correo: ").append(c.getCorreo()).append(", ");
            sb.append("País: ").append(c.getPais()).append("\n");
        }
        return sb.toString();
    }
}

