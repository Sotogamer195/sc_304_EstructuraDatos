package RegistroUsuarios;

import javax.swing.JOptionPane;

public class SubmenusCatalogos {
    //Submenu Clientes
    public static void Submenu_Clientes() {
        ListaSC l = new ListaSC();
        String botonesC[] = {"Agregar", "Editar", "Inactivar", "Salir"};
        boolean detener = false;

        while (!detener) {
            int botonP = JOptionPane.showOptionDialog(
                    null,
                    "¡Bienvenido al menu de cliente, seleccione la opcion que desea realizar!",
                    "Seleccione",
                    JOptionPane.DEFAULT_OPTION,
                    JOptionPane.QUESTION_MESSAGE,
                    null,
                    botonesC,
                    "Agregar");

            switch (botonP) {
                case 0:
                    JOptionPane.showMessageDialog(null, "Bienvenid@ a la opcion de Agregrar");
                    l.agregar();
                    break;

                case 1:
                    JOptionPane.showMessageDialog(null, "Bienvenid@ a la opcion de Editar");
                    l.editar();
                    break;

                case 2:
                    JOptionPane.showMessageDialog(null, "Bienvenid@ a la opcion de Inactivar");
                    l.inactivar();
                    break;

                default:
                    JOptionPane.showMessageDialog(null, "¡Muchas gracias por entrar, hasta luego!");
                    detener = true;
            }
        }
    }

    //Submenu Reparaciones 
    public static void Submenu_Reparaciones() {
        String botonesC[] = {"Agregar", "Editar", "Inactivar", "Salir"};
        boolean detener = false;

        while (!detener) {
            int botonP = JOptionPane.showOptionDialog(
                    null,
                    "¡Bienvenido al menu de reparaciones, seleccione la opcion que desea realizar!",
                    "Seleccione",
                    JOptionPane.DEFAULT_OPTION,
                    JOptionPane.QUESTION_MESSAGE,
                    null,
                    botonesC,
                    "Agregar");

            switch (botonP) {
                case 0:
                    JOptionPane.showMessageDialog(null, "Bienvenid@ a la opcion de Agregar");

                    break;

                case 1:
                    JOptionPane.showMessageDialog(null, "Bienvenid@ a la opcion de Editar");

                    break;

                case 2:
                    JOptionPane.showMessageDialog(null, "Bienvenid@ a la opcion de Inactivar");

                    break;

                default:
                    JOptionPane.showMessageDialog(null, "¡Muchas gracias por entrar, hasta luego!");
                    detener = true;
            }
        }
    }
}
