package br.com.hardcoded.comentesobre.core.api;

import br.com.hardcoded.comentesobre.core.entities.Subject;
import br.com.hardcoded.comentesobre.core.persistence.EntityManagerFactory;
import br.com.hardcoded.comentesobre.core.persistence.Repositories;
import br.com.hardcoded.comentesobre.core.persistence.SubjectRepository;
import org.apache.commons.lang3.StringUtils;

import javax.persistence.EntityManager;
import java.util.List;

/**
 * User: Filipe
 * Date: 17/12/12
 */
public class SubjectApi {


    public Subject find(Subject subject) {

        final EntityManager entityManager = EntityManagerFactory.getEntityManager();

        try {
            final SubjectRepository subjectRepository = Repositories.getSubjectRepository(entityManager);
            return subjectRepository.find(subject);

        } finally {
            if (entityManager.isOpen()) {
                entityManager.close();
            }
        }
    }

    public Subject saveIfNotExist(Subject subject) {

        final String subjectId = StringUtils
                .stripAccents(subject.getName())
                .trim()
                .toLowerCase()
                .replaceAll("[\\s\\t]+", "-");

        subject.setId(subjectId);

        final EntityManager entityManager = EntityManagerFactory.getEntityManager();

        try {
            final SubjectRepository subjectRepository = Repositories.getSubjectRepository(entityManager);

            final Subject withName = subjectRepository.find(subject);

            return (withName != null) ? withName : subjectRepository.save(subject);

        } finally {
            if (entityManager.isOpen()) {
                entityManager.close();
            }
        }
    }

    public List<Subject> listWithComments() {

        final EntityManager entityManager = EntityManagerFactory.getEntityManager();

        try {
            final SubjectRepository subjectRepository = Repositories.getSubjectRepository(entityManager);
            return subjectRepository.listWithComments();

        } finally {
            if (entityManager.isOpen()) {
                entityManager.close();
            }
        }
    }

}
