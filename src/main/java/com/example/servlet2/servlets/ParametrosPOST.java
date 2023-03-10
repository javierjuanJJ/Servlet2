package com.example.servlet2.servlets;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "ParametrosPOST", value = "/ParametrosPOST")
public class ParametrosPOST extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("Método doGet");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
// Recibimos parámetros y los asignamos a variables Java
        String id = request.getParameter("id");
        String nombre = request.getParameter("nombre");

        // Imprimimos los parámetros recibidos
        System.out.println("Método doPost que recibe parámetros: Id (" + id + ") y nombre (" + nombre + ")");

        // Aplicamos la lógica de nuestro modelo de negocio
        // Si el id del usuario es mayor de 5, se devolverá una respuesta HTML"
        if (id.equals("10")) {
            response.setContentType("text/html;charset=UTF-8");
            try (PrintWriter out = response.getWriter()) {
                out.println("<!DOCTYPE html>");
                out.println("<html>");
                out.println("<head>");
                out.println("<title>Login</title>");
                out.println("</head>");
                out.println("<body>");
                out.println("<h3>Identificador de usuario (" + id + " correcto)</h3>");
                out.println("</body>");
                out.println("</html>");
            }
        } else {
            // Respuesta de error indicando que no estamos autorizados
            response.sendError(HttpServletResponse.SC_UNAUTHORIZED);
        }
    }
}
