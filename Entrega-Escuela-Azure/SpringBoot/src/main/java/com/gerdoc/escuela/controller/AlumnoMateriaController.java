package com.gerdoc.escuela.controller;

import com.gerdoc.escuela.model.AlumnoMateria;
import com.gerdoc.escuela.service.AlumnoMateriaService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@Tag(name = "Inscripciones alumno-materia", description = "Operaciones CRUD para alumno, materia y calificación")
@RestController
@RequestMapping("/api/alumno-materia")
@RequiredArgsConstructor
public class AlumnoMateriaController {
    private final AlumnoMateriaService service;

    @Operation(summary = "Consultar todos los registros")
    @GetMapping public ResponseEntity<List<AlumnoMateria>> findAll() { return ResponseEntity.ok(service.findAll()); }

    @Operation(summary = "Consultar un registro por ID")
    @GetMapping("/{id}") public ResponseEntity<AlumnoMateria> findById(@PathVariable Long id) {
        return service.findById(id).map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @Operation(summary = "Crear un registro")
    @PostMapping public ResponseEntity<AlumnoMateria> create(@RequestBody AlumnoMateria entity) {
        entity.setId(null);
        return ResponseEntity.status(HttpStatus.CREATED).body(service.save(entity));
    }

    @Operation(summary = "Actualizar un registro")
    @PutMapping("/{id}") public ResponseEntity<AlumnoMateria> update(@PathVariable Long id, @RequestBody AlumnoMateria input) {
        return service.findById(id).map(current -> {
            current.setAlumno(input.getAlumno());
            current.setMateria(input.getMateria());
            current.setCalificacion(input.getCalificacion());
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
