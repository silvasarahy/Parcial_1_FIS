package com.puj;

// HU-04: Mesa con número y censo aproximado
public class Mesa {

    private int numero;
    private int censo;
    private PuestoVotacion puesto;

    public Mesa(int numero, int censo, PuestoVotacion puesto) {
        if (censo < 0) {
            throw new IllegalArgumentException("El censo no puede ser negativo");
        }
        this.numero = numero;
        this.censo = censo;
        this.puesto = puesto;
    }

    public int getNumero() { return numero; }
    public void setNumero(int numero) { this.numero = numero; }
    public int getCenso() { return censo; }
    public void setCenso(int censo) { this.censo = censo; }
    public PuestoVotacion getPuesto() { return puesto; }

    @Override
    public String toString() {
        return "Mesa{numero=" + numero + ", censo=" + censo + ", puesto=" + puesto.getNombre() + "}";
    }
}
