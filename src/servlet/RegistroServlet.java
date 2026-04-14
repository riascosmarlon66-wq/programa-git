package servlet;

import dao.UsuarioDAO;
import java.io.IOException;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.WebServlet;

@WebServlet("/registro")
public class RegistroServlet extends HttpServlet {
    private UsuarioDAO dao = new UsuarioDAO();

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String nombre = request.getParameter("nombre");
        dao.insertarSiNoExiste(nombre);
        response.sendRedirect("listaUsuarios.jsp");
    }
}