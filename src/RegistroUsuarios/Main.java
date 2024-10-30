package RegistroUsuarios;

import javax.swing.JOptionPane;

public class Main {

    public static void main(String[] args) {
        // Variable para controlar el menú
        int opcion = 0;
        // Instancia de la clase Rutina
        Rutina r = new Rutina();
        // Ciclo principal del programa
        do {
            // Menu principal 
            String input = JOptionPane.showInputDialog(
                    "----- Menú Principal -----\n"
                    + "1. Agregar Usuario\n"
                    + "2. Inactivar Usuarios\n"
                    + "3. Mostrar Usuarios\n"
                    + "4. Salir\n"
                    + "Ingrese la opción deseada:");
            try {
                opcion = Integer.parseInt(input);
            } catch (NumberFormatException e) {
                opcion = 0; // Si la entrada no es un número válido, se establece la opción en 0.
            }

            // Se usa un switch para manejar las opciones del menú
            switch (opcion) {
                case 1:
                    r.apilar();
                    break;
                case 2:
                    break;
                case 3:
                    break;
                case 4:
                    JOptionPane.showMessageDialog(null,
                            "Saliendo, gracias por usar al programa");
            }
        } while (opcion != 4);
    }
}
