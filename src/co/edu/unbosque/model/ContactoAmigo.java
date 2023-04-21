package co.edu.unbosque.model;

import co.edu.unbosque.model.AgendaAmigos;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;


public class ContactoAmigo implements Serializable {

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

    public void agregarContacto(String nombreAmigo, String telefonoAmigo, String correoAmigo, String paisAmigo) {
        AgendaAmigos agenda = leerDeArchivoData();
        if (agenda == null) {
            agenda = new AgendaAmigos();
        }
        ContactoAmigo nuevoContacto = new ContactoAmigo(nombreAmigo, telefonoAmigo, correoAmigo, paisAmigo);
        agenda.getContactosAmigos().add(nuevoContacto);
        guardarEnArchivoData(agenda);
        System.out.println(agenda.toString());
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

}

