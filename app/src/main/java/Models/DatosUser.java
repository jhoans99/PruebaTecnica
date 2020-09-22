package Models;

public class DatosUser {
    String Nombre;
    String Identificacion;
    String Email;
    String Telefono;

    public DatosUser() {
    }

    public DatosUser(String nombre, String identificacion, String email, String telefono) {
        Nombre = nombre;
        Identificacion = identificacion;
        Email = email;
        Telefono = telefono;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String nombre) {
        Nombre = nombre;
    }

    public String getIdentificacion() {
        return Identificacion;
    }

    public void setIdentificacion(String identificacion) {
        Identificacion = identificacion;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public String getTelefono() {
        return Telefono;
    }

    public void setTelefono(String telefono) {
        Telefono = telefono;
    }
}
