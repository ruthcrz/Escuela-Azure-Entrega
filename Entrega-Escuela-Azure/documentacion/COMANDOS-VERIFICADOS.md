# Comandos de verificación ejecutados en la VM

```bash
java -version
mvn -version
git --version
sudo systemctl status apache2 --no-pager
sudo systemctl status mysql --no-pager
sudo mysql --defaults-file=/etc/mysql/debian.cnf
```

Dentro de MySQL:

```sql
SHOW DATABASES;
USE ESCUELA;
SHOW TABLES;
DESCRIBE ALUMNO;
```

La prueba manual de Tomcat respondió `HTTP/1.1 200` en `http://localhost:8080`. La unidad `systemd` de Tomcat aún requiere confirmación de estado estable; no se declara como completada.
