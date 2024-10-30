package RegistroUsuarios;

import javax.swing.JOptionPane;

public class Rutina {

    private NodoP cima;

    public Rutina() {
        this.cima = null;
    }

    public void registrarUsuario() {
        Usuario u = new Usuario();
        u.setNombre(JOptionPane.showInputDialog("Ingrese su nombre"));
        u.setApellidos(JOptionPane.showInputDialog("Ingrese sus apellidos"));
        u.setNickname(JOptionPane.showInputDialog("Ingrese su nombre o nick de usuario"));
        u.setContraseña(JOptionPane.showInputDialog("Ingrese su contraseña"));
        String activo = JOptionPane.showInputDialog("¿Está activo? \nSí = True\nNo = False");
        if (activo.equalsIgnoreCase("True") || activo.equalsIgnoreCase("Si")) {
            JOptionPane.showMessageDialog(null, "El estado del usuario es Activo");
            u.setEstado(true);
        } else {
            JOptionPane.showMessageDialog(null, "El estado del usuario es inactivo");
            u.setEstado(false);
        }
        NodoP nuevo = new NodoP();
        nuevo.setElemento(u);
        if(esVacia()) {
            cima = nuevo; 
        } else {
            nuevo.setSiguiente(cima);
            cima = nuevo;
        }
    }

    public boolean iniciarSesion(String usuario, String contrasenia) {
        NodoP aux = cima;
        while(aux != null) {
            if(aux.getElemento().getNickname().equals(usuario) &&
                    aux.getElemento().getContraseña().equals(contrasenia)) {
                JOptionPane.showMessageDialog(null, 
                        "Bienvenido " + aux.getElemento().getNickname());
                return true;                
            }
            aux = aux.getSiguiente();
        }
        JOptionPane.showMessageDialog(null, "No existe un usuario con esos datos");
        return false;
    }
    
    public void mostrarUsuarios() {
        if (!esVacia()) {
            String s = "";
            NodoP aux = cima;
            while (aux != null) {
                s = s + "El nickname del usuario es: " + aux.getElemento().getNickname()
                        + ", contraseña: " + aux.getElemento().getContraseña();
                aux = aux.getSiguiente();
            }
            JOptionPane.showMessageDialog(null, "Los usuarios ingresados al sistema son:\n" + s);
        } else {
            JOptionPane.showMessageDialog(null, "No se encuentran usuarios en la sistema");
        }
    }

    public boolean esVacia() {
        if (cima == null) {
            return true;
        } else {
            return false;
        }
    }
}
