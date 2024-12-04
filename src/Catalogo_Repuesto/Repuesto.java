package Catalogo_Repuesto;

public class Repuesto {
    // Atributos de la clase Repuesto
    private String nombreRepuesto;
    private String codigo;

    // Constructor de la clase
    public Repuesto() {
        this.nombreRepuesto = "";
        this.codigo = "";
    }

    // Métodos getter y setter
    public String getNombreRepuesto() {
        return nombreRepuesto;
    }

    public void setNombreRepuesto(String nombreRepuesto) {
        this.nombreRepuesto = nombreRepuesto;
    }

    public String getCodigo() {
        return codigo;
    }
    
    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }
}
