package com.puj;

import java.util.ArrayList;
import java.util.List;

// HU-02: Municipio que pertenece a un departamento
public class Municipio {

    private String codigo;
    private String nombre;
    private Departamento departamento;
    private List<PuestoVotacion> puestos;

    public Municipio(String codigo, String nombre, Departamento departamento) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.departamento = departamento;
        this.puestos = new ArrayList<>();
    }

    public void agregarPuesto(PuestoVotacion puesto) {
        puestos.add(puesto);
    }

    public String getCodigo() { return codigo; }
    public void setCodigo(String codigo) { this.codigo = codigo; }
    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }
    public Departamento getDepartamento() { return departamento; }
    public List<PuestoVotacion> getPuestos() { return puestos; }

    @Override
    public String toString() {
        return "Municipio{codigo=" + codigo + ", nombre=" + nombre + ", departamento=" + departamento.getNombre() + "}";
    }
}
