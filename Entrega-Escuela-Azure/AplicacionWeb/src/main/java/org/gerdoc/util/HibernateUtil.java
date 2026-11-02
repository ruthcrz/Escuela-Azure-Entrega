package org.gerdoc.util;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {

    private static final SessionFactory sessionFactory;

    static {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            String dbUsername = System.getenv("DB_USERNAME");
            String dbPassword = System.getenv("DB_PASSWORD");

            if (dbUsername == null || dbPassword == null) {
                throw new IllegalStateException(
                    "Faltan las variables DB_USERNAME o DB_PASSWORD"
                );
            }

            Configuration configuration = new Configuration()
                    .configure("hibernate.cfg.xml");

            configuration.setProperty(
                    "hibernate.connection.username", dbUsername);

            configuration.setProperty(
                    "hibernate.connection.password", dbPassword);

            sessionFactory = configuration.buildSessionFactory();

        } catch (Throwable e) {
            System.err.println("Error al iniciar Hibernate: " + e.getMessage());
            throw new ExceptionInInitializerError(e);
        }
    }

    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }
}
