package co.edu.uniquindio.poo;

import static co.edu.uniquindio.poo.util.AssertionUtil.ASSERTION;

public class Puesto {
    private int posicionI;
    private int posicionJ;
    private Estado estado;
    private Vehiculo vehiculo;

    public Puesto(int posicionI, int posicionJ, Estado estado) {
        ASSERTION.assertion(estado != null, "Error: el estado no puede ser nulo");
        this.posicionI = posicionI;
        this.posicionJ = posicionJ;
        this.estado = estado;
        this.vehiculo = null;
    }

    
    public int getPosicionI() {
        return posicionI;
    }

    public void setPosicionI(int posicionI) {
        this.posicionI = posicionI;
    }

    public int getPosicionJ() {
        return posicionJ;
    }

    public void setPosicionJ(int posicionJ) {
        this.posicionJ = posicionJ;
    }

    public Estado getEstado() {
        return estado;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }

    public Vehiculo getVehiculo() {
        return vehiculo;
    }

    public void setVehiculo(Vehiculo vehiculo) {
        this.vehiculo = vehiculo;
    }
}

