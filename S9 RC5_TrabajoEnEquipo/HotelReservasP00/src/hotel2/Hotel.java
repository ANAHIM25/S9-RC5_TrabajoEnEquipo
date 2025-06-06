package hotel2;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Hotel {
    private String nombre;
    private List<Habitacion> habitaciones;
    private List<Reserva> reservas;
    private int siguienteIdReserva;

    public Hotel(String nombre) {
        this.nombre = nombre;
        this.habitaciones = new ArrayList<>();
        this.reservas = new ArrayList<>();
        this.siguienteIdReserva = 1;
    }

    // Añade una habitación al hotel
    public void agregarHabitacion(Habitacion h) {
        habitaciones.add(h);
        System.out.println("Habitación agregada: " + h.getNumero());
    }

    /**
     * Verifica disponibilidad consultando la lógica propia de Habitacion.
     */
    public boolean consultarDisponibilidad(int numeroHabitacion, 
                                           LocalDate fechaEntrada, LocalDate fechaSalida) {
        for (Habitacion h : habitaciones) {
            if (h.getNumero() == numeroHabitacion) {
                return h.estaDisponible(fechaEntrada, fechaSalida);
            }
        }
        return false; // No existe la habitación
    }

    /**
     * Crea reserva solo si la habitación está disponible en esas fechas.
     * Asigna la reserva tanto a la lista global como a la lista de la habitación.
     */
    public boolean crearReserva(int numeroHabitacion, String cliente,
                                LocalDate fechaEntrada, LocalDate fechaSalida) {
        Habitacion hab = null;
        for (Habitacion h : habitaciones) {
            if (h.getNumero() == numeroHabitacion) {
                hab = h;
                break;
            }
        }

        if (hab == null) {
            System.out.println("No existe la habitación #" + numeroHabitacion);
            return false;
        }

        if (!hab.estaDisponible(fechaEntrada, fechaSalida)) {
            System.out.println("La habitación " + numeroHabitacion 
                + " no está libre entre " + fechaEntrada + " y " + fechaSalida);
            return false;
        }

        Reserva r = new Reserva(siguienteIdReserva, hab, cliente, fechaEntrada, fechaSalida);
        reservas.add(r);
        hab.asignarReserva(r);
        siguienteIdReserva++;
        System.out.println("Reserva creada: " + r);
        return true;
    }

    // Muestra todas las habitaciones registradas
    public void mostrarHabitaciones() {
        System.out.println("\n----- Lista de Habitaciones -----");
        if (habitaciones.isEmpty()) {
            System.out.println("No hay habitaciones registradas.");
        } else {
            for (Habitacion h : habitaciones) {
                System.out.println(h);
            }
        }
    }

    // Muestra todas las reservas registradas
    public void mostrarReservas() {
        System.out.println("\n----- Lista de Reservas -----");
        if (reservas.isEmpty()) {
            System.out.println("No hay reservas registradas.");
        } else {
            for (Reserva r : reservas) {
                System.out.println(r);
            }
        }
    }
}
