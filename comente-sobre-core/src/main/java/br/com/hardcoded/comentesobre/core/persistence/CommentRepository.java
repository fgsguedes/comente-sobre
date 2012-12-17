package br.com.hardcoded.comentesobre.core.persistence;

import br.com.hardcoded.comentesobre.core.entities.Comment;
import br.com.hardcoded.comentesobre.core.entities.Subject;

import javax.persistence.EntityManager;
import java.util.List;

/**
 * User: Filipe
 * Date: 15/12/12
 */
public final class CommentRepository extends GenericRepository<Comment> {

    CommentRepository(EntityManager entityManager) {
        super(entityManager, Comment.class);
    }

    public List<Comment> list(Subject subject) {
        return entityManager
                .createQuery("select c from Comment c where c.subject = :subject", Comment.class)
                .setParameter("subject", subject)
                .getResultList();
    }
}
