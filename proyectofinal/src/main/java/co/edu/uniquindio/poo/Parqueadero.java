
package co.edu.uniquindio.poo;

import static co.edu.uniquindio.poo.util.AssertionUtil.ASSERTION;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Collection;
import java.util.Hashtable;
import java.util.LinkedList;
import java.util.List;
import java.util.function.Predicate;

public class Parqueadero {
    private final String nombre;
    private int numeroPuestos;
    private final Collection<Registro> registros;
    private final Hashtable<String, Puesto> puestos;
    private final Collection<Vehiculo> vehiculos;

    public Parqueadero(String nombre, int numeroPuestos) {
        ASSERTION.assertion(nombre != null && !nombre.isBlank(), "Error: el nombre no puede ser nulo ni estar vacío");
        ASSERTION.assertion(numeroPuestos > 0, "Error: el numero de puestos debe ser mayor de cero puestos");
        this.nombre = nombre;
        this.numeroPuestos = numeroPuestos;
        registros = new LinkedList<>();
        puestos = new Hashtable<>();
        vehiculos = new LinkedList<>();
        crearPuestos(numeroPuestos);
    }

    public void crearPuestos(int numeroPuestos) {
        for (int i = 0; i < numeroPuestos; i++) {
            int posicionI = (i + 1);
            for (int j = 0; j < numeroPuestos; j++) {
                int posicionJ = (j + 1);
                String k = "(" + posicionI + ", " + posicionJ + ")";
                puestos.put(k, new Puesto(posicionI, posicionJ, Estado.LIBRE));
            }
        }
    }

    public void addVehiculoPuestoDado(Vehiculo vehiculo, int posicionI, int posicionJ) {
        ASSERTION.assertion(verificarPuestoDisponible(posicionI, posicionJ),
                "Error: el puesto se encuentra ocupado");
        if (verificarPuestoDisponible(posicionI, posicionJ)) {
            var puesto = puestos.get("(" + posicionI + ", " + posicionJ + ")");
            puesto.setVehiculo(vehiculo);
            actualizarEstadoPuesto(posicionI, posicionJ, Estado.OCUPADO);
            LocalDateTime fechaEntrada = LocalDateTime.now();
            Registro nuevoRegistro = new Registro(fechaEntrada, null, vehiculo);
            registros.add(nuevoRegistro);
            addVehiculo(vehiculo);
        }
    }

    public void removeVehiculoPuestoDado(int posicionI, int posicionJ, LocalDateTime fechaSalida) {
        ASSERTION.assertion(!verificarPuestoDisponible(posicionI, posicionJ),
                "Error: el puesto se encuentra libre");
        if (!verificarPuestoDisponible(posicionI, posicionJ)) {
            var puesto = puestos.get("(" + posicionI + ", " + posicionJ + ")");
            var obtenerVehiculo = puesto.getVehiculo();
            for (Registro registro : registros) {
                if (registro.getVehiculo().equals(obtenerVehiculo) && registro.getFechaSalida() == null) {
                    registro.setFechaSalida(fechaSalida);
                }
            }
            puesto.setVehiculo(null);
            actualizarEstadoPuesto(posicionI, posicionJ, Estado.LIBRE);
        }
    }

    public boolean verificarPuestoDisponible(int i, int j) {
        var puesto = puestos.get("(" + i + ", " + j + ")");
        return puesto != null && puesto.getEstado().equals(Estado.LIBRE);
    }

    private void actualizarEstadoPuesto(int posicionI, int posicionJ, Estado estadoNuevo) {
        var puesto = puestos.get("(" + posicionI + ", " + posicionJ + ")");
        puesto.setEstado(estadoNuevo);
    }

    public Propietario identificarPropietarioPuestoDado(int posicionI, int posicionJ) {
        var puesto = puestos.get("(" + posicionI + ", " + posicionJ + ")");
        if (puesto != null && puesto.getEstado().equals(Estado.OCUPADO)) {
            var vehiculo = puesto.getVehiculo();
            return vehiculo.getPropietario();
        }
        return null;
    }

    public void addVehiculo(Vehiculo vehiculo) {
        ASSERTION.assertion(!verificarVehiculo(vehiculo.getPlaca()), "Error: el vehiculo ya se encuentra registrado");
        vehiculos.add(vehiculo);
    }

    private boolean verificarVehiculo(String placa) {
        Predicate<Vehiculo> placaIgual = vehiculo -> vehiculo.getPlaca().equals(placa);
        return vehiculos.stream().anyMatch(placaIgual);
    }

    public Collection<Double> generarReporteDiario(LocalDate fecha) {
        double dineroRecaudadoCarro = 0.0;
        double dineroRecaudadoMotoHibrida = 0.0;
        double dineroRecaudadoMotoClasica = 0.0;

        for (Registro registro : registros) {
            if (registro.getFechaEntrada().toLocalDate().isEqual(fecha) && registro.getFechaSalida() != null) {
                var vehiculo = registro.getVehiculo();
                double tarifa = registro.calcularTarifa();

                if (vehiculo instanceof Carro) {
                    dineroRecaudadoCarro += tarifa;
                } else if (vehiculo instanceof Moto moto) {
                    if (moto.getTipoMoto() == TipoMoto.CLASICA) {
                        dineroRecaudadoMotoClasica += tarifa;
                    } else {
                        dineroRecaudadoMotoHibrida += tarifa;
                    }
                }
            }
        }

        return List.of(dineroRecaudadoCarro, dineroRecaudadoMotoClasica, dineroRecaudadoMotoHibrida);
    }

    public Hashtable<String, Puesto> getPuestos() {
        return new Hashtable<>(puestos);
    }
}
