<!DOCTYPE html>
<html>
<head>
    <title>Registro de Usuario</title>
</head>
<body>
    <h2>Formulario de Registro</h2>

    <form action="RegistroServlet" method="post">
        <label>Nombre:</label>
        <input type="text" name="nombre" required>
        <button type="submit">Guardar</button>
    </form>

    <br>
    <a href="RegistroServlet">Ver usuarios</a>
</body>
</html>