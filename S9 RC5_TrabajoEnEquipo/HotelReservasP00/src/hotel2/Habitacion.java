package hotel2;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Habitacion {
    private int numero;
    private String tipo;
    private double precioPorNoche;
    private List<Reserva> reservasAsignadas;

    public Habitacion(int numero, String tipo, double precioPorNoche) {
        this.numero = numero;
        this.tipo = tipo;
        this.precioPorNoche = precioPorNoche;
        this.reservasAsignadas = new ArrayList<>();
    }

    public int getNumero() {
        return numero;
    }

    public String getTipo() {
        return tipo;
    }

    public double getPrecioPorNoche() {
        return precioPorNoche;
    }

    /**
     * Verifica si la habitación está libre entre fEntrada y fSalida.
     * Recorre las reservas y comprueba solapamiento:
     *   No hay solapamiento si (fSalida < reserva.fechaEntrada) o (fEntrada > reserva.fechaSalida).
     */
    public boolean estaDisponible(LocalDate fEntrada, LocalDate fSalida) {
        for (Reserva r : reservasAsignadas) {
            if (!(fSalida.isBefore(r.getFechaEntrada()) || fEntrada.isAfter(r.getFechaSalida()))) {
                return false;
            }
        }
        return true;
    }

    /**
     * Asigna (agrega) la reserva a esta habitación.
     */
    public void asignarReserva(Reserva r) {
        reservasAsignadas.add(r);
    }

    @Override
    public String toString() {
        return "Habitación " + numero 
             + " (" + tipo + "), Precio: $" + precioPorNoche;
    }
}
