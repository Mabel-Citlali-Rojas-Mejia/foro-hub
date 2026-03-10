package com.forohub.forohub.domain.topico;

import jakarta.persistence.*;
import jakarta.validation.Valid;

import java.time.LocalDateTime;

@Entity(name = "Topico")
@Table(name = "topicos")
public class Topico {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String titulo;
    private String mensaje;
    private LocalDateTime fechaCreacion;
    private String  status;
    @Column(name = "autor_id")
    private Long autorId ;
    @Column (name = "categoria_id")
    private Long categoriaId;

    public Topico(){

    }
    public  Topico(DatosRegistroTopico datos){
        this.titulo = datos.titulo();
        this.mensaje= datos.mensaje();
        this.autorId = datos.autorId();
        this.categoriaId = datos.categoriaId();
        this.fechaCreacion = LocalDateTime.now();
        this.status = "ABIERTO";
    }

    public Long getId() {
        return id;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getMensaje() {
        return mensaje;
    }

    public LocalDateTime getFechaCreacion() {
        return fechaCreacion;
    }

    public String getStatus() {
        return status;
    }

    public Long getAutorId() {
        return autorId;
    }

    public Long getCategoriaId() {
        return categoriaId;
    }



    public void actualiarInformaciones(@Valid DatosActualizacionTopico datos) {
        if (datos.titulo() != null){
            this.titulo = datos.titulo();
        }
        if (datos.mensaje() != null){
            this.mensaje= datos.mensaje();
        }

    }
}
