package com.puj;

import java.util.ArrayList;
import java.util.List;

// HU-02: Departamento con sus municipios
public class Departamento {

    private String codigo;
    private String nombre;
    private List<Municipio> municipios;

    public Departamento(String codigo, String nombre) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.municipios = new ArrayList<>();
    }

    public void agregarMunicipio(Municipio municipio) {
        municipios.add(municipio);
    }

    public String getCodigo() { return codigo; }
    public void setCodigo(String codigo) { this.codigo = codigo; }
    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }
    public List<Municipio> getMunicipios() { return municipios; }

    @Override
    public String toString() {
        return "Departamento{codigo=" + codigo + ", nombre=" + nombre + "}";
    }
}
