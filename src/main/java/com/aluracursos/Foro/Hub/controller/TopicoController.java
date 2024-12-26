package com.aluracursos.Foro.Hub.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.aluracursos.Foro.Hub.model.Topico;
import com.aluracursos.Foro.Hub.service.TopicoService;

import java.util.List;

@RestController
@RequestMapping("/topicos")
public class TopicoController {

    @Autowired
    private TopicoService topicoService;

    @GetMapping
    public ResponseEntity<List<Topico>> getAllTopicos() {
        List<Topico> topicos = topicoService.getAllTopicos();
        return ResponseEntity.ok(topicos); // Devuelve una respuesta con código 200 y el cuerpo
    }

    @GetMapping("/{id}")
    public ResponseEntity<Topico> getTopicoById(@PathVariable Long id) {
        Topico topico = topicoService.getTopicoById(id);
        if (topico == null) {
            return ResponseEntity.notFound().build(); // Devuelve 404 si no se encuentra
        }
        return ResponseEntity.ok(topico);
    }

    @PostMapping
    public ResponseEntity<Topico> createTopico(@RequestBody Topico topico) {
        Topico createdTopico = topicoService.createTopico(topico);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdTopico); // Devuelve 201 al crear
    }

    @PutMapping("/{id}")
    public ResponseEntity<Topico> updateTopico(@PathVariable Long id, @RequestBody Topico topicoDetails) {
        Topico updatedTopico = topicoService.updateTopico(id, topicoDetails);
        if (updatedTopico == null) {
            return ResponseEntity.notFound().build(); // Devuelve 404 si no se encuentra para actualizar
        }
        return ResponseEntity.ok(updatedTopico);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTopico(@PathVariable Long id) {
        boolean deleted = topicoService.deleteTopico(id);
        if (!deleted) {
            return ResponseEntity.notFound().build(); // Devuelve 404 si no se encuentra para borrar
        }
        return ResponseEntity.noContent().build(); // Devuelve 204 si se borra con éxito
    }
}
