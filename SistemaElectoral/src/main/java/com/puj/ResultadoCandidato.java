package com.puj;

// HU-09: Votos de un candidato dentro de un acta
public class ResultadoCandidato {

    private Candidato candidato;
    private int votos;

    public ResultadoCandidato(Candidato candidato, int votos) {
        if (votos < 0) {
            throw new IllegalArgumentException("Los votos no pueden ser negativos");
        }
        this.candidato = candidato;
        this.votos = votos;
    }

    public Candidato getCandidato() { return candidato; }
    public int getVotos() { return votos; }
    public void setVotos(int votos) { this.votos = votos; }

    @Override
    public String toString() {
        return candidato.getNombre() + "=" + votos;
    }
}
