package br.com.hardcoded.comentesobre.web.controllers;

import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Resource;
import br.com.caelum.vraptor.Result;
import br.com.hardcoded.comentesobre.core.api.CommentApi;
import br.com.hardcoded.comentesobre.core.api.SubjectApi;
import br.com.hardcoded.comentesobre.core.entities.Comment;
import br.com.hardcoded.comentesobre.core.entities.Subject;

import java.util.List;

/**
 * User: Filipe
 * Date: 17/12/12
 */
@Resource
@Path("/comente-sobre")
public class CommentController {

    private final Result result;

    public CommentController(Result result) {
        this.result = result;
    }

    @Get("/{subject.id}")
    public void commentForm(final Subject subject) {

        final SubjectApi subjectApi = new SubjectApi();

        final Subject databaseSubject = subjectApi.find(subject);

        if (databaseSubject == null) {
            result.redirectTo(SubjectController.class).subjectForm();
        } else {
            result.include("subject", databaseSubject);
        }
    }

    @Post("/{comment.subject.id}/submit")
    public void submitComment(final Comment comment) {

        final CommentApi commentApi = new CommentApi();
        final Comment savedComment = commentApi.save(comment);

        result.redirectTo(
                String.format("/comente-sobre/%s/comentarios", savedComment.getSubject().getId())
        );
    }

    @Get("/{subject.id}/comentarios")
    public List<Comment> commentList(final Subject subject) {

        final SubjectApi subjectApi = new SubjectApi();

        final Subject databaseSubject = subjectApi.find(subject);

        if (databaseSubject == null) {

            result.redirectTo(SubjectController.class).subjectForm();
            return null;
        } else {

            result.include("subject", databaseSubject);

            final CommentApi commentApi = new CommentApi();
            return commentApi.list(databaseSubject);
        }
    }

}
