package br.com.hardcoded.comentesobre.core.persistence;

import javax.persistence.EntityManager;

/**
 * User: Filipe
 * Date: 15/12/12
 */
public final  class Repositories {

    private Repositories() {

    }

    public static CommentRepository getCommentRepository(final EntityManager entityManager) {
        return new CommentRepository(entityManager);
    }

    public static SubjectRepository getSubjectRepository(final EntityManager entityManager) {
        return new SubjectRepository(entityManager);
    }
}
