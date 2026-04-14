package servlet;

import dao.UsuarioDAO;
import java.io.IOException;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.WebServlet;

@WebServlet("/eliminar")
public class EliminarUsuarioServlet extends HttpServlet {
    private UsuarioDAO dao = new UsuarioDAO();

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        int id = Integer.parseInt(request.getParameter("id"));
        dao.eliminarUsuario(id);
        response.sendRedirect("listar");
    }
}