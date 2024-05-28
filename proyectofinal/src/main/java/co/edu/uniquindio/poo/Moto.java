package co.edu.uniquindio.poo;

import static co.edu.uniquindio.poo.util.AssertionUtil.ASSERTION;

public class Moto extends Vehiculo {
    private final double velocidadMaxima;
    private final TipoMoto tipoMoto;
    private static double tarifaClasica = Tarifa.MOTO_CLASICA.getTarifa();
    private static double tarifaHibrida = Tarifa.MOTO_HIBRIDA.getTarifa();

    public Moto(String placa, String modelo, Propietario propietario, double velocidadMaxima, TipoMoto tipoMoto) {
        super(placa, modelo, propietario);

        ASSERTION.assertion(velocidadMaxima > 0, "Error: la velocidad máxima no puede ser negativa");
        ASSERTION.assertion(tipoMoto != null, "Error: el tipo de moto no puede ser nulo");

        this.velocidadMaxima = velocidadMaxima;
        this.tipoMoto = tipoMoto;
    }

    public double getVelocidadMaxima() {
        return velocidadMaxima;
    }

    public TipoMoto getTipoMoto() {
        return tipoMoto;
    }

    @Override
    public double getTarifa() {
        if (tipoMoto == TipoMoto.CLASICA) {
            return tarifaClasica;
        } else {
            return tarifaHibrida;
        }
    }

    @Override
    public void setTarifa(double tarifa) {
        ASSERTION.assertion(tarifa > 0.0, "Error: la tarifa debe ser mayor que cero");
        if (tipoMoto == TipoMoto.CLASICA) {
            Moto.tarifaClasica = tarifa;
            Tarifa.MOTO_CLASICA.setTarifa(tarifa);
        } else {
            Moto.tarifaHibrida = tarifa;
            Tarifa.MOTO_HIBRIDA.setTarifa(tarifa);
        }
    }
}
