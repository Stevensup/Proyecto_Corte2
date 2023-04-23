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
     * Clase ContactoTrabajo implementa la interfaz "Serializable". Los objetos de esta clase pueden ser serializados o deserializados.
     */
public class ContactoTrabajo implements Serializable {

    private String nombreTrabajo;
    private String telefonoTrabajo;
    private String correoTrabajo;
    private String paisTrabajo;
    private String nombreEmpresa;
    private List<ContactoTrabajo> contactos;
    public static final List<String> paises = Arrays.asList("Colombia", "Venezuela", "Mexico", "Argentina", "Chile", "Peru");

/**
     * Crea un nuevo contacto de trabajo con los parámetros especificados.
     * @param nombreTrabajo el nombre del contacto de trabajo.
     * @param nombreEmpresa el nombre de la empresa del contacto de trabajo.
     * @param telefonoTrabajo el número de teléfono del trabajo del contacto.
     * @param paisTrabajo el país de trabajo del contacto.
     */
    public ContactoTrabajo(String nombreTrabajo, String nombreEmpresa,  String telefonoTrabajo, String correoTrabajo, String paisTrabajo) {
        this.nombreTrabajo = nombreTrabajo;
        this.telefonoTrabajo = telefonoTrabajo;
        this.correoTrabajo = correoTrabajo;
        this.paisTrabajo = paisTrabajo;
        this.nombreEmpresa= nombreEmpresa;
        this.contactos = contactos;
    }
/**
     * Agrega un nuevo contacto de trabajo a la agenda de amigos.
     * @param nombreAmigo El nombre del amigo a agregar.
     * @param telefonoAmigo El número de teléfono amigo a agregar.
     * @param correoAmigo El correo electrónico amigo a agregar.
     * @param paisAmigo El país donde vive el amigo a agregar.
     */
    public void agregarContactoTrabajo(String nombreTrabajo, String nombreEmpresa, String telefonoTrabajo, String correoTrabajo, String paisTrabajo) {
        AgendaTrabajo agenda = leerDeArchivoDataTrabajo();
        if (agenda == null) {
            agenda = new AgendaTrabajo();
        }
        String[] paisesValidos = {"Colombia", "Venezuela", "Mexico", "Argentina", "Chile", "Peru"};
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
    
 /**
     * Busca un contacto trabajo en la agenda de amigos por nombre.
     * @param nombre El nombre del amigo a buscar.
     * @param right Número a la derecha del arreglo.
     * @return El objeto ContactoTrabajo que coincide con el nombre buscado, si se encuentra en la agenda. De lo contrario, retorna null.
     */

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
/**
     * Lista todos los contactos trabajo en la agenda de amigos.
     */
    public void listarContactosTrabajo() {
        AgendaTrabajo agenda = leerDeArchivoDataTrabajo();
      // Si se puede leer la agenda
        if (agenda == null || agenda.getContactosTrabajo().isEmpty()) {
            System.out.println("No hay contactos en la agenda trabajo.");
        } else {
            List<ContactoTrabajo> contactos = agenda.getContactosTrabajo();
            int cantidadContactos = contactos.size();
            double porcentajeContactos = ((double) cantidadContactos / 20) * 100;
    
            // Agregar conteo por país
            Map<String, Integer> conteoPorPais = new HashMap<>();
            for (ContactoTrabajo c : contactos) {
                String pais = c.getPaisTrabajo();
                conteoPorPais.put(pais, conteoPorPais.getOrDefault(pais, 0) + 1);
            }
    
            int countPorPais = conteoPorPais.values().stream().mapToInt(Integer::intValue).sum();
            Map<String, Integer> countPorEmpresa = new HashMap<>();
            for (int i = 0; i < cantidadContactos; i++) {
                ContactoTrabajo contacto = contactos.get(i);
                String empresa = contacto.getNombreEmpresa();
                if (empresa != null && !empresa.isEmpty()) {
                    countPorEmpresa.put(empresa, countPorEmpresa.getOrDefault(empresa, 0) + 1);
                }
                System.out.println((i + 1) + ". " + contacto.toString());
            }
            System.out.println("Cantidad de contactos: " + cantidadContactos + "/20");
            System.out.println("Porcentaje de contactos agregados: " + porcentajeContactos + "%");
            System.out.println("Cantidad de contactos por país:");
            for (String pais : conteoPorPais.keySet()) {
                System.out.println("- " + pais + ": " + conteoPorPais.get(pais));
            }
            System.out.println("Cantidad de contactos por empresa:");
            for (Map.Entry<String, Integer> entry : countPorEmpresa.entrySet()) {
                System.out.println("- " + entry.getKey() + ": " + entry.getValue());
            }
        }
    }
    
    
/**
     * Edita el contacto trabajo con el nombre especificado.
     * @param nombre El nombre del contacto trabajo a editar.
     * @param telefono El nuevo número de teléfono del contacto trabajo.
     * @param correo El nuevo correo electrónico del contacto trabajo.
     * @param pais El nuevo país del contacto trabajo.
     */
   
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

/**
     * Lee la lista de contactos de trabajo del archivo amigos.data y la devuelve como un objeto de tipo AgendaTrabajo.
     * @return La lista de contactos de trabajp almacenada en el archivo amigos.data como un objeto de tipo AgendaTrabajo, o null si no se pudo leer.
     */
    public AgendaTrabajo leerDeArchivoDataTrabajo() {
        AgendaTrabajo agenda = null;
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("trabajo.data"))) {
            agenda = (AgendaTrabajo) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Error al leer la lista de contactos de trabajo del archivo trabajo.data: " + e.getMessage());
        }
        return agenda;
    }
    /**
     * Guarda la lista de contactos de trabajo en el archivo amigos.data.
     * @param agenda La lista de contacto de trabajo a guardar en el archivo.
     */
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

