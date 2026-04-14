package dao;

import com.signova.ConexionBD;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import modelo.Usuario;

public class UsuarioDAO {

    public List<Usuario> obtenerUsuarios() {
        List<Usuario> lista = new ArrayList<>();
        String sql = "SELECT id, nombre FROM usuarios ORDER BY id ASC";

        try (Connection conexion = ConexionBD.obtenerConexion()) {
            if (conexion == null) {
                System.err.println("No se pudo obtener la conexión a la base de datos.");
                return lista;
            }

            try (PreparedStatement ps = conexion.prepareStatement(sql);
                 ResultSet rs = ps.executeQuery()) {

                while (rs.next()) {
                    Usuario usuario = new Usuario();
                    usuario.setId(rs.getInt("id"));
                    usuario.setNombre(rs.getString("nombre"));
                    lista.add(usuario);
                }
            }
        } catch (SQLException e) {
            System.err.println("Error al obtener usuarios:");
            System.err.println(e.getMessage());
        }

        return lista;
    }

    public Usuario obtenerUsuarioPorId(int idBuscado) {
        String sql = "SELECT id, nombre FROM usuarios WHERE id = ?";

        try (Connection conexion = ConexionBD.obtenerConexion()) {
            if (conexion == null) {
                System.err.println("No se pudo obtener la conexión a la base de datos.");
                return null;
            }

            try (PreparedStatement ps = conexion.prepareStatement(sql)) {
                ps.setInt(1, idBuscado);

                try (ResultSet rs = ps.executeQuery()) {
                    if (rs.next()) {
                        Usuario usuario = new Usuario();
                        usuario.setId(rs.getInt("id"));
                        usuario.setNombre(rs.getString("nombre"));
                        return usuario;
                    }
                }
            }
        } catch (SQLException e) {
            System.err.println("Error al buscar usuario:");
            System.err.println(e.getMessage());
        }

        return null;
    }

    public boolean insertarSiNoExiste(String nombre) {
        String sqlBuscar = "SELECT id FROM usuarios WHERE nombre = ?";
        String sqlInsertar = "INSERT INTO usuarios (nombre) VALUES (?)";

        try (Connection conexion = ConexionBD.obtenerConexion()) {
            if (conexion == null) {
                System.err.println("No se pudo obtener la conexión a la base de datos.");
                return false;
            }

            try (PreparedStatement psBuscar = conexion.prepareStatement(sqlBuscar)) {
                psBuscar.setString(1, nombre);
                try (ResultSet rs = psBuscar.executeQuery()) {
                    if (rs.next()) {
                        return false;
                    }
                }
            }

            try (PreparedStatement psInsertar = conexion.prepareStatement(sqlInsertar)) {
                psInsertar.setString(1, nombre);
                return psInsertar.executeUpdate() > 0;
            }
        } catch (SQLException e) {
            System.err.println("Error al insertar usuario:");
            System.err.println(e.getMessage());
        }

        return false;
    }

    public boolean actualizarUsuario(int id, String nombre) {
        String sql = "UPDATE usuarios SET nombre = ? WHERE id = ?";

        try (Connection conexion = ConexionBD.obtenerConexion()) {
            if (conexion == null) {
                System.err.println("No se pudo obtener la conexión a la base de datos.");
                return false;
            }

            try (PreparedStatement ps = conexion.prepareStatement(sql)) {
                ps.setString(1, nombre);
                ps.setInt(2, id);
                return ps.executeUpdate() > 0;
            }
        } catch (SQLException e) {
            System.err.println("Error al actualizar usuario:");
            System.err.println(e.getMessage());
        }

        return false;
    }

    public boolean eliminarUsuario(int id) {
        String sql = "DELETE FROM usuarios WHERE id = ?";

        try (Connection conexion = ConexionBD.obtenerConexion()) {
            if (conexion == null) {
                System.err.println("No se pudo obtener la conexión a la base de datos.");
                return false;
            }

            try (PreparedStatement ps = conexion.prepareStatement(sql)) {
                ps.setInt(1, id);
                return ps.executeUpdate() > 0;
            }
        } catch (SQLException e) {
            System.err.println("Error al eliminar usuario:");
            System.err.println(e.getMessage());
        }

        return false;
    }
}
