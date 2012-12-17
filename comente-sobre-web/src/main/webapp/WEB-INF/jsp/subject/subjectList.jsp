<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
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

    <c:if test="${empty subjectList}">

        <div class="alert">
            Nada foi comentário sobre nenhum assunto ainda. <a href="/comente-sobre">Sera o primeiro a efetuar um
            comentário!</a>
        </div>

    </c:if>

    <c:if test="${not empty subjectList}">

        <table class="table table-striped">

            <thead>
            <tr>
                <th>Assunto</th>
                <th>Comentários</th>
                <th>&nbsp;</th>
                <th>&nbsp;</th>
            </tr>
            </thead>

            <tbody>

            <c:forEach items="${subjectList}" var="subject">
                <tr>
                    <td>${subject.name}</td>
                    <td>${fn:length(subject.comments)}</td>
                    <td><a href="/comente-sobre/${subject.id}">Efetuar um comentário</a></td>
                    <td><a href="/comente-sobre/${subject.id}/comentarios">Ver comentários</a></td>
                </tr>

            </c:forEach>

            </tbody>

        </table>

    </c:if>

</div>

</body>

</html>
