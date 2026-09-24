package com.puj;

// HU-05: Organización política participante
public class OrganizacionPolitica {

    private String id;
    private String nombre;
    private String estadoParticipacion;

    public OrganizacionPolitica(String id, String nombre) {
        this.id = id;
        this.nombre = nombre;
        this.estadoParticipacion = "INSCRITA";
    }

    public void habilitar() {
        estadoParticipacion = "HABILITADA";
    }

    public boolean estaHabilitada() {
        return estadoParticipacion.equals("HABILITADA");
    }

    public String getId() { return id; }
    public void setId(String id) { this.id = id; }
    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }
    public String getEstadoParticipacion() { return estadoParticipacion; }
    public void setEstadoParticipacion(String estado) { this.estadoParticipacion = estado; }

    @Override
    public String toString() {
        return "OrganizacionPolitica{id=" + id + ", nombre=" + nombre + ", estado=" + estadoParticipacion + "}";
    }
}
