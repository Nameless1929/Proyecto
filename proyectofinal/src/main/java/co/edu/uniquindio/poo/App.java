package co.edu.uniquindio.poo;

public class App {
    public static void main(String[] args) {
        Parqueadero parqueadero = new Parqueadero("Mi Parqueadero", 5);

        System.out.println("Matriz de Puestos:");
        System.out.println(parqueadero.getPuestos());
    }
}
