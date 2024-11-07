package RegistroUsuarios;

import javax.swing.JOptionPane;

public class ListaSC {

    private NodoLSC inicio;
    private NodoLSC fin;

    public ListaSC() {
        this.inicio = null;
        this.fin = null;
    }

    public boolean esVacia() {
        if (inicio == null) {
            return true;
        } else {
            return false;
        }
    }

    public void agregar() {
        Clientes c = new Clientes();
        c.setNombre(JOptionPane.showInputDialog(null,
                "Digite su nombre: "));
        c.setApellido(JOptionPane.showInputDialog(null, "Digite su primer apellido: "));
        c.setEdad(Integer.parseInt(JOptionPane.showInputDialog("Digite su edad: ")));
        c.setCedula(Integer.parseInt(JOptionPane.showInputDialog("Digite su numero de cedula: ")));
        NodoLSC nuevo = new NodoLSC();
        nuevo.setElemento(c);
        if (esVacia()) {
            inicio = nuevo;
            fin = nuevo;
            fin.setSiguiente(inicio);
        } else if (c.getCedula() < inicio.getElemento().getCedula()) {
            nuevo.setSiguiente(inicio);
            fin.setSiguiente(inicio);
            inicio = nuevo;
        } else if (c.getCedula() > fin.getElemento().getCedula()) {
            fin.setSiguiente(nuevo);
            fin = nuevo; //fin=fin.getSiguiente();
            fin.setSiguiente(inicio);
        } else {
            NodoLSC aux = inicio;
            while (aux.getSiguiente().getElemento().getCedula()
                    < c.getCedula()) {
                aux = aux.getSiguiente();
            }
            nuevo.setSiguiente(aux.getSiguiente());
            aux.setSiguiente(nuevo);
        }
        JOptionPane.showMessageDialog(null, "Elemento agregado");
    }

    public void editar() {
        String botones[] = {"Nombre", "Apellido", "Edad", "Salir"};
        int cedula = Integer.parseInt(JOptionPane.showInputDialog("Digite la cédula del cliente a editar: "));
        if (esVacia()) {
            JOptionPane.showMessageDialog(null, "La lista está vacía.");
            return;
        }
        NodoLSC aux = inicio;
        boolean frene = false;
        while (!frene) {
            if (aux.getElemento().getCedula() == cedula) {
                int boton = JOptionPane.showOptionDialog(
                        null,
                        "¡Bienvenido al menu de editar, seleccione la opcion que desea realizar!",
                        "Seleccione",
                        JOptionPane.DEFAULT_OPTION,
                        JOptionPane.QUESTION_MESSAGE,
                        null,
                        botones,
                        "Agregar otro precio");

                if (boton == 0) {
                    aux.getElemento().setNombre(JOptionPane.showInputDialog("Digite el nuevo nombre: "));
                    JOptionPane.showMessageDialog(null, "Datos del cliente actualizados.");
                } else if (boton == 1) {
                    aux.getElemento().setApellido(JOptionPane.showInputDialog("Digite el nuevo apellido: "));
                    JOptionPane.showMessageDialog(null, "Datos del cliente actualizados.");
                } else if (boton == 2) {
                    aux.getElemento().setEdad(Integer.parseInt(JOptionPane.showInputDialog("Digite su nueva edad: ")));
                    JOptionPane.showMessageDialog(null, "Datos del cliente actualizados.");
                } else {
                    JOptionPane.showMessageDialog(null, "¡Hasta luego!");
                    frene = true;
                }
                aux = aux.getSiguiente();

            } else {
                JOptionPane.showMessageDialog(null, "¡Cliente no encontrado!");
                frene = true;
            }
        }
    }

    public void inactivar() {
        int cedula = Integer.parseInt(JOptionPane.showInputDialog("Ingrese la cédula del cliente a inactivar: "));
        if (esVacia()) {
            JOptionPane.showMessageDialog(null, "La lista está vacía.");
            return;
        }
        NodoLSC aux = inicio;
        boolean encontrado = false;

        do {
            if (aux.getElemento().getCedula() == cedula) {
                // Se encontró el cliente, se procede a inactivar
                aux.getElemento().setActivo(false);  // Se inactiva el cliente
                JOptionPane.showMessageDialog(null, "Cliente inactivo.");
                encontrado = true;
                break;
            }
            aux = aux.getSiguiente();
        } while (aux != inicio);

        if (!encontrado) {
            JOptionPane.showMessageDialog(null, "Cliente no encontrado.");
        }
    }
}
