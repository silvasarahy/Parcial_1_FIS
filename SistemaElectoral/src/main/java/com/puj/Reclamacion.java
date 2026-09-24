package com.puj;

import java.time.LocalDate;

// HU-12: Reclamación sobre los resultados de un acta
public class Reclamacion {

    private String id;
    private String solicitante;
    private LocalDate fecha;
    private String motivo;
    private Acta acta;
    private String estado;
    private String decision;

    public Reclamacion(String id, String solicitante, LocalDate fecha, String motivo, Acta acta) {
        this.id = id;
        this.solicitante = solicitante;
        this.fecha = fecha;
        this.motivo = motivo;
        this.acta = acta;
        this.estado = "RADICADA";
    }

    public void iniciarRevision() {
        estado = "EN_REVISION";
    }

    // HU-12: la decisión se guarda aparte; el motivo original no cambia
    public void resolver(String decision) {
        this.decision = decision;
        this.estado = "RESUELTA";
    }

    public String getId() { return id; }
    public String getSolicitante() { return solicitante; }
    public LocalDate getFecha() { return fecha; }
    public String getMotivo() { return motivo; }
    public Acta getActa() { return acta; }
    public String getEstado() { return estado; }
    public String getDecision() { return decision; }

    @Override
    public String toString() {
        return "Reclamacion{id=" + id + ", solicitante=" + solicitante + ", acta=" + acta.getId()
                + ", estado=" + estado + ", motivo=" + motivo + "}";
    }
}
