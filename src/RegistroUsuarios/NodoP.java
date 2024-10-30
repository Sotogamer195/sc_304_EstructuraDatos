package RegistroUsuarios;

public class NodoP {
    // Atributos de la clase NodoP
    private Usuario elemento;
    private NodoP siguiente;
    
    // Constructor vacío
    public NodoP() {
        this.siguiente = null;
    }

    // Getters y Setters
    public Usuario getElemento() {
        return elemento;
    }

    public void setElemento(Usuario elemento) {
        this.elemento = elemento;
    }

    public NodoP getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(NodoP siguiente) {
        this.siguiente = siguiente;
    }
}
