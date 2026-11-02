package org.gerdoc.dao.impl;
import org.gerdoc.dao.AlumnoMateriaDao;
import org.gerdoc.model.AlumnoMateria;
import org.gerdoc.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;
import java.util.List;
public class AlumnoMateriaDaoImpl implements AlumnoMateriaDao {
    @Override public List<AlumnoMateria> findAll() {
        try (Session s = HibernateUtil.getSessionFactory().openSession()) {
            return s.createQuery("from AlumnoMateria am join fetch am.alumno join fetch am.materia", AlumnoMateria.class).getResultList();
        }
    }
    @Override public AlumnoMateria findById(Long id) {
        try (Session s = HibernateUtil.getSessionFactory().openSession()) {
            return s.createQuery("from AlumnoMateria am join fetch am.alumno join fetch am.materia where am.id = :id", AlumnoMateria.class).setParameter("id", id).uniqueResult();
        }
    }
    @Override public AlumnoMateria save(AlumnoMateria entity) { return persist(entity, false); }
    @Override public AlumnoMateria update(AlumnoMateria entity) { return persist(entity, true); }
    private AlumnoMateria persist(AlumnoMateria entity, boolean update) {
        Transaction tx = null;
        try (Session s = HibernateUtil.getSessionFactory().openSession()) {
            tx = s.beginTransaction();
            entity.setAlumno(s.get(org.gerdoc.model.Alumno.class, entity.getAlumno().getId()));
            entity.setMateria(s.get(org.gerdoc.model.Materia.class, entity.getMateria().getId()));
            if (entity.getAlumno() == null || entity.getMateria() == null) throw new IllegalArgumentException("El alumno o la materia no existen.");
            if (update) s.merge(entity); else s.persist(entity);
            tx.commit(); return entity;
        } catch (RuntimeException ex) { if (tx != null && tx.isActive()) tx.rollback(); throw ex; }
    }
    @Override public void deleteById(Long id) {
        Transaction tx = null;
        try (Session s = HibernateUtil.getSessionFactory().openSession()) {
            tx = s.beginTransaction();
            AlumnoMateria entity = s.get(AlumnoMateria.class, id);
            if (entity != null) s.remove(entity);
            tx.commit();
        } catch (RuntimeException ex) { if (tx != null && tx.isActive()) tx.rollback(); throw ex; }
    }
}
