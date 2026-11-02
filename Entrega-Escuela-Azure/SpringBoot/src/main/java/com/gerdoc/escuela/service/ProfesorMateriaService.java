package com.gerdoc.escuela.service;

import com.gerdoc.escuela.model.ProfesorMateria;
import java.util.List;
import java.util.Optional;

public interface ProfesorMateriaService {
    List<ProfesorMateria> findAll();
    Optional<ProfesorMateria> findById(Long id);
    ProfesorMateria save(ProfesorMateria entity);
    void deleteById(Long id);
    boolean existsById(Long id);
}
