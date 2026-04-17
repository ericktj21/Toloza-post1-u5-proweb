<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <title>Gestion de Tareas</title>
    <style>
        body { font-family: Segoe UI, sans-serif; margin: 2rem; }
        table { border-collapse: collapse; width: 100%; margin-top: 1rem; }
        th, td { border: 1px solid #ccc; padding: 8px; text-align: left; }
        .error { color: #b00020; margin-top: .5rem; }
        .acciones { display: flex; gap: .5rem; }
    </style>
</head>
<body>
<h1>Lista de Tareas</h1>

<c:if test="${not empty error}">
    <p class="error">${error}</p>
</c:if>

<form method="post" action="${pageContext.request.contextPath}/tareas">
    <input type="hidden" name="accion" value="agregar">
    <input type="text" name="titulo" placeholder="Nueva tarea..." style="min-width: 280px;">
    <button type="submit">Agregar</button>
</form>

<table>
    <thead>
    <tr>
        <th>ID</th>
        <th>Titulo</th>
        <th>Acciones</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="t" items="${tareas}">
        <tr>
            <td>${t.id}</td>
            <td>${t.titulo}</td>
            <td>
                <form class="acciones" method="post" action="${pageContext.request.contextPath}/tareas">
                    <input type="hidden" name="accion" value="eliminar">
                    <input type="hidden" name="id" value="${t.id}">
                    <button type="submit">Eliminar</button>
                </form>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>
</body>
</html>
