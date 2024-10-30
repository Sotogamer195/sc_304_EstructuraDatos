package RegistroUsuarios;

import javax.swing.JOptionPane;

public class Rutina {
    private NodoP cima;
    
    public Rutina() {
        this.cima = null;
    }
    
    public void apilar() {
        Usuario u = new Usuario();
        u.setNombre(JOptionPane.showInputDialog("Ingrese su nombre"));
        u.setApellidos(JOptionPane.showInputDialog("Ingrese sus apellidos"));
        u.setNickname(JOptionPane.showInputDialog("Ingrese su nombre o nick de usuario"));
        u.setContraseña(JOptionPane.showInputDialog("Ingrese su contraseña"));
        String activo = JOptionPane.showInputDialog("¿Está activo? \nSí = True\nNo = False");
        if(activo.equalsIgnoreCase("True")) {
            JOptionPane.showMessageDialog(null, "El estado del usuario es Activo");
            u.setEstado(true);
        } else {
            JOptionPane.showMessageDialog(null, "El estado del usuario es inactivo");
            u.setEstado(false);
        }
    }
}
