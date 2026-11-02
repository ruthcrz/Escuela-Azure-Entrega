package com.gerdoc.escuela.controller;

import com.gerdoc.escuela.model.Materia;
import com.gerdoc.escuela.service.MateriaService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@Tag(name = "Materias", description = "Operaciones CRUD para nombre, créditos")
@RestController
@RequestMapping("/api/materias")
@RequiredArgsConstructor
public class MateriaController {
    private final MateriaService service;

    @Operation(summary = "Consultar todos los registros")
    @GetMapping public ResponseEntity<List<Materia>> findAll() { return ResponseEntity.ok(service.findAll()); }

    @Operation(summary = "Consultar un registro por ID")
    @GetMapping("/{id}") public ResponseEntity<Materia> findById(@PathVariable Long id) {
        return service.findById(id).map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @Operation(summary = "Crear un registro")
    @PostMapping public ResponseEntity<Materia> create(@RequestBody Materia entity) {
        entity.setId(null);
        return ResponseEntity.status(HttpStatus.CREATED).body(service.save(entity));
    }

    @Operation(summary = "Actualizar un registro")
    @PutMapping("/{id}") public ResponseEntity<Materia> update(@PathVariable Long id, @RequestBody Materia input) {
        return service.findById(id).map(current -> {
            current.setNombre(input.getNombre());
            current.setCreditos(input.getCreditos());
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
