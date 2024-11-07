package RegistroUsuarios;

public class NodoAuto {
    // Atributos de la clase
    private Auto auto;
    private NodoAuto next;
    private NodoAuto prev;

    // Constructor
    public NodoAuto(Auto auto) {
        this.auto = auto;
        this.next = null;
        this.prev = null;
    }

    // Getters y Setters
    public Auto getAuto() {
        return auto;
    }

    public void setAuto(Auto auto) {
        this.auto = auto;
    }

    public NodoAuto getNext() {
        return next;
    }

    public void setNext(NodoAuto next) {
        this.next = next;
    }

    public NodoAuto getPrev() {
        return prev;
    }

    public void setPrev(NodoAuto prev) {
        this.prev = prev;
    }
}
