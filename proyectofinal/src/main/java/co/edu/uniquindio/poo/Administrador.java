package co.edu.uniquindio.poo;

public class Administrador extends Persona {

    public Administrador(String nombres, String apellidos, int edad, String celular, String identificacion) {
        super(nombres, apellidos, edad, celular, identificacion);
    }

    public void cambiarTarifa(Vehiculo vehiculo, double nuevoValorTarifa) {
        vehiculo.setTarifa(nuevoValorTarifa);
    }
}
