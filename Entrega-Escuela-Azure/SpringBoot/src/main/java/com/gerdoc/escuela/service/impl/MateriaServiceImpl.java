package com.gerdoc.escuela.service.impl;

import com.gerdoc.escuela.model.Materia;
import com.gerdoc.escuela.repository.MateriaRepository;
import com.gerdoc.escuela.service.MateriaService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class MateriaServiceImpl implements MateriaService {
    private final MateriaRepository repository;
    @Override @Transactional(readOnly = true) public List<Materia> findAll() { return repository.findAll(); }
    @Override @Transactional(readOnly = true) public Optional<Materia> findById(Long id) { return repository.findById(id); }
    @Override @Transactional public Materia save(Materia entity) { return repository.save(entity); }
    @Override @Transactional public void deleteById(Long id) { repository.deleteById(id); }
    @Override @Transactional(readOnly = true) public boolean existsById(Long id) { return repository.existsById(id); }
}
