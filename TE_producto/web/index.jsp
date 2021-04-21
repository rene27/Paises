<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Lista de Paises</h1>
        <table border="1">
            <tr>
                <th>Id</th>
                <th>Nombre</th>
                <th>Capital</th>
                <th>Habitantes</th>
            </tr>
            <c:forEach var="item" items="${lista}">
            <tr>
                <th>${item.id}</th>
                <th>${item.nombre}</th>
                <th>${item.capital}</th>
                <th>${item.habitantes}</th>
            </tr>
            </c:forEach>
        </table>
    </body>
</html>
