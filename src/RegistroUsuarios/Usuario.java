package RegistroUsuarios;

public class Usuario {
    // Atributos de Usuario
    private String nombre;
    private String apellidos;
    private String nickname;
    private String contraseña;
    private boolean Estado; // Si es activo o inactivo

    // Constructor Vacío
    public Usuario() {
        this.nombre = "";
        this.apellidos = "";
        this.nickname = "";
        this.contraseña = "";
        // Se inicializa en false
        this.Estado = false;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    public boolean isEstado() {
        return Estado;
    }

    public void setEstado(boolean Estado) {
        this.Estado = Estado;
    }
}