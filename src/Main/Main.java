package Main;

import RegistroUsuarios.UsuarioPila;
import javax.swing.JOptionPane;

public class Main {

    public static void main(String[] args) {
        // Variable para controlar el menú
        int opcion = 0;
        // Instancia de la clase Rutina
        UsuarioPila p = new UsuarioPila();
        // Ciclo principal del programa
        do {
            // Menu principal 
            String input = JOptionPane.showInputDialog(
                    "----- Menú Principal -----\n"
                    + "1. Registrar Usuario\n"
                    + "2. Iniciar Sesión\n"
                    + "3. Inactivar Usuarios\n"
                    + "4. Mostrar Usuarios\n"
                    + "5. Salir\n"
                    + "Ingrese la opción deseada:");
            try {
                opcion = Integer.parseInt(input);
            } catch (NumberFormatException e) {
                opcion = 0; // Si la entrada no es un número válido, se establece la opción en 0.
            }

            // Se usa un switch para manejar las opciones del menú
            switch (opcion) {
                case 1:
                    p.registrarUsuario();
                    break;
                case 2:
                    String usuario = JOptionPane.showInputDialog("Ingrese su nombre de usuario");
                    String contrasenia = JOptionPane.showInputDialog("Ingrese la contraseña");
                    p.iniciarSesion(usuario, contrasenia);
                    break;
                case 3:
                    String usuario2 = JOptionPane.showInputDialog("Ingrese su nombre de usuario");
                    String contrasenia2 = JOptionPane.showInputDialog("Ingrese la contraseña");
                    p.inactivarUsuario(usuario2, contrasenia2);
                    break;
                case 4:
                    p.mostrarUsuarios();
                    break;
                case 5:
                    JOptionPane.showMessageDialog(null,
                            "Saliendo, gracias por usar al programa");
            }
        } while (opcion != 5);
    }
}
