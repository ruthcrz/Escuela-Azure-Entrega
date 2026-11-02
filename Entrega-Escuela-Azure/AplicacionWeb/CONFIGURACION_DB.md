# Configuración de base de datos

La aplicación web utiliza Hibernate y MySQL. La conexión se configura con las variables de entorno `DB_USERNAME` y `DB_PASSWORD`; la URL y los mapeos se encuentran en `src/main/resources/hibernate.cfg.xml`.

Configura ambas variables en el entorno del proceso Java/Tomcat. No guardes credenciales reales en archivos fuente ni las subas a GitHub.

La base de datos y sus tablas se crean con `sql/Escuela.sql`. **Advertencia:** el script contiene `DROP DATABASE IF EXISTS ESCUELA`; ejecutarlo elimina primero la base existente. Úsalo solo si realmente quieres recrearla y tienes respaldo.

Las cuentas incluidas en los INSERT son datos de demostración académica; no deben reutilizarse en un sistema real.

El proyecto utiliza `javax.servlet` y está preparado para Tomcat 9. Tomcat 10/11 requiere migración a `jakarta.servlet`.
