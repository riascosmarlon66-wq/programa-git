package com.signova;

import dao.UsuarioDAO;

public class PruebaConexion {

    public static void main(String[] args) {

        UsuarioDAO dao = new UsuarioDAO();

        System.out.println("=== PRUEBA ===");

        dao.insertarSiNoExiste("Prueba");

        dao.listarUsuarios();

    }
}