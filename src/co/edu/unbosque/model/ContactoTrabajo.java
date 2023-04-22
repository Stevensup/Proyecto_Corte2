package co.edu.unbosque.model;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Arrays;
import java.util.List;


public class ContactoTrabajo implements Serializable {

    private String nombreTrabajo;
    private String telefonoTrabajo;
    private String correoTrabajo;
    private String paisTrabajo;
    private String nombreEmpresa;
    private List<ContactoTrabajo> contactos;
    public static final List<String> paises = Arrays.asList("Colombia", "Venezuela", "Mexico", "Argentina", "Chile", "Peru");


    public ContactoTrabajo(String nombreTrabajo, String nombreEmpresa,  String telefonoTrabajo, String correoTrabajo, String paisTrabajo) {
        this.nombreTrabajo = nombreTrabajo;
        this.telefonoTrabajo = telefonoTrabajo;
        this.correoTrabajo = correoTrabajo;
        this.paisTrabajo = paisTrabajo;
        this.nombreEmpresa= nombreEmpresa;
        this.contactos = contactos;
    }

    public void agregarContactoTrabajo(String nombreTrabajo, String nombreEmpresa, String telefonoTrabajo, String correoTrabajo, String paisTrabajo) {
        AgendaTrabajo agenda = leerDeArchivoDataTrabajo();
        if (agenda == null) {
            agenda = new AgendaTrabajo();
        }
        String[] paisesValidos = {"Colombia", "Venezuela", "México", "Argentina", "Chile", "Perú"};
        if (Arrays.asList(paisesValidos).contains(paisTrabajo)) {
            if (agenda.getContactosTrabajo().size() < 20) {
                ContactoTrabajo nuevoContacto = new ContactoTrabajo(nombreTrabajo, nombreEmpresa, telefonoTrabajo, correoTrabajo, paisTrabajo);
                agenda.getContactosTrabajo().add(nuevoContacto);
                guardarEnArchivoDatTrabajo(agenda);
                System.out.println("Contacto Trabajo agregado exitosamente.");
            } else {
                System.out.println("No es posible agregar más contactos trabajo. La agenda ya está llena.");
            }
        } else {
            System.out.println("País no válido. Por favor ingrese un país válido: ");
        }
    }
    

    public ContactoTrabajo buscarContactoTrabajo(String nombre) {
        AgendaTrabajo agenda = leerDeArchivoDataTrabajo();
        if (agenda != null) {
            for (ContactoTrabajo c : agenda.getContactosTrabajo()) {
                if (c.getNombreEmpresa().equalsIgnoreCase(nombre)) {
                    return c;
                }
            }
        }
        return null;
    }

    public void listarContactosTrabajo() {
        AgendaTrabajo agenda = leerDeArchivoDataTrabajo();
        if (agenda == null || agenda.getContactosTrabajo().isEmpty()) {
            System.out.println("No hay contactos en la agenda trabajo.");
        } else {
            List<ContactoTrabajo> contactos = agenda.getContactosTrabajo();
            int cantidadContactos = contactos.size();
            double porcentajeContactos = ((double) cantidadContactos / 15) * 100;
            for (int i = 0; i < cantidadContactos; i++) {
                System.out.println((i + 1) + ". " + contactos.get(i).toString());
            }
            System.out.println("Cantidad de contactos: " + cantidadContactos);
            System.out.println("Porcentaje de contactos agregados: " + porcentajeContactos + "%");
        }
    }
    
    public void editarContactoTrabajo(String nombre, String telefono, String correo, String pais) {
        AgendaTrabajo agenda = leerDeArchivoDataTrabajo();
        if (agenda != null && agenda.getContactosTrabajo() != null) {
            for (int i = 0; i < agenda.getContactosTrabajo().size(); i++) {
                ContactoTrabajo c = agenda.getContactosTrabajo().get(i);
                if (c.getNombreEmpresa().equalsIgnoreCase(nombre)) {
                    c.setNombreTrabajo(nombre);
                    c.setTelefonoTrabajo(telefono);
                    c.setCorreoTrabajo(correo);
                    c.setPaisTrabajo(pais);
                    guardarEnArchivoDatTrabajo(null);
                    System.out.println("Contacto trabajo editado exitosamente.");
                    return;
                }
            }
            System.out.println("No se encontró ningún contacto con el nombre ingresado.");
        } else {
            System.out.println("No se pudo leer la lista de contactos de trabajo del archivo trabajo.data.");
        }
    }
     

    public boolean eliminarContactoTrabajo(String nombreTrabajo) {
        AgendaTrabajo agenda = leerDeArchivoDataTrabajo();
        if (agenda != null) {
            for (ContactoTrabajo c : agenda.getContactosTrabajo()) {
                if (c.getNombreEmpresa().equalsIgnoreCase(nombreTrabajo)) {
                    agenda.getContactosTrabajo().remove(c);
                    guardarEnArchivoDatTrabajo(agenda);
                    System.out.println("Contacto eliminado exitosamente.");
                    return true;
                }
            }
            System.out.println("No se encontró ningún contacto con el nombre ingresado.");
        }
        return false;
    }


    public AgendaTrabajo leerDeArchivoDataTrabajo() {
        AgendaTrabajo agenda = null;
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("trabajo.data"))) {
            agenda = (AgendaTrabajo) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Error al leer la lista de contactos de trabajo del archivo trabajo.data: " + e.getMessage());
        }
        return agenda;
    }
    
    public void guardarEnArchivoDatTrabajo(AgendaTrabajo agenda) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("trabajo.data"))) {
            oos.writeObject(agenda);
        } catch (IOException e) {
            System.out.println("Error al guardar la lista de contactos de trabajo en el archivo trabajo.data: " + e.getMessage());
        }
    }


    public String getNombreTrabajo() {
        return this.nombreTrabajo;
    }

    public void setNombreTrabajo(String nombreTrabajo) {
        this.nombreTrabajo = nombreTrabajo;
    }

    public String getTelefonoTrabajo() {
        return this.telefonoTrabajo;
    }

    public void setTelefonoTrabajo(String telefonoTrabajo) {
        this.telefonoTrabajo = telefonoTrabajo;
    }

    public String getCorreoTrabajo() {
        return this.correoTrabajo;
    }

    public void setCorreoTrabajo(String correoTrabajo) {
        this.correoTrabajo = correoTrabajo;
    }

    public String getPaisTrabajo() {
        return this.paisTrabajo;
    }

    public void setPaisTrabajo(String paisTrabajo) {
        this.paisTrabajo = paisTrabajo;
    }

    public String getNombreEmpresa() {
        return this.nombreEmpresa;
    }

    public void setNombreEmpresa(String nombreEmpresa) {
        this.nombreEmpresa = nombreEmpresa;
    }

    public List<ContactoTrabajo> getContactos() {
        return this.contactos;
    }

    public void setContactos(List<ContactoTrabajo> contactos) {
        this.contactos = contactos;
    }
   

    @Override
        public String toString() {
            return "Nombre: " + nombreTrabajo + ", Nombre Empresa: "+ nombreEmpresa + ", Teléfono: " + telefonoTrabajo + ", Correo: " + correoTrabajo + ", País: " + paisTrabajo;
        }

}

