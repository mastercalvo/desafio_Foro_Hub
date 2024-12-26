package com.aluracursos.Foro.Hub.model;

import jakarta.persistence.*;



@Entity
@Table(name = "topicos")
public class Topico {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String titulo;
    private String mensaje;
    private String status;
    private Long autorId;
    private Long cursoId;

    // Constructor por defecto
    public Topico() {}

    // Constructor con parámetros
    public Topico(Long id, String titulo, String mensaje, String status, Long autorId, Long cursoId) {
        this.id = id;
        this.titulo = titulo;
        this.mensaje = mensaje;
        this.status = status;
        this.autorId = autorId;
        this.cursoId = cursoId;
    }

    // Getters y Setters
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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Long getAutorId() {
        return autorId;
    }

    public void setAutorId(Long autorId) {
        this.autorId = autorId;
    }

    public Long getCursoId() {
        return cursoId;
    }

    public void setCursoId(Long cursoId) {
        this.cursoId = cursoId;
    }
}
