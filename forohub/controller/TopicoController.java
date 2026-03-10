package com.forohub.forohub.controller;


import com.forohub.forohub.domain.topico.*;
import io.swagger.v3.oas.annotations.tags.Tag;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Tag(name = "Topicos")
@RestController
@RequestMapping("/topicos")

public class TopicoController {
    @Autowired
    private TopicoRepository repository;

    @PostMapping
    @Transactional
    public ResponseEntity registrar(@RequestBody @Valid DatosRegistroTopico datos) {
        if (repository.existsByTituloAndMensaje(datos.titulo(), datos.mensaje())) {
            return ResponseEntity.badRequest().body("Ya existe un tópico con el mismo titulo y mensaje");
        }
        Topico topico = new Topico(datos);
        repository.save(topico);
        return  ResponseEntity.ok(topico);
    }
    @GetMapping
    public ResponseEntity<Page<DatosListaTopico>> listar(
            @PageableDefault(size = 10, sort = "fechaCreacion", direction = Sort.Direction.ASC)
            Pageable paginacion){

        var page = repository.findAll(paginacion)
                .map(DatosListaTopico::new);

        return ResponseEntity.ok(page);
    }
    //Ver el detalle de un tema
    @GetMapping("/{id}")
    public ResponseEntity detallar (@PathVariable Long id){
        var topico = repository.getReferenceById(id);
        return  ResponseEntity.ok(new DatosDetalleTopico(topico));
    }
    //actualizar
    @PutMapping("/{id}")
    @Transactional
    public ResponseEntity actualizar(
            @PathVariable Long id,
            @RequestBody @Valid DatosActualizacionTopico datos){

        Optional<Topico> optionalTopico = repository.findById(id);

        if(optionalTopico.isPresent()){

            Topico topico = optionalTopico.get();
            topico.actualiarInformaciones(datos);

            return ResponseEntity.ok(new DatosDetalleTopico(topico));
        }

        return ResponseEntity.notFound().build();
    }
    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity eliminar(@PathVariable Long id){

        Optional<Topico> topico = repository.findById(id);

        if(topico.isPresent()){
            repository.deleteById(id);
            return ResponseEntity.noContent().build();
        }

        return ResponseEntity.notFound().build();
    }
}
