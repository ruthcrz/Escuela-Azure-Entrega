package com.gerdoc.escuela.controller;

import com.gerdoc.escuela.model.Profesor;
import com.gerdoc.escuela.service.ProfesorService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@Tag(name = "Profesores", description = "Operaciones CRUD para nombre, especialidad")
@RestController
@RequestMapping("/api/profesores")
@RequiredArgsConstructor
public class ProfesorController {
    private final ProfesorService service;

    @Operation(summary = "Consultar todos los registros")
    @GetMapping public ResponseEntity<List<Profesor>> findAll() { return ResponseEntity.ok(service.findAll()); }

    @Operation(summary = "Consultar un registro por ID")
    @GetMapping("/{id}") public ResponseEntity<Profesor> findById(@PathVariable Long id) {
        return service.findById(id).map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @Operation(summary = "Crear un registro")
    @PostMapping public ResponseEntity<Profesor> create(@RequestBody Profesor entity) {
        entity.setId(null);
        return ResponseEntity.status(HttpStatus.CREATED).body(service.save(entity));
    }

    @Operation(summary = "Actualizar un registro")
    @PutMapping("/{id}") public ResponseEntity<Profesor> update(@PathVariable Long id, @RequestBody Profesor input) {
        return service.findById(id).map(current -> {
            current.setNombre(input.getNombre());
            current.setEspecialidad(input.getEspecialidad());
            return ResponseEntity.ok(service.save(current));
        }).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @Operation(summary = "Eliminar un registro")
    @DeleteMapping("/{id}") public ResponseEntity<Void> delete(@PathVariable Long id) {
        if (!service.existsById(id)) return ResponseEntity.notFound().build();
        service.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
