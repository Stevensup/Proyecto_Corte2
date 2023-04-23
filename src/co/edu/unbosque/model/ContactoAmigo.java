package co.edu.unbosque.model;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
        String[] paisesValidos = {"colombia", "venezuela", "méxico", "argentina", "chile", "perú"};
        // Se crea un nuevo objeto ContactoAmigo con la información del amigo a agregar
        if (Arrays.asList(paisesValidos).contains(paisAmigo.toLowerCase())) {
            if (agenda.getContactosAmigos().size() < 15) {
                ContactoAmigo nuevoContacto = new ContactoAmigo(nombreAmigo, telefonoAmigo, correoAmigo, paisAmigo);
        // Se agrega el nuevo contacto a la lista de contactos de la agenda de amigos
                agenda.getContactosAmigos().add(nuevoContacto);
        // Se guarda la agenda actualizada en el archivo data
                guardarEnArchivoData(agenda);
                System.out.println("Contacto agregado exitosamente.");
            } else {
        // Si el país no es válido, se muestra un mensaje de error
                System.out.println("No es posible agregar más contactos amigos. La agenda ya está llena.");
            }
        } else {
            System.out.println("País no válido. Por favor ingrese un país válido: ");
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
        // Se intenta leer la agenda de amigos del archivo data
        AgendaAmigos agenda = leerDeArchivoData();
         // Si se puede leer la agenda
        if (agenda == null || agenda.getContactosAmigos().isEmpty()) {
         // Se recorre la lista de contactos de la agenda
            System.out.println("No hay contactos en la agenda.");
          // Se muestra la información del contacto en la consola
        } else {
           // Si la agenda está vacía, se muestra un mensaje indicando que no hay contactos amigos
            List<ContactoAmigo> contactos = agenda.getContactosAmigos();
            int cantidadContactos = contactos.size();
            double porcentajeContactos = ((double) cantidadContactos / 15) * 100;
    
           // Agregar conteo por país
            Map<String, Integer> conteoPorPais = new HashMap<>();
            for (ContactoAmigo c : contactos) {
                String pais = c.getPais();
                conteoPorPais.put(pais, conteoPorPais.getOrDefault(pais, 0) + 1);
            }
    
            for (int i = 0; i < cantidadContactos; i++) {
                System.out.println((i + 1) + ". " + contactos.get(i).toString());
            }
    
            System.out.println("Cantidad de contactos: " + cantidadContactos + "/15");
            System.out.println("Porcentaje de contactos agregados: " + porcentajeContactos + "%");
    
            // Imprimir conteo por país
            System.out.println("Conteo por país:");
            for (String pais : conteoPorPais.keySet()) {
                System.out.println(pais + ": " + conteoPorPais.get(pais));
            }
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
        if (agenda != null && agenda.getContactosAmigos() != null) {
         // Se recorre la lista de contactos de la agenda
            for (int i = 0; i < agenda.getContactosAmigos().size(); i++) {
         // Si se encuentra el contacto amigo con el nombre especificado
                ContactoAmigo c = agenda.getContactosAmigos().get(i);
         // Se actualizan los datos del contacto amigo
                if (c.getNombre().equalsIgnoreCase(nombre)) {
                    c.setNombre(nombre);
                    c.setTelefono(telefono);
                    c.setCorreo(correo);
                    c.setPais(pais);
         // Se guarda la agenda actualizada en el archivo data
                    guardarEnArchivoData(agenda);
         // Se muestra un mensaje de éxito en la consola
                    System.out.println("Contacto amigo editado exitosamente.");
                    return;
                }
            }
            // Si no se encontró ningún contacto con el nombre especificado, se muestra un mensaje de error en la consola
            System.out.println("No se encontró ningún contacto con el nombre ingresado.");
        } else {
            System.out.println("No se pudo leer la lista de contactos de amigos del archivo amigos.data.");
        }
    }
     
/**
     * Elimina un contacto de la agenda de amigos, dado su nombre.
     * @param nombre el nombre del contacto a eliminar.
     * @return true si se eliminó el contacto exitosamente, false en caso contrario.
     */  
    
    public boolean eliminarContacto(String nombre) {
        // Leer la agenda de amigos desde el archivo
        AgendaAmigos agenda = leerDeArchivoData();
        if (agenda != null) {
        // Recorrer la lista de contactos de la agenda
            for (ContactoAmigo c : agenda.getContactosAmigos()) {
        // Si se encuentra el contacto con el nombre especificado, se elimina y se guarda en el archivo
                if (c.getNombre().equalsIgnoreCase(nombre)) {
                    agenda.getContactosAmigos().remove(c);
                    guardarEnArchivoData(agenda);
        // Se muestra un mensaje de éxito en la consola
                    System.out.println("Contacto eliminado exitosamente.");
                    return true;
                }
            }
         // Si no se encuentra ningún contacto con el nombre especificado, se muestra un mensaje de erro
            System.out.println("No se encontró ningún contacto con el nombre ingresado.");
        }
        // Si no se pudo leer la agenda desde el archivo, se retorna false
        return false;
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

