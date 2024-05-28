package co.edu.uniquindio.poo;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.logging.Logger;

import org.junit.jupiter.api.Test;


public class TarifaTest {
    private static final Logger LOG = Logger.getLogger(TarifaTest.class.getName());

    @Test
    public void obtenerValorTarifa(){
        LOG.info("Iniciando test de obtener el valor de la tarifa");

        var tarifaCarro = Tarifa.CARRO;
        var tarifaMotoClasica = Tarifa.MOTO_CLASICA;
        var tarifaMotoHibrida = Tarifa.MOTO_HIBRIDA;

        assertEquals(4000.0, tarifaCarro.getTarifa());
        assertEquals(2500.0, tarifaMotoClasica.getTarifa());
        assertEquals(2000.0, tarifaMotoHibrida.getTarifa());

        LOG.info("Finalizando test de obtener el valor de la tarifa");
    }

    @Test
    public void cambiarValorTarifa(){
        LOG.info("Iniciando test de cambiar el valor de la tarifa");

        var tarifaCarro = Tarifa.CARRO;
        var tarifaMotoClasica = Tarifa.MOTO_CLASICA;
        var tarifaMotoHibrida = Tarifa.MOTO_HIBRIDA;

        tarifaCarro.setTarifa(6000.0);
        tarifaMotoClasica.setTarifa(4500.0);
        tarifaMotoHibrida.setTarifa(4000.0);

        assertEquals(6000.0, tarifaCarro.getTarifa());
        assertEquals(4500.0, tarifaMotoClasica.getTarifa());
        assertEquals(4000.0, tarifaMotoHibrida.getTarifa());
        
        LOG.info("Finalizando test de cambiar el valor de la tarifa");
    }
}
