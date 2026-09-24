package com.puj;

import java.util.ArrayList;
import java.util.List;

// HU-09: Acta de resultados de una mesa
// HU-10: Validación de consistencia de los resultados
public class Acta {

    private String id;
    private Mesa mesa;
    private String estado;
    private List<ResultadoCandidato> resultados;
    private int votosBlanco;
    private int votosNulos;

    public Acta(String id, Mesa mesa) {
        // HU-09: solo una mesa cerrada puede registrar su acta
        if (!mesa.getEstado().equals("CERRADA")) {
            throw new IllegalStateException("La mesa debe estar cerrada para registrar el acta");
        }
        this.id = id;
        this.mesa = mesa;
        this.estado = "BORRADOR";
        this.resultados = new ArrayList<>();
    }

    public void registrarVotos(Candidato candidato, int votos) {
        if (!estado.equals("BORRADOR")) {
            throw new IllegalStateException("El acta ya no se puede modificar");
        }
        resultados.add(new ResultadoCandidato(candidato, votos));
    }

    public int calcularTotalVotos() {
        int total = votosBlanco + votosNulos;
        for (ResultadoCandidato r : resultados) {
            total += r.getVotos();
        }
        return total;
    }

    // HU-10: devuelve una alerta si el total supera el censo, o null si todo está bien
    public Alerta verificarConsistencia() {
        if (calcularTotalVotos() > mesa.getCenso()) {
            return new Alerta("El total de votos (" + calcularTotalVotos()
                    + ") supera el censo (" + mesa.getCenso() + ")", this);
        }
        return null;
    }

    public void validar() {
        estado = "VALIDADA";
    }

    public void cerrar() {
        if (!estado.equals("VALIDADA")) {
            throw new IllegalStateException("Solo se puede cerrar un acta validada");
        }
        estado = "CERRADA";
    }

    public String getId() { return id; }
    public Mesa getMesa() { return mesa; }
    public String getEstado() { return estado; }
    public List<ResultadoCandidato> getResultados() { return resultados; }
    public int getVotosBlanco() { return votosBlanco; }
    public void setVotosBlanco(int votosBlanco) { this.votosBlanco = votosBlanco; }
    public int getVotosNulos() { return votosNulos; }
    public void setVotosNulos(int votosNulos) { this.votosNulos = votosNulos; }

    @Override
    public String toString() {
        return "Acta{id=" + id + ", mesa=" + mesa.getNumero() + ", estado=" + estado + ", resultados=" + resultados
                + ", blanco=" + votosBlanco + ", nulos=" + votosNulos + "}";
    }
}
