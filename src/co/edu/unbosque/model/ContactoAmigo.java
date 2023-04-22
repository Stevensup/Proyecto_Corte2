package co.edu.unbosque.model;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Arrays;
import java.util.List;

/**
     * Clase ContactoAmigo implementa la interfaz "Serializable". Los objetos de esta clase pueden ser serializados o deserializados.
     */

public class ContactoAmigo implements Serializable {

    private String nombre;
    private String telefono;
    private String correo;
    private String pais;
    private List<ContactoAmigo> contactos;
    public static final List<String> paises = Arrays.asList("Colombia", "Venezuela", "México", "Argentina", "Chile", "Perú");

/**
     * Constructor de la clase ContactoAmigo
     * @param nombre El nombre del amigo.
     * @param telefono El número de teléfono del amigo.
     * @param correo El correo electrónico del amigo.
     * @param pais El país donde vive el amigo.
     */

    public ContactoAmigo(String nombre, String telefono, String correo, String pais) {
        this.nombre = nombre;
        this.telefono = telefono;
        this.correo = correo;
        this.pais = pais;
        this.contactos = contactos;
    }

/**
     * Agrega un nuevo contacto amigo a la agenda de amigos.
     * @param nombreAmigo El nombre del amigo a agregar.
     * @param telefonoAmigo El número de teléfono del amigo a agregar.
     * @param correoAmigo El correo electrónico del amigo a agregar.
     * @param paisAmigo El país donde vive el amigo a agregar.
     */
    
    public void agregarContacto(String nombreAmigo, String telefonoAmigo, String correoAmigo, String paisAmigo) {
        // Se intenta leer la agenda de amigos del archivo data
        AgendaAmigos agenda = leerDeArchivoData();
        // Si no se puede leer la agenda, se crea una nueva
        if (agenda == null) {
            agenda = new AgendaAmigos();
        }
        // Se verifica que el país del nuevo contacto sea válido
        if (paisAmigo.equalsIgnoreCase("colombia") || paisAmigo.equalsIgnoreCase("venezuela") || paisAmigo.equalsIgnoreCase("ecuador")) {
            // Se crea un nuevo objeto ContactoAmigo con la información del amigo a agregar
            ContactoAmigo nuevoContacto = new ContactoAmigo(nombreAmigo, telefonoAmigo, correoAmigo, paisAmigo);
            // Se agrega el nuevo contacto a la lista de contactos de la agenda de amigos
            agenda.getContactosAmigos().add(nuevoContacto);
            // Se guarda la agenda actualizada en el archivo data
            guardarEnArchivoData(agenda);
            System.out.println("Contacto agregado exitosamente.");
        } else {
            // Si el país no es válido, se muestra un mensaje de error
            System.out.println("Pais no valido. Por favor ingrese un pais valido: ");
        }
    }
 /**
     * Busca un contacto amigo en la agenda de amigos por nombre.
     * @param nombre El nombre del amigo a buscar.
     * @param right Número a la derecha del arreglo.
     * @return El objeto ContactoAmigo que coincide con el nombre buscado, si se encuentra en la agenda. De lo contrario, retorna null.
     */
    
    public ContactoAmigo buscarContacto(String nombre) {
        // Se intenta leer la agenda de amigos del archivo data
        AgendaAmigos agenda = leerDeArchivoData();
        // Si se puede leer la agenda
        if (agenda != null) {
        // Se recorre la lista de contactos de la agenda
            for (ContactoAmigo c : agenda.getContactosAmigos()) {
        // Si el nombre del contacto coincide con el nombre buscado (ignorando mayúsculas y minúsculas)
                if (c.getNombre().equalsIgnoreCase(nombre)) {
        // Se retorna el objeto ContactoAmigo
                    return c;
                }
            }
        }
        // Si no se encuentra ningún contacto con el nombre buscado, se retorna null
        return null;
    }
 /**
     * Lista todos los contactos amigos en la agenda de amigos.
     */
    public void listarContactos() {
        System.out.println("Lista de contactos amigos:");
        // Se intenta leer la agenda de amigos del archivo data
        AgendaAmigos agenda = leerDeArchivoData();
        // Si se puede leer la agenda
        if (agenda != null) {
        // Se recorre la lista de contactos de la agenda
            for (ContactoAmigo contacto : agenda.getContactosAmigos()) {
        // Se muestra la información del contacto en la consola
                System.out.println(contacto.toString());
            }
        } else {
        // Si la agenda está vacía, se muestra un mensaje indicando que no hay contactos amigos
            System.out.println("La lista de contactos de amigos está vacía.");
        }
    }
    
/**
     * Edita el contacto amigo con el nombre especificado.
     * @param nombre El nombre del contacto amigo a editar.
     * @param telefono El nuevo número de teléfono del contacto amigo.
     * @param correo El nuevo correo electrónico del contacto amigo.
     * @param pais El nuevo país del contacto amigo.
     */
    
    public void editarContacto(String nombre, String telefono, String correo, String pais) {
        // Se intenta leer la agenda de amigos del archivo data
        AgendaAmigos agenda = leerDeArchivoData();
        // Si se puede leer la agenda
        if (agenda != null) {
        // Se recorre la lista de contactos de la agenda
            for (ContactoAmigo c : agenda.getContactosAmigos()) {
        // Si se encuentra el contacto amigo con el nombre especificado
                if (c.getNombre().equalsIgnoreCase(nombre)) {
        // Se actualizan los datos del contacto amigo
                    c.setTelefono(telefono);
                    c.setCorreo(correo);
                    c.setPais(pais);
        // Se guarda la agenda actualizada en el archivo data
                    guardarEnArchivoData(agenda);
        // Se muestra un mensaje de éxito en la consola
                    System.out.println("Contacto editado exitosamente.");
                    return;
                }
            }
            // Si no se encontró ningún contacto con el nombre especificado, se muestra un mensaje de error en la consola
            System.out.println("No se encontró ningún contacto con el nombre ingresado.");
        }
    }   
    
/**
     * Lee la lista de contactos de amigos del archivo amigos.data y la devuelve como un objeto de tipo AgendaAmigos.
     * @return La lista de contactos de amigos almacenada en el archivo amigos.data como un objeto de tipo AgendaAmigos, o null si no se pudo leer.
     */
    
    public AgendaAmigos leerDeArchivoData() {
        AgendaAmigos agenda = null;
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("amigos.data"))) {
            agenda = (AgendaAmigos) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Error al leer la lista de contactos de amigos del archivo amigos.data: " + e.getMessage());
        }
        return agenda;
    }

/**
     * Guarda la lista de contactos de amigos en el archivo amigos.data.
     * @param agenda La lista de contactos de amigos a guardar en el archivo.
     */
    
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

