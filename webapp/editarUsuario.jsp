<%@ page import="modelo.Usuario" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<%
    Usuario usuario = (Usuario) request.getAttribute("usuario");
%>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Editar Usuario</title>
</head>
<body>
    <h2>Editar Usuario</h2>

    <form action="actualizar" method="post">
        <input type="hidden" name="id" value="<%= usuario.getId() %>">

        <label>Nombre:</label>
        <input type="text" name="nombre" value="<%= usuario.getNombre() %>" required>

        <button type="submit">Actualizar</button>
    </form>

    <br>
    <a href="listar">Volver a la lista</a>
</body>
</html>