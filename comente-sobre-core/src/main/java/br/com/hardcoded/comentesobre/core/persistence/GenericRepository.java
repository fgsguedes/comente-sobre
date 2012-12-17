package br.com.hardcoded.comentesobre.core.persistence;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import java.util.List;

/**
 * User: Filipe
 * Date: 15/12/12
 */
abstract class GenericRepository<T> {

    final EntityManager entityManager;
    private final Class<T> entityClass;

    GenericRepository(EntityManager entityManager, Class<T> entityClass) {
        this.entityManager = entityManager;
        this.entityClass = entityClass;
    }

    public T save(final T t) {
        final EntityTransaction transaction = entityManager.getTransaction();

        try {
            transaction.begin();
            final T merged = entityManager.merge(t);
            transaction.commit();

            return merged;
        } finally {
            if (transaction.isActive()) {
                transaction.rollback();
            }
        }
    }

    public List<T> list() {

        final String query = String.format("select entity from %s entity", entityClass.getSimpleName());

        return entityManager
                .createQuery(query, entityClass)
                .getResultList();
    }
}
