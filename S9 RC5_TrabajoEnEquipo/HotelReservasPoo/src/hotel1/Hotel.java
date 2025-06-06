package hotel1;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Hotel {
    private String nombre;
    private List<Habitacion> habitaciones;
    private List<Reserva> reservas;
    private int siguienteIdReserva;

    // Constructor
    public Hotel(String nombre) {
        this.nombre = nombre;
        this.habitaciones = new ArrayList<>();
        this.reservas = new ArrayList<>();
        this.siguienteIdReserva = 1;
    }

    // Añade una nueva habitación
    public void agregarHabitacion(Habitacion habitacion) {
        habitaciones.add(habitacion);
        System.out.println("Habitación agregada: " + habitacion.getNumero());
    }

    // Consulta disponibilidad simple (solo revisa el booleano)
    public boolean consultarDisponibilidad(int numeroHabitacion) {
        for (Habitacion h : habitaciones) {
            if (h.getNumero() == numeroHabitacion) {
                return h.isDisponible();
            }
        }
        return false; // Si no existe, consideramos no disponible
    }

    // Crea una reserva si la habitación está disponible
    public boolean crearReserva(int numeroHabitacion, String cliente,
                                LocalDate fechaEntrada, LocalDate fechaSalida) {
        // 1. Buscar la habitación
        Habitacion habSeleccionada = null;
        for (Habitacion h : habitaciones) {
            if (h.getNumero() == numeroHabitacion) {
                habSeleccionada = h;
                break;
            }
        }

        if (habSeleccionada == null) {
            System.out.println("No existe la habitación #" + numeroHabitacion);
            return false;
        }

        // 2. Verificar disponibilidad
        if (!habSeleccionada.isDisponible()) {
            System.out.println("La habitación " + numeroHabitacion 
                               + " no está disponible en este momento.");
            return false;
        }

        // 3. Crear reserva y asignar ID
        Reserva nuevaReserva = new Reserva(siguienteIdReserva, habSeleccionada, cliente, fechaEntrada, fechaSalida);
        reservas.add(nuevaReserva);
        siguienteIdReserva++;

        // 4. Marcar la habitación como no disponible
        habSeleccionada.setDisponible(false);

        System.out.println("Reserva creada: " + nuevaReserva);
        return true;
    }

    // Muestra todas las habitaciones
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

    // Muestra todas las reservas
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
