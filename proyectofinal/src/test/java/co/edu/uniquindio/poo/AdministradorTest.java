package co.edu.uniquindio.poo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.logging.Logger;

import org.junit.jupiter.api.Test;



public class AdministradorTest {
    private static final Logger LOG = Logger.getLogger(AdministradorTest.class.getName());
    
    @Test
    public void tarifaPositiva(){

        LOG.info("Iniciado test tarifaPositiva");

        var administrador = new Administrador("Sebastian", "Rey", 53, "3113897733", "1094566355");

        Propietario propietario1 = new Propietario("Juan", "García", 19, "3137467474", "1091884361");
        Propietario propietario2 = new Propietario("Pedro", "Hernandez", 20, "311356792", "1089472112");
        Propietario propietario3 = new Propietario("Sofia", "Londoño", 19, "312745632", "1091885627");
        var propietario4 = new Propietario("Daniel", "Bedoya", 20, "3743878444", "1098336251");

        Carro carro = new Carro("MWY759", "F-150® Raptor", propietario1);
        Moto motoClasica = new Moto("BTC14F", "XTZ150", propietario2, 200, TipoMoto.CLASICA);
        Moto motoHibrida = new Moto("KGB45C", "BWS FI", propietario3, 150, TipoMoto.HIBRIDA);
        var motoClasica2 = new Moto("37437sh", "modelo", propietario4, 300, TipoMoto.CLASICA);

        administrador.cambiarTarifa(carro, 3500.0);
        administrador.cambiarTarifa(motoClasica, 2000.0);
        administrador.cambiarTarifa(motoHibrida, 2800.0);

        assertEquals(2000.0, motoClasica2.getTarifa());
        assertEquals(3500.0, carro.getTarifa());
        assertEquals(2000.0, motoClasica.getTarifa());
        assertEquals(2800.0, motoHibrida.getTarifa());

        LOG.info("Finalizando test tarifaPositiva");

    }

    @Test
    public void tarifaNegativa(){

        LOG.info("Iniciado test tarifaNegativa");

        var administrador = new Administrador("Daniel", "Jaramillo", 45, "27327832829", "1098336251");


        Propietario propietario1 = new Propietario("Juan", "García", 19, "3137467474", "1091884361");
        Propietario propietario2 = new Propietario("Pedro", "Hernandez", 20, "311356792", "1089472112");
        Propietario propietario3 = new Propietario("Sofia", "Londoño", 19, "312745632", "1091885627");

        Carro carro = new Carro("MWY759", "F-150® Raptor", propietario1);
        Moto motoClasica = new Moto("BTC14F", "XTZ150", propietario2, 200, TipoMoto.CLASICA);
        Moto motoHibrida = new Moto("KGB45C", "BWS FI", propietario3, 150, TipoMoto.HIBRIDA);
        
        assertThrows(Throwable.class, () -> administrador.cambiarTarifa(carro, -4500.0));
        assertThrows(Throwable.class, () -> administrador.cambiarTarifa(motoClasica, -1000.0));
        assertThrows(Throwable.class, () -> administrador.cambiarTarifa(motoHibrida, -3800.0));

        LOG.info("Finalizando test tarifaNegativa");

    }
}