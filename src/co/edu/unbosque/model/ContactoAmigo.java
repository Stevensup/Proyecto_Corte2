package co.edu.unbosque.model;

import java.util.ArrayList;

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
