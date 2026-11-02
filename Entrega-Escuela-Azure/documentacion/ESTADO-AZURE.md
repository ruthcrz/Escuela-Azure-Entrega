# Estado de preparación y despliegue en Azure

Fecha de registro: 2 de noviembre de 2026.

## Componentes comprobados

- Máquina virtual: Ubuntu 24.04 LTS.
- Java: OpenJDK 17 instalado y verificado.
- Maven: instalado y verificado.
- Git: instalado y verificado.
- Apache HTTP Server: servicio habilitado y observado como `active (running)`.
- MySQL Server 8.0: servicio habilitado y observado como `active (running)`.
- Base de datos `ESCUELA`: existe en MySQL.
- Tablas verificadas: `ALUMNO`, `ALUMNO_MATERIA`, `MATERIA`, `PROFESOR` y `PROFESOR_MATERIA`.
- Estructura de `ALUMNO`: columnas `ID`, `NOMBRE`, `EDAD` y `PROMEDIO`.
- Tomcat 9: archivos instalados en `/opt/tomcat9`; se obtuvo una respuesta HTTP 200 en `localhost:8080` durante una prueba manual.

## Pendiente de comprobar o completar

- Dejar Tomcat 9 estable como servicio `systemd` (`active (running)` persistente).
- Compilar y desplegar el WAR de la aplicación web en Tomcat.
- Configurar y ejecutar la API Spring Boot en Azure.
- Configurar Apache como proxy inverso para enrutar hacia Tomcat y Spring Boot.
- Verificar el acceso público por navegador y las reglas de red necesarias.
- Ejecutar pruebas CRUD para los cinco catálogos y comprobar persistencia desde las aplicaciones.
- Guardar capturas y evidencias de cada prueba.

## Nota de seguridad

No se incluyen direcciones privadas, llaves SSH ni credenciales. Las contraseñas deben configurarse como variables/secretos del entorno de ejecución. Una credencial de mantenimiento de MySQL se mostró accidentalmente durante la configuración; debe rotarse y no reutilizarse.
