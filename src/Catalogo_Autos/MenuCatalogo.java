package Catalogo_Autos;

import Catalogo_Cliente.SubmenusCatalogos;
import javax.swing.JOptionPane;

public class MenuCatalogo {

    CatalogoAutos catalogo = new CatalogoAutos();
    SubmenusCatalogos cliente = new SubmenusCatalogos();

    public void mostrarMenu() {
        int opcion;

        do {
            String menu = """
                --- Menú del Catalogo de Autos ---
                1. Agregar un auto
                2. Editar un auto
                3. Inactivar un auto
                4. Asignar usuario a un auto
                5. Imprimir catalogo de autos    
                6. Consultas de Cliente
                7. Consulta de Reparaciones
                8. Salir
                """;

            String input = JOptionPane.showInputDialog(menu + "\nSeleccione una opción:");
            if (input == null) {
                break;
            }

            opcion = Integer.parseInt(input);

            switch (opcion) {
                case 1: {
                    String marca = JOptionPane.showInputDialog("Marca del auto:");
                    String modelo = JOptionPane.showInputDialog("Modelo del auto:");
                    int anio = Integer.parseInt(JOptionPane.showInputDialog("Año del auto:"));
                    catalogo.agregarAuto(marca, modelo, anio);
                    JOptionPane.showMessageDialog(null, "Auto agregado exitosamente.");
                    break;
                }
                case 2: {
                    String marca = JOptionPane.showInputDialog("Marca del auto a editar:");
                    String modelo = JOptionPane.showInputDialog("Modelo del auto a editar:");
                    int anio = Integer.parseInt(JOptionPane.showInputDialog("Año del auto a editar:"));
                    String nuevaMarca = JOptionPane.showInputDialog("Nueva marca del auto:");
                    String nuevoModelo = JOptionPane.showInputDialog("Nuevo modelo del auto:");
                    int nuevoAnio = Integer.parseInt(JOptionPane.showInputDialog("Nuevo año del auto:"));
                    catalogo.editarAuto(marca, modelo, anio, nuevaMarca, nuevoModelo, nuevoAnio);
                    JOptionPane.showMessageDialog(null, "Auto editado exitosamente.");
                    break;
                }
                case 3: {
                    String marca = JOptionPane.showInputDialog("Marca del auto a inactivar:");
                    String modelo = JOptionPane.showInputDialog("Modelo del auto a inactivar:");
                    int anio = Integer.parseInt(JOptionPane.showInputDialog("Año del auto a inactivar:"));
                    catalogo.inactivarAuto(marca, modelo, anio);
                    JOptionPane.showMessageDialog(null, "Auto inactivado exitosamente.");
                    break;
                }
                case 4: {
                    String marca = JOptionPane.showInputDialog("Marca del auto para asignar usuario:");
                    String modelo = JOptionPane.showInputDialog("Modelo del auto para asignar usuario:");
                    int anio = Integer.parseInt(JOptionPane.showInputDialog("Año del auto para asignar usuario:"));
                    catalogo.asignarUsuario(marca, modelo, anio);
                    JOptionPane.showMessageDialog(null, "Usuario asignado al auto.");
                    break;
                }
                case 5: {
                    JOptionPane.showMessageDialog(null, "Mostrando el catálogo de autos:\n");
                    catalogo.imprimirCatalogo();
                    break;
                }
                case 6: {
                    cliente.Submenu_Clientes();
                    break;
                }
                case 7: {
                    cliente.Submenu_Reparaciones();
                    break;
                }
                case 8: {
                    JOptionPane.showMessageDialog(null, "Saliendo ...");
                }
            }
        } while (opcion != 8);
    }
}
