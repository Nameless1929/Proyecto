package co.edu.uniquindio.poo;

public enum Tarifa {

    MOTO_HIBRIDA(1800.0),
    MOTO_CLASICA(2000.0),
    CARRO(3500.0);

    private double tarifa;

    private Tarifa(double tarifa) {
        this.tarifa = tarifa;
    }

    public double getTarifa() {
        return tarifa;
    }

    public void setTarifa(double tarifa) {
        if (tarifa > 0) {
            this.tarifa = tarifa;
        } else {
            throw new IllegalArgumentException("La tarifa debe ser mayor que cero.");
        }
    }
}
