package com.puj;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

// HU-01: Proceso electoral con tipo, fecha y estado
public class ProcesoElectoral {

    private String id;
    private String tipoEleccion;
    private LocalDate fecha;
    private String estado;
    private List<Departamento> departamentos;

    public ProcesoElectoral(String id, String tipoEleccion, LocalDate fecha) {
        this.id = id;
        this.tipoEleccion = tipoEleccion;
        this.fecha = fecha;
        this.estado = "EN_CONFIGURACION";
        this.departamentos = new ArrayList<>();
    }

    // HU-02: vincular un departamento al proceso
    public void agregarDepartamento(Departamento departamento) {
        departamentos.add(departamento);
    }

    public void cambiarEstado(String nuevoEstado) {
        this.estado = nuevoEstado;
    }

    public String getId() { return id; }
    public void setId(String id) { this.id = id; }
    public String getTipoEleccion() { return tipoEleccion; }
    public void setTipoEleccion(String tipoEleccion) { this.tipoEleccion = tipoEleccion; }
    public LocalDate getFecha() { return fecha; }
    public void setFecha(LocalDate fecha) { this.fecha = fecha; }
    public String getEstado() { return estado; }
    public List<Departamento> getDepartamentos() { return departamentos; }

    @Override
    public String toString() {
        return "ProcesoElectoral{id=" + id + ", tipo=" + tipoEleccion + ", fecha=" + fecha + ", estado=" + estado + "}";
    }
}
