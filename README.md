# U5 PostContenido 1 - Gestion de Tareas con Servlet

Proyecto Java Web con Servlet + JSP + JSTL para listar, agregar y eliminar tareas en memoria.

## Requisitos
- Java 17+
- Maven 3.8+
- Tomcat 10.x

## Ejecutar
1. Compilar:
   ```bash
   mvn clean package
   ```
2. Desplegar `target/gestion-tareas-1.0-SNAPSHOT.war` en Tomcat.
3. Abrir:
   `http://localhost:8080/gestion-tareas/tareas`

## Funcionalidades
- GET `/tareas`: lista de tareas iniciales
- POST `/tareas` accion=agregar: agrega tarea
- POST `/tareas` accion=eliminar: elimina por id
- Flujo PRG (Post-Redirect-Get)

## Entrega GitHub
Nombre sugerido: `apellido-post1-u5`
