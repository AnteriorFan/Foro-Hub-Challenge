package com.gabo.Foro_Hub_Challenged.controller;


import com.gabo.Foro_Hub_Challenged.domain.topico.*;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;


@RestController
@RequestMapping(":/topicos")
public class TopicoController {

    private final TopicoService service;
    private final TopicoRepository repository;

    private static final Logger logger = LoggerFactory.getLogger(TopicoController.class);

    // Inyección de dependencias a través del constructor
    public TopicoController(TopicoService service, TopicoRepository repository) {
        this.service = service;
        this.repository = repository;
    }


    @GetMapping
    public ResponseEntity<Map<String, Object>> listarTopicos(@PageableDefault(size = 10, sort = {"fechaCreacion"}) Pageable paginacion){
        //return ResponseEntity.ok(repository.findByActivoTrue(paginacion).map(ResponseTopicoDTO::new));
        var page = repository.findByActivoTrue(paginacion).map(ResponseTopicoDTO::new);
        Map<String, Object> response = new HashMap<>();
        response.put("content", page.getContent());
        response.put("currentPage", page.getNumber());
        response.put("totalItems", page.getTotalElements());
        response.put("totalPages", page.getTotalPages());

        return ResponseEntity.ok(response);
    }

    @PostMapping
    public ResponseEntity registrarTopico(@RequestBody @Valid RequestTopicoDTO datos){
        logger.info("Registrando tópico");
        var topico = service.registrarTopico(datos);
        return ResponseEntity.ok(new ResponseDetallarTopicoDTO(topico));
    }

    @GetMapping("/{id}")
    public ResponseEntity detallarTopico(@PathVariable Long id) {
        if (repository.existsById(id) && repository.findActivoById(id)){
            var topico = repository.getReferenceById(id);
            return ResponseEntity.ok(new ResponseDetallarTopicoDTO(topico));
        } return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No existe el tópico solicitado o fue borrado");
    }

    //
    @PutMapping("/{id}")
    @Transactional
    public ResponseEntity actualizarTopico(@PathVariable Long id, @RequestBody @Valid ActualizarTopicoDTO datosActualizarTopico) {
        Topico topico = service.actualizarTopico(id, datosActualizarTopico);
        return ResponseEntity.ok(new ResponseTopicoDTO(topico));
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity eliminarTopico(@PathVariable Long id) {
        if (repository.existsById(id) && repository.findActivoById(id)){
            //Delete logico
            Topico topico = repository.getReferenceById(id);
            topico.desactivarTopico();
            return ResponseEntity.noContent().build();
        } return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No existe el tópico solicitado o fue borrado");
    }


}
