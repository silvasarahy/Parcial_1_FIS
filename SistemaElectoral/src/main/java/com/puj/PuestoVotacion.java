package com.puj;

import java.util.ArrayList;
import java.util.List;

// HU-03: Puesto de votación con ubicación
public class PuestoVotacion {

    private String id;
    private String nombre;
    private String direccion;
    private Municipio municipio;
    private boolean activo;
    private List<Mesa> mesas;

    public PuestoVotacion(String id, String nombre, String direccion, Municipio municipio) {
        this.id = id;
        this.nombre = nombre;
        this.direccion = direccion;
        this.municipio = municipio;
        this.activo = true;
        this.mesas = new ArrayList<>();
    }

    // HU-03 y HU-04: un puesto inactivo no recibe mesas y el número de mesa no se repite
    public void agregarMesa(Mesa mesa) {
        if (!activo) {
            throw new IllegalStateException("El puesto " + nombre + " está inactivo");
        }
        for (Mesa m : mesas) {
            if (m.getNumero() == mesa.getNumero()) {
                throw new IllegalStateException("Ya existe la mesa " + mesa.getNumero() + " en este puesto");
            }
        }
        mesas.add(mesa);
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
    public List<Mesa> getMesas() { return mesas; }

    @Override
    public String toString() {
        return "PuestoVotacion{id=" + id + ", nombre=" + nombre + ", direccion=" + direccion + ", activo=" + activo + "}";
    }
}
