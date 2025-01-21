package com.foro.forohub.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;

@Entity
@Table(name = "topico", uniqueConstraints = {@UniqueConstraint(columnNames = {"titulo", "mensaje"})}) // Evitar duplicados
public class Topico {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "El título es obligatorio.")
    private String titulo;

    @NotBlank(message = "El mensaje es obligatorio.")
    private String mensaje;

    @NotBlank(message = "El autor es obligatorio.")
    private String autor;

    @NotNull(message = "El curso es obligatorio.")
    @ManyToOne
    @JoinColumn(name = "curso_id", nullable = false) // Relación con la tabla curso
    private Curso curso;

    private LocalDateTime fechaCreacion;

    @NotBlank(message = "El estado es obligatorio.") // Ejemplo: "Abierto", "Cerrado"
    private String estado;

    // Getters & Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public Curso getCurso() {
        return curso;
    }

    public void setCurso(Curso curso) {
        this.curso = curso;
    }

    public LocalDateTime getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(LocalDateTime fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
}