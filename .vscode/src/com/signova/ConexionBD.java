
 package com.signova;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexionBD {

    private static final String URL = "jdbc:mysql://localhost:3306/signova_db?useSSL=false&serverTimezone=UTC";
    private static final String USER = "root";
    private static final String PASSWORD = "";

    public static Connection obtenerConexion() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            return DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (ClassNotFoundException e) {
            System.err.println("Driver de MySQL no encontrado.");
            System.err.println(e.getMessage());
        } catch (SQLException e) {
            System.err.println("Error al conectar con la base de datos.");
            System.err.println(e.getMessage());
        }
        return null;
    }
}