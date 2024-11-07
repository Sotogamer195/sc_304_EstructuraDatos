package RegistroUsuarios;

public class NodoLSC {

    private Clientes elemento;
    private NodoLSC siguiente;

    public NodoLSC() {
        this.siguiente = null;
    }

    public Clientes getElemento() {
        return elemento;
    }

    public void setElemento(Clientes elemento) {
        this.elemento = elemento;
    }

    public NodoLSC getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(NodoLSC siguiente) {
        this.siguiente = siguiente;
    }
}
