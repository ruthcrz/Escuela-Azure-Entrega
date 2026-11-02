# Configuración de base de datos

La aplicación web utiliza Hibernate y MySQL. La URL y el usuario se encuentran en `src/main/resources/hibernate.cfg.xml`; la contraseña se representa mediante `${DB_PASSWORD}` y no debe sustituirse por una contraseña real dentro del repositorio.

Configura `DB_PASSWORD` como propiedad del proceso Java/Tomcat en el entorno donde se ejecuta la aplicación. No guardes la contraseña en GitHub ni en archivos compartidos.

La base de datos y sus tablas se crean con `sql/Escuela.sql`.

Este proyecto utiliza `javax.servlet`, por lo que está preparado para Tomcat 9. Tomcat 10/11 requiere migración a `jakarta.servlet`.
