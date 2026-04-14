package servlet;

import dao.UsuarioDAO;
import modelo.Usuario;
import java.io.IOException;
import java.util.List;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.WebServlet;

@WebServlet("/listar")
public class ListarUsuariosServlet extends HttpServlet {
    private UsuarioDAO dao = new UsuarioDAO();

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        List<Usuario> lista = dao.obtenerUsuarios();
        request.setAttribute("usuarios", lista);
        request.getRequestDispatcher("listaUsuarios.jsp").forward(request, response);
    }
}