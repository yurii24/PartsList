<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<html>
<head>
    <title>Все компьютерные комплектующие</title>
    <style>
        table {
            font-family: arial, sans-serif;
            border-collapse: collapse;
            width: 70%;
        }

        td, th {
            border: 1px solid #dddddd;
            text-align: left;
            padding: 8px;
        }

        tr:nth-child(even) {
            background-color: #dddddd;
        }
    </style>
</head>
<body>
<h3 align="center">Все компьютерные комплектующие</h3>

<div align="center">

    <p><input type="button" value="Добавить комплектующие" onclick="window.location.href='add'; return false"></p>

    <p>
    <form action="${pageContext.request.contextPath}/">
        Поиск по наименованию
        <input type="text" name="search" value="${param.search}">
        <input type="submit" value="Найти">
    </form>
    </p>

    <table>
        <tr>
            <th>Показать:
                <c:url var="allComponents" value="/">
                    <c:param name="search" value="${search}"/>
                    <c:param name="necessary" value="0"/>
                </c:url>
                <c:url var="necessaryComponents" value="/">
                    <c:param name="search" value="${search}"/>
                    <c:param name="necessary" value="1"/>
                </c:url>
                <c:url var="optionalComponents" value="/">
                    <c:param name="search" value="${search}"/>
                    <c:param name="necessary" value="2"/>
                </c:url>

                <a href="${allComponents}">все детали</a>
                <a href="${necessaryComponents}">детали, необходимые для сборки</a>
                <a href="${optionalComponents}">опциональные детали</a>
            </th>
        </tr>
    </table>

    <table>

        <tr>
            <th>Наименование</th>
            <th>Необходимость</th>
            <th>Количество</th>
            <th></th>
            <th></th>
        </tr>

        <c:forEach var="itemComponent" items="${components}">
            <c:url var="updateLink" value="/update">
                <c:param name="componentId" value="${itemComponent.id}"/>
            </c:url>

            <c:url var="deleteLink" value="/delete">
                <c:param name="componentId" value="${itemComponent.id}"/>
            </c:url>

            <tr align="left">
                <td>${itemComponent.name}</td>
                <td>${(itemComponent.necessary ? "да" : "нет")}</td>
                <td>${itemComponent.numberComponent}</td>

                <td><a href="${updateLink}">Update</a></td>

                <td><a href="${deleteLink}"
                       onclick="if (!(confirm('Вы действительно хотите удалить компонент?'))) return false">Delete</a>
                </td>
            </tr>
        </c:forEach>
    </table>

    <c:forEach begin="1" end="${pages}" var="p">
        <c:url var="pageLink" value="/">
            <c:param name="page" value="${p}"/>
            <c:param name="search" value="${search}"/>
            <c:param name="necessary" value="${necessary}"/>
        </c:url>
        <a href="${pageLink}">${p}</a>
    </c:forEach>

    <p>Можно собрать ${numberComputers} компьютера(ов)</p>
</div>
</body>
</html>
