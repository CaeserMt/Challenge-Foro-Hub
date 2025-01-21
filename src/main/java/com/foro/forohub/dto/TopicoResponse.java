package com.foro.forohub.dto;

import java.time.LocalDateTime;

public class TopicoResponse {

    private Long id;
    private String titulo;
    private String mensaje;
    private String autor;
    private LocalDateTime fechaCreacion;
    private String estado;
    private String cursoNombre;

    public TopicoResponse(Long id, String titulo, String mensaje, String autor, LocalDateTime fechaCreacion, String estado, String cursoNombre) {
        this.id = id;
        this.titulo = titulo;
        this.mensaje = mensaje;
        this.autor = autor;
        this.fechaCreacion = fechaCreacion;
        this.estado = estado;
        this.cursoNombre = cursoNombre;
    }

    // Getters
    public Long getId() {
        return id;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getMensaje() {
        return mensaje;
    }

    public String getAutor() {
        return autor;
    }

    public LocalDateTime getFechaCreacion() {
        return fechaCreacion;
    }

    public String getEstado() {
        return estado;
    }

    public String getCursoNombre() {
        return cursoNombre;
    }
}