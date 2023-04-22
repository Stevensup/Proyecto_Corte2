package co.edu.unbosque.model;

import java.util.ArrayList;
import java.io.Serializable;


public class AgendaTrabajo implements Serializable {

    private ArrayList<ContactoTrabajo> contactosTrabajo;

    public AgendaTrabajo() {
        contactosTrabajo = new ArrayList<ContactoTrabajo>();
    }

    public ArrayList<ContactoTrabajo> getContactosTrabajo() {
        return contactosTrabajo;
    }

    public void setContactosTrabajo(ArrayList<ContactoTrabajo> contactosTrabajo) {
        this.contactosTrabajo = contactosTrabajo;
    }
    

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

