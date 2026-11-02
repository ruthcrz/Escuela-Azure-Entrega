package org.gerdoc.service.impl;
import org.gerdoc.dao.AlumnoMateriaDao;
import org.gerdoc.dao.impl.AlumnoMateriaDaoImpl;
import org.gerdoc.model.AlumnoMateria;
import org.gerdoc.service.AlumnoMateriaService;
import java.util.List;
public class AlumnoMateriaServiceImpl implements AlumnoMateriaService {
    private final AlumnoMateriaDao dao = new AlumnoMateriaDaoImpl();
    public List<AlumnoMateria> findAll() { return dao.findAll(); }
    public AlumnoMateria findById(Long id) { return dao.findById(id); }
    public void save(AlumnoMateria e) { dao.save(e); }
    public void update(AlumnoMateria e) { dao.update(e); }
    public void deleteById(Long id) { dao.deleteById(id); }
}
