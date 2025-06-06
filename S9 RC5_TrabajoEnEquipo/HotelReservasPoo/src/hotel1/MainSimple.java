package hotel1;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

/**
 * Menú de consola para la Solución 1 (Disponibilidad simple con booleano).
 */
public class MainSimple {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Hotel miHotel = new Hotel("Hotel Guayaquil (Simple)");
        DateTimeFormatter formato = DateTimeFormatter.ofPattern("yyyy-MM-dd");

        while (true) {
            System.out.println("\n=== MENÚ SOLUCIÓN 1 (DISPONIBILIDAD SIMPLE) ===");
            System.out.println("1. Agregar habitación");
            System.out.println("2. Crear reserva");
            System.out.println("3. Consultar disponibilidad");
            System.out.println("4. Listar todas las habitaciones");
            System.out.println("5. Listar todas las reservas");
            System.out.println("6. Salir");
            System.out.print("Selecciona una opción: ");
            int opcion = Integer.parseInt(sc.nextLine());

            switch (opcion) {
                case 1:
                    // Agregar habitación
                    System.out.print("Número de habitación: ");
                    int num1 = Integer.parseInt(sc.nextLine());
                    System.out.print("Tipo (Sencilla/Doble/Suite): ");
                    String tipo1 = sc.nextLine();
                    System.out.print("Precio por noche: ");
                    double precio1 = Double.parseDouble(sc.nextLine());
                    Habitacion h = new Habitacion(num1, tipo1, precio1);
                    miHotel.agregarHabitacion(h);
                    break;

                case 2:
                    // Crear reserva
                    System.out.print("Número de habitación a reservar: ");
                    int numR = Integer.parseInt(sc.nextLine());
                    System.out.print("Nombre del cliente: ");
                    String cliente = sc.nextLine();
                    System.out.print("Fecha de entrada (yyyy-MM-dd): ");
                    LocalDate fe1 = LocalDate.parse(sc.nextLine(), formato);
                    System.out.print("Fecha de salida (yyyy-MM-dd): ");
                    LocalDate fs1 = LocalDate.parse(sc.nextLine(), formato);

                    miHotel.crearReserva(numR, cliente, fe1, fs1);
                    break;

                case 3:
                    // Consultar disponibilidad
                    System.out.print("Número de habitación a consultar: ");
                    int numC = Integer.parseInt(sc.nextLine());
                    boolean disp = miHotel.consultarDisponibilidad(numC);
                    System.out.println("Habitación " + numC 
                        + (disp ? " está disponible." : " no está disponible."));
                    break;

                case 4:
                    miHotel.mostrarHabitaciones();
                    break;

                case 5:
                    miHotel.mostrarReservas();
                    break;

                case 6:
                    System.out.println("Saliendo de Solución 1...");
                    sc.close();
                    return;

                default:
                    System.out.println("Opción no válida. Intenta de nuevo.");
            }
        }
    }
}
