package Catalogo_Repuesto;

public class NodoDC {
    // Atributos del NodoDC
    private Repuesto elemento;
    private NodoDC siguiente;
    private NodoDC anterior;
    
    // Constructor de la clase
    public NodoDC() {
        this.siguiente = null;
        this.anterior = null;
    }

    // Getters y Setters
    public Repuesto getElemento() {
        return elemento;
    }

    public void setElemento(Repuesto elemento) {
        this.elemento = elemento;
    }

    public NodoDC getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(NodoDC siguiente) {
        this.siguiente = siguiente;
    }

    public NodoDC getAnterior() {
        return anterior;
    }

    public void setAnterior(NodoDC anterior) {
        this.anterior = anterior;
    }
}
