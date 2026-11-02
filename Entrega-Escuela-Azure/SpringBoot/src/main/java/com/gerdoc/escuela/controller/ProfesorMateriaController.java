package com.gerdoc.escuela.controller;

import com.gerdoc.escuela.model.ProfesorMateria;
import com.gerdoc.escuela.service.ProfesorMateriaService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@Tag(name = "Asignaciones profesor-materia", description = "Operaciones CRUD para profesor y materia")
@RestController
@RequestMapping("/api/profesor-materia")
@RequiredArgsConstructor
public class ProfesorMateriaController {
    private final ProfesorMateriaService service;

    @Operation(summary = "Consultar todos los registros")
    @GetMapping public ResponseEntity<List<ProfesorMateria>> findAll() { return ResponseEntity.ok(service.findAll()); }

    @Operation(summary = "Consultar un registro por ID")
    @GetMapping("/{id}") public ResponseEntity<ProfesorMateria> findById(@PathVariable Long id) {
        return service.findById(id).map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @Operation(summary = "Crear un registro")
    @PostMapping public ResponseEntity<ProfesorMateria> create(@RequestBody ProfesorMateria entity) {
        entity.setId(null);
        return ResponseEntity.status(HttpStatus.CREATED).body(service.save(entity));
    }

    @Operation(summary = "Actualizar un registro")
    @PutMapping("/{id}") public ResponseEntity<ProfesorMateria> update(@PathVariable Long id, @RequestBody ProfesorMateria input) {
        return service.findById(id).map(current -> {
            current.setProfesor(input.getProfesor());
            current.setMateria(input.getMateria());
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
