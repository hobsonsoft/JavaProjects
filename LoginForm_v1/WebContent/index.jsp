<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Pantalla de Inicio</title>
</head>
<body>
<H1>Inicie Sesion Porfavor</H1>
<br>
    <form action="validante" method="post">
            <label>Nombre:</label>
            <input type="text" name="nombre">
            <br>
            <label>Clave:</label>
            <input type="password" name="clave">
            <button type="submit">inicio</button>
            <br>
          ${estado}
        </form>
</body>
</html>