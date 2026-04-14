package dao;

import java.sql.*;

import com.signova.ConexionBD;

public class UsuarioDAO {

    public void listarUsuarios() {
        String sql = "SELECT * FROM usuarios";
        try (Connection con = ConexionBD.obtenerConexion();
             PreparedStatement ps = con.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                System.out.println(rs.getInt("id") + " - " + rs.getString("nombre"));
            }

        } catch (Exception e) {
            System.out.println("Error");
        }
    }

    public boolean insertarSiNoExiste(String nombre) {
        String sql = "INSERT INTO usuarios (nombre) VALUES (?)";

        try (Connection con = ConexionBD.obtenerConexion();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, nombre);
            ps.executeUpdate();
            return true;

        } catch (Exception e) {
            return false;
        }
    }
}