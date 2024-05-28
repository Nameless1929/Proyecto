package co.edu.uniquindio.poo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.logging.Logger;

import org.junit.jupiter.api.Test;


public class PropietarioTest {
    private static final Logger LOG = Logger.getLogger(PropietarioTest.class.getName());

    @Test
    public void datosCompletosPropietario(){
        LOG.info("Iniciando test de datos completos de propietario");

        var propietario = new Propietario("Sebastian", "Rey", 20, "3218812558", "Sebasrey@gmail.com");

        assertEquals("Sebastian", propietario.getNombres());
        assertEquals("Rey", propietario.getApellidos());
        assertEquals(20, propietario.getEdad());
        assertEquals("3218812558", propietario.getCelular());
        assertEquals("Sebasrey@gmail.com", propietario.getIdentificacion());

        LOG.info("Finalizando test de datos completos de propietario");
    }

    @Test
    public void datosNulosPropietario(){
        LOG.info("Iniciando test de datos nulos de propietario");

        assertThrows(Throwable.class, () -> new Propietario(null, null, 20, null, null));
        
        LOG.info("Finalizando test de datos nulos de propietario");
    }

    @Test
    public void datosVaciosPropietario(){
        LOG.info("Iniciando test de datos vacíos de propietario");

        assertThrows(Throwable.class, () -> new Propietario(" ", " ", 0, " ", " "));

        LOG.info("Finalizando test de datos vacíos de propietario");
    }

    @Test
    public void menorDeEdad(){
        LOG.info("Iniciando test de propietario menor de edad");

        assertThrows(Throwable.class, () -> new Propietario("Sebastian", "Rey", 17, "3218812558", "109588" ));

        LOG.info("Finalizando test de propietario menor de edad");

    }
}
