package com.forohub.forohub.domain.topico;

import jakarta.persistence.Column;

import java.time.LocalDateTime;

public record DatosListaTopico(
        Long id,
        String titulo,
        String mensaje,
        LocalDateTime fechaCreacion,
        String status,
        Long autorId,
        Long categoriaId
) {

    public DatosListaTopico(Topico topico){
        this(
                topico.getId(),
                topico.getTitulo(),
                topico.getMensaje(),
                topico.getFechaCreacion(),
                topico.getStatus(),
                topico.getAutorId(),
                topico.getCategoriaId()
        );
    }

}
