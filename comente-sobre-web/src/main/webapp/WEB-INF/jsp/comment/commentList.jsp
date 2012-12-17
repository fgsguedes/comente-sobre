<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<!doctype html>
<html>

<head>
    <meta http-equiv="Content-Type" content="te1xt/html; charset=utf-8"/>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">

    <title>Comente Sobre - Assunto</title>

    <link type="text/css" rel="stylesheet" href="/css/normalize.css"/>
    <link type="text/css" rel="stylesheet" href="/css/bootstrap.css"/>
    <link type="text/css" rel="stylesheet" href="/css/bootstrap-responsive.css"/>
</head>

<body>

<div class="container">

    <%@ include file="/WEB-INF/jsp/includes/header.jsp" %>

    <h1>${subject.name}</h1>

    <table class="table table-striped">

        <tbody>

        <c:forEach items="${commentList}" var="comment">
            <tr>
                <td>
                    <b>${comment.owner.email}</b> comentou em <fmt:formatDate value="${comment.date}" pattern="dd/MM/yyyy" />:<br />
                        ${comment.text}
                </td>
            </tr>

        </c:forEach>

        </tbody>

    </table>

    <a href="/comente-sobre/${subject.id}" class="btn">Comentar</a>
    <a href="/comente-sobre">Trocar de assunto</a>

</div>

</body>

</html>
