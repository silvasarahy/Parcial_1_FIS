package com.puj;

// HU-03: Puesto de votación con ubicación
public class PuestoVotacion {

    private String id;
    private String nombre;
    private String direccion;
    private Municipio municipio;
    private boolean activo;

    public PuestoVotacion(String id, String nombre, String direccion, Municipio municipio) {
        this.id = id;
        this.nombre = nombre;
        this.direccion = direccion;
        this.municipio = municipio;
        this.activo = true;
    }

    public String getId() { return id; }
    public void setId(String id) { this.id = id; }
    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }
    public String getDireccion() { return direccion; }
    public void setDireccion(String direccion) { this.direccion = direccion; }
    public Municipio getMunicipio() { return municipio; }
    public boolean isActivo() { return activo; }
    public void setActivo(boolean activo) { this.activo = activo; }

    @Override
    public String toString() {
        return "PuestoVotacion{id=" + id + ", nombre=" + nombre + ", direccion=" + direccion + ", activo=" + activo + "}";
    }
}
