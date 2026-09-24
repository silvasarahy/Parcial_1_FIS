package com.puj;

// HU-06: Candidato y la organización que lo respalda
public class Candidato {

    private String documento;
    private String nombre;
    private OrganizacionPolitica organizacion;
    private String estado;

    public Candidato(String documento, String nombre, OrganizacionPolitica organizacion) {
        // HU-06: solo se inscribe con una organización habilitada
        if (organizacion != null && !organizacion.estaHabilitada()) {
            throw new IllegalStateException("La organización " + organizacion.getNombre() + " no está habilitada");
        }
        this.documento = documento;
        this.nombre = nombre;
        this.organizacion = organizacion;
        this.estado = "INSCRITO";
    }

    public void aceptar() {
        estado = "ACEPTADO";
    }

    public String getDocumento() { return documento; }
    public void setDocumento(String documento) { this.documento = documento; }
    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }
    public OrganizacionPolitica getOrganizacion() { return organizacion; }
    public String getEstado() { return estado; }

    @Override
    public String toString() {
        String org = (organizacion == null) ? "sin organización" : organizacion.getNombre();
        return "Candidato{documento=" + documento + ", nombre=" + nombre + ", organizacion=" + org + ", estado=" + estado + "}";
    }
}
