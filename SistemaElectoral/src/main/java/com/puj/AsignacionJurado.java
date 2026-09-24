package com.puj;

// HU-07: Asignación de un jurado a una mesa con su función
public class AsignacionJurado {

    private Jurado jurado;
    private Mesa mesa;
    private String funcion;
    private boolean activa;
    private String motivoRetiro;

    public AsignacionJurado(Jurado jurado, Mesa mesa, String funcion) {
        this.jurado = jurado;
        this.mesa = mesa;
        this.funcion = funcion;
        this.activa = true;
    }

    public void retirar(String motivo) {
        this.activa = false;
        this.motivoRetiro = motivo;
    }

    public Jurado getJurado() { return jurado; }
    public Mesa getMesa() { return mesa; }
    public String getFuncion() { return funcion; }
    public void setFuncion(String funcion) { this.funcion = funcion; }
    public boolean isActiva() { return activa; }
    public String getMotivoRetiro() { return motivoRetiro; }

    @Override
    public String toString() {
        return "AsignacionJurado{jurado=" + jurado.getNombre() + ", mesa=" + mesa.getNumero()
                + ", funcion=" + funcion + ", activa=" + activa + "}";
    }
}
