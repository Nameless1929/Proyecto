package co.edu.uniquindio.poo;

import static co.edu.uniquindio.poo.util.AssertionUtil.ASSERTION;

public class Carro extends Vehiculo {
    private static double tarifa = Tarifa.CARRO.getTarifa();

    public Carro(final String placa, final String modelo, final Propietario propietario) {
        super(placa, modelo, propietario);
    }

    @Override
    public double getTarifa() {
        return tarifa;
    }

    @Override
    public void setTarifa(double nuevaTarifa) {
        ASSERTION.assertion(nuevaTarifa > 0.0, "Error: la tarifa debe ser mayor que cero");
        tarifa = nuevaTarifa;
        Tarifa.CARRO.setTarifa(nuevaTarifa);
    }
}

