package br.com.hardcoded.comentesobre.core.api;

import br.com.hardcoded.comentesobre.core.entities.Comment;
import br.com.hardcoded.comentesobre.core.entities.Subject;
import br.com.hardcoded.comentesobre.core.persistence.CommentRepository;
import br.com.hardcoded.comentesobre.core.persistence.EntityManagerFactory;
import br.com.hardcoded.comentesobre.core.persistence.Repositories;

import javax.persistence.EntityManager;
import java.util.List;

/**
 * User: Filipe
 * Date: 15/12/12
 */
public final class CommentApi {

    public Comment save(final Comment comment) {

        final EntityManager entityManager = EntityManagerFactory.getEntityManager();

        try {
            final CommentRepository commentRepository = Repositories.getCommentRepository(entityManager);
            return commentRepository.save(comment);

        } finally {
            if (entityManager.isOpen()) {
                entityManager.close();
            }
        }
    }

    public List<Comment> list(final Subject subject) {

        final EntityManager entityManager = EntityManagerFactory.getEntityManager();

        try {
            final CommentRepository commentRepository = Repositories.getCommentRepository(entityManager);
            return commentRepository.list(subject);

        } finally {
            if (entityManager.isOpen()) {
                entityManager.close();
            }
        }
    }
}
