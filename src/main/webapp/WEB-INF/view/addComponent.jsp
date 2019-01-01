<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Добавление / обновление комплектующих</title>
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
<div align="center">
    <h3>Добавить / обновить компонент</h3>
    <form:form action="save" modelAttribute="component" method="post">
        <form:hidden path="id"/>
        <table>
            <tr>
                <td>Наименование</td>
                <td><form:input path="name"/></td>
            </tr>
            <tr>
                <td>Необходимость</td>
                <td><form:checkbox path="necessary"/></td>
            </tr>
            <tr>
                <td>Количество</td>
                <td><form:input path="numberComponent"/></td>
            </tr>
            <tr>
                <td></td>
                <td><input type="submit" value="Сохранить"  align="right"/></td>
            </tr>

        </table>
    </form:form>
    <p><a href="${pageContext.request.contextPath}/">Назад к списку комплектующих</a></p>
</div>
</body>
</html>
