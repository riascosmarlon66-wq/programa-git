package com.signova;

import dao.UsuarioDAO;
import modelo.Usuario;
import java.util.List;

public class PruebaConexion {

    public static void main(String[] args) {
        UsuarioDAO dao = new UsuarioDAO();

        System.out.println("=== INICIO DE PRUEBA ===");

        System.out.println("\n1. Insertando usuario...");
        dao.insertarSiNoExiste("PruebaJava");

        System.out.println("\n2. Listando usuarios...");
        List<Usuario> usuarios = dao.obtenerUsuarios();
        for (Usuario u : usuarios) {
            System.out.println("ID: " + u.getId() + " | Nombre: " + u.getNombre());
        }

        System.out.println("\n3. Buscando usuario con ID 1...");
        Usuario usuario = dao.obtenerUsuarioPorId(1);
        if (usuario != null) {
            System.out.println("Encontrado: " + usuario.getId() + " - " + usuario.getNombre());
        } else {
            System.out.println("Usuario no encontrado.");
        }

        System.out.println("\n4. Actualizando usuario con ID 1...");
        if (dao.actualizarUsuario(1, "Pedro Actualizado")) {
            System.out.println("Usuario actualizado correctamente.");
        } else {
            System.out.println("No se pudo actualizar.");
        }

        System.out.println("\n5. Eliminando usuario con ID 2...");
        if (dao.eliminarUsuario(2)) {
            System.out.println("Usuario eliminado correctamente.");
        } else {
            System.out.println("No se pudo eliminar.");
        }

        System.out.println("\n6. Lista final de usuarios...");
        usuarios = dao.obtenerUsuarios();
        for (Usuario u : usuarios) {
            System.out.println("ID: " + u.getId() + " | Nombre: " + u.getNombre());
        }

        System.out.println("\n=== FIN DE PRUEBA ===");
    }
}