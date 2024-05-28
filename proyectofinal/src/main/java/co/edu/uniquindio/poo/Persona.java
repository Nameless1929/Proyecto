package co.edu.uniquindio.poo;

import static co.edu.uniquindio.poo.util.AssertionUtil.ASSERTION;

abstract class Persona {
    private final String nombres;
    private final String apellidos;
    private final int edad;
    private final String celular;
    private final String identificacion;

    public Persona(String nombres, String apellidos, int edad, String celular, String identificacion) {
        ASSERTION.assertion(nombres != null && !nombres.isBlank(), "Error: el nombre no puede ser nulo ni estar vacío");
        ASSERTION.assertion(apellidos != null && !apellidos.isBlank(), "Error: el apellido no puede ser nulo ni estar vacío");
        ASSERTION.assertion(edad > 0, "Error: la edad debe ser mayor que cero");
        ASSERTION.assertion(celular != null && !celular.isBlank(), "Error: el celular no puede ser nulo ni estar vacío");
        ASSERTION.assertion(identificacion != null && !identificacion.isBlank(), "Error: la identificación no puede ser nula ni estar vacía");
        
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.edad = edad;
        this.celular = celular;
        this.identificacion = identificacion;
    }

    public String getNombres() {
        return nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public int getEdad() {
        return edad;
    }

    public String getCelular() {
        return celular;
    }

    public String getIdentificacion() {
        return identificacion;
    }
}
