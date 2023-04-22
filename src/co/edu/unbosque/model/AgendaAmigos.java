package co.edu.unbosque.model;

import java.util.ArrayList;
import java.io.Serializable;


public class AgendaAmigos implements Serializable {

    private ArrayList<ContactoAmigo> contactosAmigos;

    public AgendaAmigos() {
        contactosAmigos = new ArrayList<ContactoAmigo>();
    }

    public ArrayList<ContactoAmigo> getContactosAmigos() {
        return contactosAmigos;
    }

    public void setContactosAmigos(ArrayList<ContactoAmigo> contactosAmigos) {
        this.contactosAmigos = contactosAmigos;
    }
    

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

