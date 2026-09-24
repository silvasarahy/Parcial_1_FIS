package com.puj;

// HU-15: Usuario del sistema con un rol
public class Usuario {

    private String id;
    private String nombre;
    private String rol;

    public Usuario(String id, String nombre, String rol) {
        this.id = id;
        this.nombre = nombre;
        this.rol = rol;
    }

    public boolean tieneRol(String rolRequerido) {
        return rol.equals(rolRequerido);
    }

    public String getId() { return id; }
    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }
    public String getRol() { return rol; }
    public void setRol(String rol) { this.rol = rol; }

    @Override
    public String toString() {
        return "Usuario{id=" + id + ", nombre=" + nombre + ", rol=" + rol + "}";
    }
}
