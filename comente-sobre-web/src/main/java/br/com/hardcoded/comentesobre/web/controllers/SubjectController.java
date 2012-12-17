package br.com.hardcoded.comentesobre.web.controllers;

import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Resource;
import br.com.caelum.vraptor.Result;
import br.com.hardcoded.comentesobre.core.api.SubjectApi;
import br.com.hardcoded.comentesobre.core.entities.Subject;

import java.util.List;

/**
 * User: Filipe
 * Date: 16/12/12
 */
@Resource
public class SubjectController {

    private final Result result;

    public SubjectController(Result result) {
        this.result = result;
    }

    @Get("/comente-sobre")
    public void subjectForm() {

    }

    @Post("/comente-sobre/submit")
    public void submitSubject(final Subject subject) {

        final SubjectApi subjectApi = new SubjectApi();

        subjectApi.saveIfNotExist(subject);

        result.redirectTo(
                String.format("/comente-sobre/%s", subject.getId())
        );
    }

    @Get("/explorar-assuntos")
    public List<Subject> subjectList() {

        final SubjectApi subjectApi = new SubjectApi();
        return subjectApi.listWithComments();
    }
}
