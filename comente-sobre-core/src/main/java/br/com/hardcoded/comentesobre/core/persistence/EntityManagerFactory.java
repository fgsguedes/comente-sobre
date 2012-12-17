package br.com.hardcoded.comentesobre.core.persistence;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

/**
 * User: Filipe
 * Date: 15/12/12
 */
public final class EntityManagerFactory {

    private static final javax.persistence.EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("default");

    private EntityManagerFactory() {
    }

    public static EntityManager getEntityManager() {
        return entityManagerFactory.createEntityManager();
    }
}
