package co.edu.uniquindio.poo;

public abstract class Vehiculo {
    private String placa;
    private String modelo;
    private Propietario propietario;

    public Vehiculo(String placa, String modelo, Propietario propietario) {
        this.placa = placa;
        this.modelo = modelo;
        this.propietario = propietario;
    }

    public String getPlaca() {
        return placa;
    }

    public String getModelo() {
        return modelo;
    }

    public Propietario getPropietario() {
        return propietario;
    }

    public abstract double getTarifa();
    public abstract void setTarifa(double tarifa);
}
