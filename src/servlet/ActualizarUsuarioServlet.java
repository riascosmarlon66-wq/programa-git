package servlet;

import dao.UsuarioDAO;
import java.io.IOException;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.WebServlet;

@WebServlet("/actualizar")
public class ActualizarUsuarioServlet extends HttpServlet {
    private UsuarioDAO dao = new UsuarioDAO();

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        int id = Integer.parseInt(request.getParameter("id"));
        String nombre = request.getParameter("nombre");

        dao.actualizarUsuario(id, nombre);
        response.sendRedirect("listar");
    }
}