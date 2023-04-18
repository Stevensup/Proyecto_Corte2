package co.edu.unbosque.model;

public class ContactoTrabajo {

    private String nombre;
    private String telefono;
    private String correo;
    private String pais;

    public ContactoTrabajo(String nombre, String telefono, String correo, String pais) {
        this.nombre = nombre;
        this.telefono = telefono;
        this.correo = correo;
        this.pais = pais;
    }

    public class AgendaTrabajo {

        private ContactoTrabajo[] contactos;
        private int index;
    
        public AgendaTrabajo(int maxContactos) {
            contactos = new ContactoTrabajo[maxContactos];
            index = 0;
        }
    
        public void agregarContactoTrabajo(String nombre, String telefono, String correo, String pais) {
            ContactoTrabajo nuevoContacto = new ContactoTrabajo(nombre, telefono, correo, pais);
            contactos[index] = nuevoContacto;
            index++;
        }
    
        // Resto del código de la clase
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

    public void agregarContactoTrabajo(String nombreTrabajo, String telefonoTrabajo, String correoTrabajo,
            String paisTrabajo) {
    }
}
