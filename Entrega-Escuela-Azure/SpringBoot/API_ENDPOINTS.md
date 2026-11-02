# API REST - ESCUELA

Base URL local: `http://localhost:9080`

Todos los catálogos ofrecen `GET /api/{recurso}`, `GET /api/{recurso}/{id}`, `POST /api/{recurso}`, `PUT /api/{recurso}/{id}` y `DELETE /api/{recurso}/{id}`.

| Catálogo | Recurso |
|---|---|
| ALUMNO | `/api/alumnos` |
| ALUMNO_MATERIA | `/api/alumno-materia` |
| MATERIA | `/api/materias` |
| PROFESOR | `/api/profesores` |
| PROFESOR_MATERIA | `/api/profesor-materia` |

Ejemplo POST ALUMNO:
```json
{"nombre":"Andrea López","edad":20,"promedio":9.25}
```

Ejemplo POST ALUMNO_MATERIA (los IDs deben existir previamente):
```json
{"alumno":{"id":1},"materia":{"id":2},"calificacion":9.50}
```

Ejemplo POST PROFESOR_MATERIA:
```json
{"profesor":{"id":1},"materia":{"id":2}}
```

La configuración usa `DB_URL`, `DB_USERNAME` y `DB_PASSWORD` del entorno. No publiques contraseñas en el repositorio.
Swagger UI: `http://localhost:9080/swagger-ui.html`.
