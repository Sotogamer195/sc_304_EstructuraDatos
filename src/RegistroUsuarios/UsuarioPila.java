package RegistroUsuarios;

import Catalogo_Autos.MenuCatalogo;
import javax.swing.JOptionPane;

public class UsuarioPila {

    private NodoP cima;

    public UsuarioPila() {
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
        if (esVacia()) {
            cima = nuevo;
        } else {
            nuevo.setSiguiente(cima);
            cima = nuevo;
        }
    }

    public boolean iniciarSesion(String usuario, String contrasenia) {
        // Instancia de Menu de autos
        MenuCatalogo mc = new MenuCatalogo();
        NodoP aux = cima;
        while (aux != null) {
            if (aux.getElemento().getNickname().equals(usuario)
                    && aux.getElemento().getContraseña().equals(contrasenia)) {
                JOptionPane.showMessageDialog(null,
                        "Bienvenido " + aux.getElemento().getNickname());
                mc.mostrarMenu();
                return true;
            }
            aux = aux.getSiguiente();
        }
        JOptionPane.showMessageDialog(null,
                "¡Acceso Denegado. No existe un usuario con esos datos!");
        return false;
    }

    public void mostrarUsuarios() {
        if (!esVacia()) {
            String s = "";
            NodoP aux = cima;
            while (aux != null) {
                s = s + "El nickname del usuario es: " + aux.getElemento().getNickname()
                        + ", contraseña: " + ocultarContrasenia()
                        + " y ¿su estado de usuario está vigente? " + aux.getElemento().isEstado() + "\n";
                aux = aux.getSiguiente();
            }
            JOptionPane.showMessageDialog(null, "Los usuarios ingresados al sistema son:\n" + s);
        } else {
            JOptionPane.showMessageDialog(null, "No se encuentran usuarios en la sistema");
        }
    }

    public String ocultarContrasenia() {
        if (cima != null) {
            NodoP aux = cima;
            // Se usa Stringbuilder para construir la cadena
            StringBuilder digitos = new StringBuilder();
            int i = 0;
            for (i = 0; i < aux.getElemento().getContraseña().length(); i++) {
                // Se añade un * por cada caracter que tenga la contraseña
                digitos.append('*');
            }
            // Se convierte el stringbuilder a toString para poder retornar
            return digitos.toString();
        }
        // Se retorna una cadena vacía si la pila está vacía
        return "";
    }

    public void inactivarUsuario(String usuario, String contrasenia) {
        NodoP aux = cima;
        while (aux != null) {
            if (aux.getElemento().getNickname().equals(usuario)
                    && aux.getElemento().getContraseña().equals(contrasenia)) {
                aux.getElemento().setEstado(false);
                aux = aux.getSiguiente();
            }
        }
        JOptionPane.showMessageDialog(null, "Se ha inactivado al usuario " + usuario);

    }

    public boolean esVacia() {
        if (cima == null) {
            return true;
        } else {
            return false;
        }
    }
}
