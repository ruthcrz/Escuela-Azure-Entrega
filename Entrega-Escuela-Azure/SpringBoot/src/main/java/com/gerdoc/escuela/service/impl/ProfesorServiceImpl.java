package com.gerdoc.escuela.service.impl;

import com.gerdoc.escuela.model.Profesor;
import com.gerdoc.escuela.repository.ProfesorRepository;
import com.gerdoc.escuela.service.ProfesorService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProfesorServiceImpl implements ProfesorService {
    private final ProfesorRepository repository;
    @Override @Transactional(readOnly = true) public List<Profesor> findAll() { return repository.findAll(); }
    @Override @Transactional(readOnly = true) public Optional<Profesor> findById(Long id) { return repository.findById(id); }
    @Override @Transactional public Profesor save(Profesor entity) { return repository.save(entity); }
    @Override @Transactional public void deleteById(Long id) { repository.deleteById(id); }
    @Override @Transactional(readOnly = true) public boolean existsById(Long id) { return repository.existsById(id); }
}
