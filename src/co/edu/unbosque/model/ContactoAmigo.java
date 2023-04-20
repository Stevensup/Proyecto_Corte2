package co.edu.unbosque.model;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Properties;

public class ContactoAmigo {

    private String nombre;
    private String telefono;
    private String correo;
    private String pais;

    public ContactoAmigo(String nombre, String telefono, String correo, String pais) {
        this.nombre = nombre;
        this.telefono = telefono;
        this.correo = correo;
        this.pais = pais;
    }

    public class AgendaAmigos {

        private ArrayList<ContactoAmigo> contactosAmigos;

        public AgendaAmigos() {
            contactosAmigos = new ArrayList<ContactoAmigo>();
        }

        public void agregarContacto(String nombre, String telefono, String correo, String pais) {
            ContactoAmigo nuevoContacto = new ContactoAmigo(nombre, telefono, correo, pais);
            contactosAmigos.add(nuevoContacto);
        }

        public ArrayList<ContactoAmigo> getContactosAmigos() {
            return contactosAmigos;
        }

        public void setContactosAmigos(ArrayList<ContactoAmigo> contactosAmigos) {
            this.contactosAmigos = contactosAmigos;
        }

        @Override
        public String toString() {
            return "AgendaAmigos [contactosAmigos=" + contactosAmigos + "]";
        }

    }

    public class AgendaAmigosDataIO {

        public static void guardarEnArchivoData(ArrayList<ContactoAmigo> contactos) {
            try {
                FileOutputStream fos = new FileOutputStream("agenda_amigos.data");
                ObjectOutputStream oos = new ObjectOutputStream(fos);
                oos.writeObject(contactos);
                oos.close();
                fos.close();
                System.out
                        .println("La lista de contactos de amigos ha sido guardada en el archivo agenda_amigos.data.");
            } catch (Exception e) {
                System.out.println("Error al guardar la lista de contactos de amigos en el archivo agenda_amigos.data: "
                        + e.getMessage());
            }
        }

    }

    public class AgendaAmigosPropertiesIO {

        public static void guardarEnArchivoProperties(ArrayList<ContactoAmigo> contactos) {
            try {
                Properties props = new Properties();
                for (int i = 0; i < contactos.size(); i++) {
                    ContactoAmigo contacto = contactos.get(i);
                    props.setProperty("contacto_" + i + "_nombre", contacto.getNombre());
                    props.setProperty("contacto_" + i + "_telefono", contacto.getTelefono());
                    props.setProperty("contacto_" + i + "_correo", contacto.getCorreo());
                    props.setProperty("contacto_" + i + "_pais", contacto.getPais());
                }
                FileOutputStream fos = new FileOutputStream("agenda_amigos.properties");
                props.store(fos, "Lista de contactos de amigos");
                fos.close();
                System.out.println(
                        "La lista de contactos de amigos ha sido guardada en el archivo agenda_amigos.properties.");
            } catch (Exception e) {
                System.out.println(
                        "Error al guardar la lista de contactos de amigos en el archivo agenda_amigos.properties: "
                                + e.getMessage());
            }
        }

    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    @Override
    public String toString() {
        return "ContactoAmigo [nombre=" + nombre + ", telefono=" + telefono + ", correo=" + correo + ", pais=" + pais
                + "]";
    }

    public void agregarContacto(String nombreAmigo, String telefonoAmigo, String correoAmigo, String paisAmigo) {
    }
}
