package com.signova;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexionBD {

    private static final String URL = "jdbc:mysql://localhost:3306/signova_db";
    private static final String USER = "root";
    private static final String PASSWORD = "";

    public static Connection obtenerConexion() {
        Connection conexion = null;

        try {
            // Cargar el driver (opcional en versiones nuevas)
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Crear conexión
            conexion = DriverManager.getConnection(URL, USER, PASSWORD);
            System.out.println("Conexión exitosa a la base de datos.");

        } catch (ClassNotFoundException e) {
            System.err.println("Error: Driver no encontrado.");
            e.printStackTrace();

        } catch (SQLException e) {
            System.err.println("Error al conectar con la base de datos.");
            System.err.println(e.getMessage());
        }

        return conexion;
    }
}