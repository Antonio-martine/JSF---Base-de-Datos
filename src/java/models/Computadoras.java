
package models;

public class Computadoras {
    private int idComputadora;
    private String tipo, marca, modelo, descripcion;
    private double costo;

    public Computadoras(int idComputadora, String tipo, String marca, String modelo, String descripcion, double costo) {
        this.idComputadora = idComputadora;
        this.tipo = tipo;
        this.marca = marca;
        this.modelo = modelo;
        this.descripcion = descripcion;
        this.costo = costo;
    }

    public Computadoras() {
    }

    public int getIdComputadora() {
        return idComputadora;
    }

    public void setIdComputadora(int idComputadora) {
        this.idComputadora = idComputadora;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

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

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public double getCosto() {
        return costo;
    }

    public void setCosto(double costo) {
        this.costo = costo;
    }
    
    
    
}
