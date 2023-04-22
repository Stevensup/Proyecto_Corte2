package co.edu.unbosque.model;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Arrays;
import java.util.List;


public class ContactoAmigo implements Serializable {

    private String nombre;
    private String telefono;
    private String correo;
    private String pais;
    private List<ContactoAmigo> contactos;
    public static final List<String> paises = Arrays.asList("Colombia", "Venezuela", "México", "Argentina", "Chile", "Perú");


    public ContactoAmigo(String nombre, String telefono, String correo, String pais) {
        this.nombre = nombre;
        this.telefono = telefono;
        this.correo = correo;
        this.pais = pais;
        this.contactos = contactos;
    }

    public void agregarContacto(String nombreAmigo, String telefonoAmigo, String correoAmigo, String paisAmigo) {
        AgendaAmigos agenda = leerDeArchivoData();
        if (agenda == null) {
            agenda = new AgendaAmigos();
        }
        String[] paisesValidos = {"colombia", "venezuela", "méxico", "argentina", "chile", "perú"};
        if (Arrays.asList(paisesValidos).contains(paisAmigo.toLowerCase())) {
            if (agenda.getContactosAmigos().size() < 15) {
                ContactoAmigo nuevoContacto = new ContactoAmigo(nombreAmigo, telefonoAmigo, correoAmigo, paisAmigo);
                agenda.getContactosAmigos().add(nuevoContacto);
                guardarEnArchivoData(agenda);
                System.out.println("Contacto agregado exitosamente.");
            } else {
                System.out.println("No es posible agregar más contactos amigos. La agenda ya está llena.");
            }
        } else {
            System.out.println("País no válido. Por favor ingrese un país válido: ");
        }
    }

    public ContactoAmigo buscarContacto(String nombre) {
        AgendaAmigos agenda = leerDeArchivoData();
        if (agenda != null) {
            for (ContactoAmigo c : agenda.getContactosAmigos()) {
                if (c.getNombre().equalsIgnoreCase(nombre)) {
                    return c;
                }
            }
        }
        return null;
    }

    public void listarContactos() {
        AgendaAmigos agenda = leerDeArchivoData();
        if (agenda == null || agenda.getContactosAmigos().isEmpty()) {
            System.out.println("No hay contactos en la agenda.");
        } else {
            List<ContactoAmigo> contactos = agenda.getContactosAmigos();
            int cantidadContactos = contactos.size();
            double porcentajeContactos = ((double) cantidadContactos / 15) * 100;
            for (int i = 0; i < cantidadContactos; i++) {
                System.out.println((i + 1) + ". " + contactos.get(i).toString());
            }
            System.out.println("Cantidad de contactos: " + cantidadContactos);
            System.out.println("Porcentaje de contactos agregados: " + porcentajeContactos + "%");
        }
    }
    
    public void editarContacto(String nombre, String telefono, String correo, String pais) {
        AgendaAmigos agenda = leerDeArchivoData();
        if (agenda != null && agenda.getContactosAmigos() != null) {
            for (int i = 0; i < agenda.getContactosAmigos().size(); i++) {
                ContactoAmigo c = agenda.getContactosAmigos().get(i);
                if (c.getNombre().equalsIgnoreCase(nombre)) {
                    c.setNombre(nombre);
                    c.setTelefono(telefono);
                    c.setCorreo(correo);
                    c.setPais(pais);
                    guardarEnArchivoData(agenda);
                    System.out.println("Contacto amigo editado exitosamente.");
                    return;
                }
            }
            System.out.println("No se encontró ningún contacto con el nombre ingresado.");
        } else {
            System.out.println("No se pudo leer la lista de contactos de amigos del archivo amigos.data.");
        }
    }
     

    public boolean eliminarContacto(String nombre) {
        AgendaAmigos agenda = leerDeArchivoData();
        if (agenda != null) {
            for (ContactoAmigo c : agenda.getContactosAmigos()) {
                if (c.getNombre().equalsIgnoreCase(nombre)) {
                    agenda.getContactosAmigos().remove(c);
                    guardarEnArchivoData(agenda);
                    System.out.println("Contacto eliminado exitosamente.");
                    return true;
                }
            }
            System.out.println("No se encontró ningún contacto con el nombre ingresado.");
        }
        return false;
    }


    public AgendaAmigos leerDeArchivoData() {
        AgendaAmigos agenda = null;
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("amigos.data"))) {
            agenda = (AgendaAmigos) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Error al leer la lista de contactos de amigos del archivo amigos.data: " + e.getMessage());
        }
        return agenda;
    }
    
    public void guardarEnArchivoData(AgendaAmigos agenda) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("amigos.data"))) {
            oos.writeObject(agenda);
        } catch (IOException e) {
            System.out.println("Error al guardar la lista de contactos de amigos en el archivo amigos.data: " + e.getMessage());
        }
    }

    public String getNombre() {
        return this.nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTelefono() {
        return this.telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getCorreo() {
        return this.correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getPais() {
        return this.pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    @Override
        public String toString() {
            return "Nombre: " + nombre + ", Teléfono: " + telefono + ", Correo: " + correo + ", País: " + pais;
        }

}

