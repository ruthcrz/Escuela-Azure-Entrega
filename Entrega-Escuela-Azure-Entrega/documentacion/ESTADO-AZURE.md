# Estado de despliegue en Azure

Fecha de actualización: 2 de noviembre de 2026.

## Entorno comprobado

- Máquina virtual Azure con Ubuntu 24.04 LTS.
- Java OpenJDK 17, Maven y Git instalados.
- Apache HTTP Server instalado y activo.
- MySQL Server 8.0 activo.
- Base de datos `ESCUELA` creada, con los catálogos `ALUMNO`, `ALUMNO_MATERIA`, `MATERIA`, `PROFESOR` y `PROFESOR_MATERIA`.
- Tomcat 9 instalado en `/opt/tomcat9` y ejecutándose como servicio `tomcat9`.
- Aplicación web empaquetada como WAR y desplegada en Tomcat.
- Las cinco páginas de catálogo respondieron HTTP 200 en las pruebas locales del servidor.
- La aplicación se abrió desde un navegador mediante la IP pública de la VM y mostró registros existentes.
- API Spring Boot desplegada como servicio independiente en el puerto 9080.
- Las pruebas de operaciones CRUD y de los servicios REST fueron realizadas en el entorno desplegado.

## Configuración de conexión

- La aplicación web usa Hibernate y obtiene `DB_USERNAME` y `DB_PASSWORD` del entorno del proceso Tomcat.
- Spring Boot obtiene sus datos de conexión de las variables de entorno definidas para el servicio.
- Las credenciales reales no se almacenan en este repositorio.

## Pendiente / evidencia de entrega

- Incorporar al informe o presentación las capturas de Azure, Tomcat, Spring Boot, página principal, catálogos, operaciones CRUD, pruebas REST y base de datos.
- Si se requiere publicar todo el tráfico mediante el puerto HTTP 80, verificar y documentar la configuración de Apache como proxy inverso. El acceso probado directamente a Tomcat por el puerto 8080 no demuestra por sí solo que el proxy esté configurado.

## Seguridad

- No incluir archivos `.env`, llaves `.pem` o `.key`, contraseñas, tokens ni archivos de configuración privados del servidor.
- Mantener las credenciales en variables/secretos del entorno de ejecución.
- Una credencial de mantenimiento de MySQL se mostró accidentalmente durante la configuración; debe rotarse y no reutilizarse.
