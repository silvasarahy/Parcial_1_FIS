package com.puj;

import java.time.LocalDateTime;

// HU-15: Registro de una acción realizada por un usuario
public class RegistroAuditoria {

    private Usuario usuario;
    private String accion;
    private LocalDateTime fechaHora;

    public RegistroAuditoria(Usuario usuario, String accion) {
        this.usuario = usuario;
        this.accion = accion;
        this.fechaHora = LocalDateTime.now();
    }

    public Usuario getUsuario() { return usuario; }
    public String getAccion() { return accion; }
    public LocalDateTime getFechaHora() { return fechaHora; }

    @Override
    public String toString() {
        return "RegistroAuditoria{usuario=" + usuario.getNombre() + ", accion=" + accion + ", fecha=" + fechaHora + "}";
    }
}
