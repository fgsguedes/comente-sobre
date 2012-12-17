<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<!doctype html>
<html>

<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">

    <title>Comente Sobre - Assunto</title>

    <link type="text/css" rel="stylesheet" href="/css/styles.css"/>
    <link type="text/css" rel="stylesheet" href="/css/normalize.css"/>
    <link type="text/css" rel="stylesheet" href="/css/bootstrap.css"/>
    <link type="text/css" rel="stylesheet" href="/css/bootstrap-responsive.css"/>
</head>

<body>

<div class="container">

    <%@ include file="/WEB-INF/jsp/includes/header.jsp" %>

    <form action="/comente-sobre/${subject.id   }/submit" method="post" id="commentForm">

        <fieldset>

            <legend>O que deseja comentar sobre ${subject.name}?</legend>

            <input type="hidden" name="comment.subject.id" value="${subject.id}"/>
            <label for="email" class="email">
                E-mail:
            </label>
            <input type="text" name="comment.owner.email" value="${comment.owner.email}" id="email"/>

            <label for="comment" class="comment">
                Comentário:
            </label>
            <textarea id="comment" name="comment.text"></textarea>

            <div class="control-group">
                <div class="controls">

                    <button class="btn" type="submit">Enviar</button>
                    <a href="/comente-sobre">Trocar de assunto</a>

                </div>
            </div>

        </fieldset>

    </form>

</div>

<script type="text/javascript" src="https://ajax.googleapis.com/ajax/libs/jquery/1.8.3/jquery.min.js"></script>
<script type="text/javascript" src="/js/jquery.validate.js"></script>
<script type="text/javascript" src="/js/commentForm.js"></script>

</body>

</html>
