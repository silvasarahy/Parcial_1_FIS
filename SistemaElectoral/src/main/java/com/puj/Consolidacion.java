package com.puj;

import java.util.ArrayList;
import java.util.List;

// HU-13: Consolidación y publicación de resultados
public class Consolidacion {

    private ProcesoElectoral proceso;
    private List<Acta> actas;
    private String estadoPublicacion;

    public Consolidacion(ProcesoElectoral proceso) {
        this.proceso = proceso;
        this.actas = new ArrayList<>();
        this.estadoPublicacion = "EN_PREPARACION";
    }

    // HU-13: solo se consolidan actas cerradas
    public void agregarActa(Acta acta) {
        if (!acta.getEstado().equals("CERRADA")) {
            throw new IllegalStateException("Solo se consolidan actas cerradas");
        }
        actas.add(acta);
    }

    public int totalVotosCandidato(Candidato candidato) {
        int total = 0;
        for (Acta acta : actas) {
            total += votosEnActa(acta, candidato);
        }
        return total;
    }

    private int votosEnActa(Acta acta, Candidato candidato) {
        for (ResultadoCandidato r : acta.getResultados()) {
            if (r.getCandidato() == candidato) {
                return r.getVotos();
            }
        }
        return 0;
    }

    public void validar() {
        estadoPublicacion = "VALIDADA";
    }

    public void publicar() {
        if (!estadoPublicacion.equals("VALIDADA")) {
            throw new IllegalStateException("La consolidación debe validarse antes de publicarse");
        }
        estadoPublicacion = "PUBLICADA";
    }

    public ProcesoElectoral getProceso() { return proceso; }
    public List<Acta> getActas() { return actas; }
    public String getEstadoPublicacion() { return estadoPublicacion; }

    @Override
    public String toString() {
        return "Consolidacion{proceso=" + proceso.getId() + ", actas=" + actas.size() + ", estado=" + estadoPublicacion + "}";
    }
}
