package com.puj;

// HU-10: Alerta generada cuando un acta no cumple una regla de consistencia
public class Alerta {

    private String descripcion;
    private Acta acta;
    private boolean resuelta;

    public Alerta(String descripcion, Acta acta) {
        this.descripcion = descripcion;
        this.acta = acta;
        this.resuelta = false;
    }

    public void resolver() {
        resuelta = true;
    }

    public String getDescripcion() { return descripcion; }
    public Acta getActa() { return acta; }
    public boolean isResuelta() { return resuelta; }

    @Override
    public String toString() {
        return "Alerta{acta=" + acta.getId() + ", descripcion=" + descripcion + ", resuelta=" + resuelta + "}";
    }
}
