package com.puj;

import java.time.LocalDateTime;

// HU-11: Incidente ocurrido durante la jornada
public class Incidente {

    private String id;
    private String tipo;
    private String descripcion;
    private LocalDateTime fechaHora;
    private PuestoVotacion puesto;
    private String estado;
    private String responsable;

    public Incidente(String id, String tipo, String descripcion, LocalDateTime fechaHora, PuestoVotacion puesto) {
        this.id = id;
        this.tipo = tipo;
        this.descripcion = descripcion;
        this.fechaHora = fechaHora;
        this.puesto = puesto;
        this.estado = "REPORTADO";
    }

    public void asignarResponsable(String responsable) {
        this.responsable = responsable;
        this.estado = "EN_SEGUIMIENTO";
    }

    public void resolver() {
        estado = "RESUELTO";
    }

    public String getId() { return id; }
    public String getTipo() { return tipo; }
    public void setTipo(String tipo) { this.tipo = tipo; }
    public String getDescripcion() { return descripcion; }
    public void setDescripcion(String descripcion) { this.descripcion = descripcion; }
    public LocalDateTime getFechaHora() { return fechaHora; }
    public PuestoVotacion getPuesto() { return puesto; }
    public String getEstado() { return estado; }
    public String getResponsable() { return responsable; }

    @Override
    public String toString() {
        return "Incidente{id=" + id + ", tipo=" + tipo + ", puesto=" + puesto.getNombre()
                + ", estado=" + estado + ", descripcion=" + descripcion + "}";
    }
}
