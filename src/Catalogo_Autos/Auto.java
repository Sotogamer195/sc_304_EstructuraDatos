package Catalogo_Autos;

public class Auto {
    // Atributos
    private String marca;
    private String modelo;
    private int anio;
    private boolean activo;
    private int usuariosAsignados;

    // Constructor
    public Auto(String marca, String modelo, int anio) {
        this.marca = marca;
        this.modelo = modelo;
        this.anio = anio;
        this.activo = true;
        this.usuariosAsignados = 0;
    }

    // Getters y Setters
    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public int getAnio() {
        return anio;
    }

    public void setAnio(int anio) {
        this.anio = anio;
    }

    public boolean isActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }

    public int getUsuariosAsignados() {
        return usuariosAsignados;
    }

    public void setUsuariosAsignados(int usuariosAsignados) {
        this.usuariosAsignados = usuariosAsignados;
    }

    // Método ToString
    @Override
    public String toString() {
        return "Marca: " + marca + ", Modelo: " + modelo + ", Año: " + anio + ", Activo: " + activo;
    }
}
