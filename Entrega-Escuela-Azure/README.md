# Proyecto ESCUELA — Despliegue en Azure

Repositorio que reúne la aplicación web Java (JSP/Servlets/Hibernate), la API REST desarrollada con Spring Boot y el script SQL de la base de datos ESCUELA.

## Estructura

- `AplicacionWeb/`: aplicación web Maven empaquetada como WAR. Utiliza Java 17, JSP, Servlets (`javax.servlet`), Hibernate y MySQL. Está pensada para Tomcat 9.
- `SpringBoot/`: API REST con Spring Boot, Spring Data JPA y MySQL. El puerto configurado por defecto es 9080. Incluye documentación de endpoints en `API_ENDPOINTS.md` y Swagger UI.
- `AplicacionWeb/sql/Escuela.sql`: creación de la base de datos y tablas del proyecto.
- `documentacion/`: estado de preparación y despliegue en Azure.

## Requisitos

- Java 17
- Maven 3.8 o superior
- MySQL 8
- Tomcat 9 para `AplicacionWeb` (no Tomcat 10/11 sin migrar `javax.servlet` a `jakarta.servlet`)

## Base de datos

1. Crear/restaurar la base con `AplicacionWeb/sql/Escuela.sql`.
2. La base se llama `ESCUELA` e incluye los catálogos `ALUMNO`, `ALUMNO_MATERIA`, `MATERIA`, `PROFESOR` y `PROFESOR_MATERIA`.
3. Configurar credenciales mediante variables de entorno o propiedades del entorno de ejecución. No escribir contraseñas en los archivos fuente.

## Ejecutar Spring Boot

Desde `SpringBoot/` configurar primero `DB_URL`, `DB_USERNAME` y `DB_PASSWORD` en el entorno de ejecución. Se puede tomar como referencia `.env.example` (es una plantilla, no contiene credenciales reales).

```bash
mvn clean package
mvn spring-boot:run
```

La API utiliza el puerto `9080` de forma predeterminada. Swagger UI se configura en `/swagger-ui.html` y los documentos OpenAPI en `/v3/api-docs`.

## Compilar la aplicación web

Desde `AplicacionWeb/`:

```bash
mvn clean package
```

El artefacto WAR se genera en `target/`. Desplegarlo en Tomcat 9. Consultar `AplicacionWeb/CONFIGURACION_DB.md` para la configuración de Hibernate.

## Seguridad

- No subir archivos `.pem`, `.key`, `.env`, contraseñas, tokens ni copias de archivos de configuración de servidores.
- Mantener las credenciales fuera del repositorio y configurar las variables en el servidor.
- El archivo `.env.example` contiene únicamente nombres de variables y valores de ejemplo.

## Estado de despliegue

Consultar `documentacion/ESTADO-AZURE.md`. El documento distingue los componentes comprobados de las tareas todavía pendientes; no se consideran desplegados los servicios que no se hayan verificado.
