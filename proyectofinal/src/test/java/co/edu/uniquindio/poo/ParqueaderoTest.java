package co.edu.uniquindio.poo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.YearMonth;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Logger;

import org.junit.jupiter.api.Test;


public class ParqueaderoTest {
    private static final Logger LOG = Logger.getLogger(ParqueaderoTest.class.getName());

    @Test
    public void datosCompletosParqueadero() {
        LOG.info("Iniciando test de datos completos del parqueadero");

        Parqueadero parqueadero = new Parqueadero("Parkeando", 20);

        assertEquals("Parkeando", parqueadero.getNombre());
        assertEquals(20, parqueadero.getPuestos());

        LOG.info("Finalizando test de datos completos del parqueadero");
    }

    @Test
    public void addVehiculosDiferentes() {
        LOG.info("Iniciando test de añadir vehiculos diferentes al parqueadero");

        Parqueadero parqueadero = new Parqueadero("Parkeando", 20);

        Propietario propietario1 = new Propietario("Juan", "García", 19, "3137467474", "1091884361");
        Propietario propietario2 = new Propietario("Pedro", "Hernandez", 20, "311356792", "1089472112");
        Propietario propietario3 = new Propietario("Sofia", "Londoño", 19, "312745632", "1091885627");

        Carro carro = new Carro("MWY759", "F-150® Raptor", propietario1);
        Moto motoClasica = new Moto("BTC14F", "XTZ150", propietario2, 200, TipoMoto.CLASICA);
        Moto motoHibrida = new Moto("KGB45C", "BWS FI", propietario3, 150, TipoMoto.HIBRIDA);

        assertEquals(true, parqueadero.verificarPuestoDisponible(1, 1));
        parqueadero.addVehiculoPuestoDado(carro, 1, 1);
        assertEquals(false, parqueadero.verificarPuestoDisponible(1, 1));
        assertEquals(true, parqueadero.verificarPuestoDisponible(2, 2));
        parqueadero.addVehiculoPuestoDado(motoClasica, 2, 2);
        assertEquals(false, parqueadero.verificarPuestoDisponible(2, 2));
        assertEquals(true, parqueadero.verificarPuestoDisponible(3, 3));
        parqueadero.addVehiculoPuestoDado(motoHibrida, 3, 3);
        assertEquals(false, parqueadero.verificarPuestoDisponible(3, 3));

        LOG.info("Finalizando test de añadir vehiculos diferentes al parqueadero");
    }

    @Test
    public void addVehiculosIguales() {
        LOG.info("Iniciando test de añadir vehiculos iguales al parqueadero");

        Parqueadero parqueadero = new Parqueadero("Parkeando", 20);

        Propietario propietario1 = new Propietario("Juan", "García", 19, "3137467474", "1091884361");
        Propietario propietario2 = new Propietario("Pedro", "Hernandez", 20, "311356792", "1089472112");
        Propietario propietario3 = new Propietario("Sofia", "Londoño", 19, "312745632", "1091885627");

        Carro carro = new Carro("MWY759", "F-150® Raptor", propietario1);
        Moto motoClasica = new Moto("BTC14F", "XTZ150", propietario2, 200, TipoMoto.CLASICA);
        Moto motoHibrida = new Moto("KGB45C", "BWS FI", propietario3, 150, TipoMoto.HIBRIDA);
        
        parqueadero.addVehiculoPuestoDado(carro, 3, 1);
        parqueadero.addVehiculoPuestoDado(motoClasica, 2, 2);

        assertEquals(false, parqueadero.verificarPuestoDisponible(3, 1));
        assertEquals(false, parqueadero.verificarPuestoDisponible(2, 2));

        assertThrows(IllegalArgumentException.class, () -> parqueadero.addVehiculoPuestoDado(motoClasica2, 2, 2));

        LOG.info("Finalizando test de añadir vehiculos iguales al parqueadero");
    }

    @Test
    public void crearPuestos() {
        LOG.info("Iniciando test de crear puestos del parqueadero");

        Parqueadero parqueadero = new Parqueadero("Parkeando", 5);

        assertEquals(25, parqueadero.getPuestos().size());

        LOG.info("Finalizando test de crear puestos del parqueadero");
    }

    @Test
    public void generarReporteParqueaderoSinVehiculos() {
        LOG.info("Iniciando test de generar reporte del parqueadero sin vehículos");

        Parqueadero parqueadero = new Parqueadero("parkeando", 5);

        LocalDate fecha = LocalDate.now();
        YearMonth mes = YearMonth.now();

        List<Double> reporteDiarioEsperado = List.of(0.0, 0.0, 0.0);

    }

}
