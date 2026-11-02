package org.gerdoc.servlet;
import org.gerdoc.model.AlumnoMateria;
import org.gerdoc.model.Alumno;
import org.gerdoc.model.Materia;
import org.gerdoc.service.AlumnoMateriaService;
import org.gerdoc.service.AlumnoService;
import org.gerdoc.service.MateriaService;
import org.gerdoc.service.impl.AlumnoMateriaServiceImpl;
import org.gerdoc.service.impl.AlumnoServiceImpl;
import org.gerdoc.service.impl.MateriaServiceImpl;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.math.BigDecimal;
@WebServlet("/AlumnoMateriaServlet")
public class AlumnoMateriaServlet extends HttpServlet {
    private final AlumnoMateriaService service = new AlumnoMateriaServiceImpl();
    private final AlumnoService alumnos = new AlumnoServiceImpl();
    private final MateriaService materias = new MateriaServiceImpl();
    @Override protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        String action = req.getParameter("accion");
        try {
            Long id = req.getParameter("id") == null || req.getParameter("id").isBlank() ? null : Long.valueOf(req.getParameter("id"));
            if ("delete".equals(action)) { service.deleteById(id); }
            else {
                Long alumnoId = Long.valueOf(req.getParameter("alumnoId"));
                Long materiaId = Long.valueOf(req.getParameter("materiaId"));
                Alumno alumno = alumnos.findById(alumnoId);
                Materia materia = materias.findById(materiaId);
                if (alumno == null || materia == null) throw new IllegalArgumentException("Selecciona un alumno y una materia existentes.");
                String cal = req.getParameter("calificacion");
                AlumnoMateria entity = AlumnoMateria.builder().id(id).alumno(alumno).materia(materia)
                    .calificacion(cal == null || cal.isBlank() ? null : new BigDecimal(cal)).build();
                if ("update".equals(action)) service.update(entity); else service.save(entity);
            }
            resp.sendRedirect("AlumnoMaterias.jsp");
        } catch (Exception ex) {
            resp.sendError(HttpServletResponse.SC_BAD_REQUEST, "No se pudo guardar la relación alumno-materia: " + ex.getMessage());
        }
    }
}
