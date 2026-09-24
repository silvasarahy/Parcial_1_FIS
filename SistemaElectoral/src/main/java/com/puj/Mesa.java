package com.puj;

// HU-04: Mesa con número y censo aproximado
// HU-08: Instalación y cierre de la mesa
public class Mesa {

    private int numero;
    private int censo;
    private PuestoVotacion puesto;
    private String estado;

    public Mesa(int numero, int censo, PuestoVotacion puesto) {
        if (censo < 0) {
            throw new IllegalArgumentException("El censo no puede ser negativo");
        }
        this.numero = numero;
        this.censo = censo;
        this.puesto = puesto;
        this.estado = "CONFIGURADA";
    }

    public void instalar() {
        if (!estado.equals("CONFIGURADA")) {
            throw new IllegalStateException("La mesa ya fue instalada o cerrada");
        }
        estado = "INSTALADA";
    }

    public void cerrar() {
        if (!estado.equals("INSTALADA")) {
            throw new IllegalStateException("Solo se puede cerrar una mesa instalada");
        }
        estado = "CERRADA";
    }

    public int getNumero() { return numero; }
    public void setNumero(int numero) { this.numero = numero; }
    public int getCenso() { return censo; }
    public void setCenso(int censo) { this.censo = censo; }
    public PuestoVotacion getPuesto() { return puesto; }
    public String getEstado() { return estado; }

    @Override
    public String toString() {
        return "Mesa{numero=" + numero + ", censo=" + censo + ", puesto=" + puesto.getNombre() + ", estado=" + estado + "}";
    }
}
