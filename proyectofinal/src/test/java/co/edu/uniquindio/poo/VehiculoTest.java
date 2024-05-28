package co.edu.uniquindio.poo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.logging.Logger;

import org.junit.jupiter.api.Test;


public class VehiculoTest {
    private static final Logger LOG = Logger.getLogger(VehiculoTest.class.getName());

    @Test
    public void datosCompletosMoto() {
        LOG.info("Iniciando test de datos completos de moto");

        var propietario = new Propietario("Juan", "Garcia", 20, "3147903249", "Juangarcia@gmail.com");
        var moto = new Moto("IUT45G", "XT 660 2024", propietario, 190, TipoMoto.CLASICA);

        assertEquals("IUT45G", moto.getPlaca());
        assertEquals("XT 660 2024", moto.getModelo());
        assertEquals(propietario, moto.getPropietario());
        assertEquals(190, moto.getVelocidadMaxima());
        assertEquals(TipoMoto.CLASICA, moto.getTipoMoto());

        LOG.info("Finalizando test de datos completos de moto");
    }

    @Test
    public void datosCompletosCarro() {
        LOG.info("Iniciando test de datos completos de carro");

        var propietario = new Propietario("Sebastian", "Rey", 20, "3218812558", "Sebasrey@gmail.com");

        var carro = new Carro("FOT339", "FRONTIER 2024", propietario);

        assertEquals("FOT339", carro.getPlaca());
        assertEquals("FRONTIER 2024", carro.getModelo());
        assertEquals(propietario, carro.getPropietario());

        LOG.info("Finalizando test de datos completos de carro");
    }

    @Test
    public void datosNulosMoto() {
        LOG.info("Iniciando test de datos nulos de moto");

        assertThrows(Throwable.class, () -> new Propietario(null, null, 0, null, null));
        assertThrows(Throwable.class, () -> new Moto(null, null, null, 0, null));

        LOG.info("Finalizando test de datos nulos de moto");
    }

    @Test
    public void datosNulosCarro() {
        LOG.info("Iniciando test de datos nulos de carro");

        assertThrows(Throwable.class, () -> new Propietario(null, null, 0, null, null));
        assertThrows(Throwable.class, () -> new Carro(null, null, null));

        LOG.info("Finalizando test de datos nulos de carro");
    }

    @Test
    public void datosNegativosMoto() {
        LOG.info("Iniciando test de datos negativos de moto");

        

        var propietario = new Propietario("Juan", "Garcia", 20, "3147903249", "Juangarcia@gmail.com");
         new Moto("IUT45G", "XT 660 2024", propietario, 190, TipoMoto.CLASICA);



        assertThrows(Throwable.class, () -> new Moto("IUT45G", "XT 660 2024", propietario, -190, TipoMoto.CLASICA));

        LOG.info("Finalizando test de datos negativos de moto");
    }

}
