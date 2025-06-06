package hotel1;

import java.time.LocalDate;

public class Reserva {
    private int idReserva;
    private Habitacion habitacion;
    private String nombreCliente;
    private LocalDate fechaEntrada;
    private LocalDate fechaSalida;

    // Constructor
    public Reserva(int idReserva, Habitacion habitacion, String nombreCliente,
                   LocalDate fechaEntrada, LocalDate fechaSalida) {
        this.idReserva = idReserva;
        this.habitacion = habitacion;
        this.nombreCliente = nombreCliente;
        this.fechaEntrada = fechaEntrada;
        this.fechaSalida = fechaSalida;
    }

    public int getIdReserva() {
        return idReserva;
    }

    public Habitacion getHabitacion() {
        return habitacion;
    }

    public String getNombreCliente() {
        return nombreCliente;
    }

    public LocalDate getFechaEntrada() {
        return fechaEntrada;
    }

    public LocalDate getFechaSalida() {
        return fechaSalida;
    }

    @Override
    public String toString() {
        return "Reserva #" + idReserva
             + " - Cliente: " + nombreCliente
             + ", Habitación: " + habitacion.getNumero()
             + ", Entrada: " + fechaEntrada
             + ", Salida: " + fechaSalida;
    }
}
