<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<!doctype html>
<html>

<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">

    <title>Comente Sobre - Assunto</title>

    <link type="text/css" rel="stylesheet" href="/css/normalize.css"/>
    <link type="text/css" rel="stylesheet" href="/css/bootstrap.css"/>
    <link type="text/css" rel="stylesheet" href="/css/bootstrap-responsive.css"/>
</head>

<body>

<div class="container">

    <%@ include file="/WEB-INF/jsp/includes/header.jsp" %>

    <form action="/comente-sobre/submit" method="post" id="subjectForm">

        <fieldset>

            <legend>Sobre o que deseja comentar?</legend>

            <div class="input-append">
                <input type="text" name="subject.name">
                <button class="btn" type="submit">Enviar</button>
            </div>

        </fieldset>

    </form>

    <a href="/explorar-assuntos">Explorar assuntos</a>

</div>

<script type="text/javascript" src="https://ajax.googleapis.com/ajax/libs/jquery/1.8.3/jquery.min.js"></script>
<script type="text/javascript" src="/js/jquery.validate.js"></script>
<script type="text/javascript" src="/js/subjectForm.js"></script>

</body>

</html>
