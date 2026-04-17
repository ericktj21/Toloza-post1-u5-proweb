package com.ejemplo.servlet;

import com.ejemplo.model.Tarea;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "TareasServlet", urlPatterns = {"/tareas"})
public class TareasServlet extends HttpServlet {

    private final List<Tarea> tareas = new ArrayList<>();
    private int contadorId = 1;

    @Override
    public void init() {
        tareas.add(new Tarea(contadorId++, "Leer documentacion de Servlet"));
        tareas.add(new Tarea(contadorId++, "Implementar ciclo POST-REDIRECT-GET"));
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("tareas", tareas);
        req.getRequestDispatcher("/WEB-INF/views/tareas.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String accion = req.getParameter("accion");

        if ("agregar".equals(accion)) {
            agregarTarea(req, resp);
            return;
        }

        if ("eliminar".equals(accion)) {
            eliminarTarea(req);
        }

        resp.sendRedirect(req.getContextPath() + "/tareas");
    }

    private void agregarTarea(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String titulo = req.getParameter("titulo");
        if (titulo == null || titulo.trim().isEmpty()) {
            req.setAttribute("error", "El titulo es obligatorio.");
            req.setAttribute("tareas", tareas);
            req.getRequestDispatcher("/WEB-INF/views/tareas.jsp").forward(req, resp);
            return;
        }

        tareas.add(new Tarea(contadorId++, titulo.trim()));
        resp.sendRedirect(req.getContextPath() + "/tareas");
    }

    private void eliminarTarea(HttpServletRequest req) {
        try {
            int id = Integer.parseInt(req.getParameter("id"));
            tareas.removeIf(t -> t.getId() == id);
        } catch (NumberFormatException ignored) {
            // Si el id no es valido, se ignora la eliminacion.
        }
    }
}
