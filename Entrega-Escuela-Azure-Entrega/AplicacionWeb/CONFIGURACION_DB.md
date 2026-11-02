# Configuración de base de datos

La aplicación web utiliza Hibernate y MySQL. La conexión se configura con las variables de entorno `DB_USERNAME` y `DB_PASSWORD`; la URL de conexión y los mapeos se encuentran en `src/main/resources/hibernate.cfg.xml`.

Configura ambas variables en el entorno del proceso Java/Tomcat que ejecuta la aplicación. No escribas usuarios o contraseñas reales en los archivos fuente ni los subas a GitHub.

La base de datos y sus tablas se crean con `sql/Escuela.sql`. **Advertencia:** el script contiene una instrucción `DROP DATABASE IF EXISTS ESCUELA`; ejecutarlo nuevamente elimina primero la base de datos existente. Úsalo únicamente cuando realmente quieras recrear la base y tengas respaldo de los datos.

Las cuentas de usuario incluidas en los INSERT del script son datos de demostración para pruebas académicas; no deben reutilizarse en un sistema real.

Este proyecto utiliza `javax.servlet`, por lo que está preparado para Tomcat 9. Tomcat 10/11 requiere migración a `jakarta.servlet`.
