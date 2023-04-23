package co.edu.unbosque.model;

import java.util.ArrayList;
import java.io.Serializable;

/**
     * Clase AgendaTrabajo implementa la interfaz "Serializable". Los objetos de esta clase pueden ser serializados o deserializados.
     */

public class AgendaTrabajo implements Serializable {

    private ArrayList<ContactoTrabajo> contactosTrabajo;
    
    /**
     * Constructor que inicializa la lista de contactos de trabajo vacia.
     */

    public AgendaTrabajo() {
        contactosTrabajo = new ArrayList<ContactoTrabajo>();
    }
/**
     * Método que devuelve la lista de contacto de trabajo almacenado en la agenda.
     * @return la lista de contactos de trabajo almacenados en la agenda.
     */
    public ArrayList<ContactoTrabajo> getContactosTrabajo() {
        return contactosTrabajo;
    }
/**
     * Método que establece la lista de contacto de trabajo almacenados en la agenda.
     * @param contactosTrabajo la nueva lista de contactos de trabajo a almacenar en la agenda.
     */
    public void setContactosTrabajo(ArrayList<ContactoTrabajo> contactosTrabajo) {
        this.contactosTrabajo = contactosTrabajo;
    }
    
 /**
     * Método toString devuelve una cadena de texto que representa la agenda de trabajo.
     * @return Cadena de texto que representa la agenda de trabajo.
     */
    
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Agenda de Trabajo:\n");
        for (ContactoTrabajo c : contactosTrabajo) {
            sb.append("Nombre: ").append(c.getCorreoTrabajo()).append(", ");
            sb.append("Empresa: ").append(c.getNombreEmpresa()).append(", ");
            sb.append("Teléfono: ").append(c.getTelefonoTrabajo()).append(", ");
            sb.append("Correo: ").append(c.getCorreoTrabajo()).append(", ");
            sb.append("País: ").append(c.getPaisTrabajo()).append("\n");
        }
        return sb.toString();
    }
}

