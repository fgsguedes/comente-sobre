package br.com.hardcoded.comentesobre.core.persistence;

import br.com.hardcoded.comentesobre.core.entities.Subject;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import java.util.List;

/**
 * User: Filipe
 * Date: 17/12/12
 */
public final class SubjectRepository extends GenericRepository<Subject> {

    SubjectRepository(final EntityManager entityManager) {
        super(entityManager, Subject.class);
    }

    public Subject find(Subject subject) {

        try {
            return entityManager
                    .find(Subject.class, subject.getId());
        } catch (NoResultException e) {
            return null;
        }
    }

    public List<Subject> listWithComments() {

        return entityManager
                .createQuery("select s from Subject s inner join fetch s.comments", Subject.class)
                .getResultList();
    }
}
