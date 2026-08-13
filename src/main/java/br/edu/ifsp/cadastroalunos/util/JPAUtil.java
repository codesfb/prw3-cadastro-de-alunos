package br.edu.ifsp.cadastroalunos.util;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.util.logging.Level;
import java.util.logging.Logger;

public class JPAUtil {
    private static final EntityManagerFactory FACTORY;

        static {
        // Desativa os logs de INFO e WARN do Hibernate no console
        Logger.getLogger("org.hibernate").setLevel(Level.SEVERE);

        FACTORY = Persistence.createEntityManagerFactory("alunos");
    }

    public static EntityManager getEntityManager() {
        return FACTORY.createEntityManager();
    }

}
