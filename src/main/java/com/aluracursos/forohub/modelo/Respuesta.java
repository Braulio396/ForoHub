package com.aluracursos.forohub.modelo;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Entity
public class Respuesta {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    private String mensaje;

    private LocalDateTime fechaCreacion = LocalDateTime.now();

    @ManyToOne
    @NotNull
    private Topico topico;

    @ManyToOne
    @NotNull
    private Usuario autor;

    private Boolean solucion;

    // Getters y Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getMensaje() { return mensaje; }
    public void setMensaje(String mensaje) { this.mensaje = mensaje; }
    public LocalDateTime getFechaCreacion() { return fechaCreacion; }
    public void setFechaCreacion(LocalDateTime fechaCreacion) { this.fechaCreacion = fechaCreacion; }
    public Topico getTopico() { return topico; }
    public void setTopico(Topico topico) { this.topico = topico; }
    public Usuario getAutor() { return autor; }
    public void setAutor(Usuario autor) { this.autor = autor; }
    public Boolean getSolucion() { return solucion; }
    public void setSolucion(Boolean solucion) { this.solucion = solucion; }
}
