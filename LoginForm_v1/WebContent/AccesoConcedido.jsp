<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Acceso Concedido, Bienvenido</title>
</head>
<body>
<H1>Administracion de usuarios</H1>
<br>
<H2>Porfavor ingrese los datos nuevo usuario.</H2>
<form action="ValidanteNuevoUsuario" method="post">
            <label>nuevo usuario:</label>
            <input type="text" name="nuevo_nombre">
            <br>
            <label>nueva clave:</label>
            <input type="password" name="nueva_clave">
            <br>
            <button type="submit">Crear Usuario</button>
        </form>
</body>
</html>