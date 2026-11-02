package com.gerdoc.escuela.service;

import com.gerdoc.escuela.model.AlumnoMateria;
import java.util.List;
import java.util.Optional;

public interface AlumnoMateriaService {
    List<AlumnoMateria> findAll();
    Optional<AlumnoMateria> findById(Long id);
    AlumnoMateria save(AlumnoMateria entity);
    void deleteById(Long id);
    boolean existsById(Long id);
}
