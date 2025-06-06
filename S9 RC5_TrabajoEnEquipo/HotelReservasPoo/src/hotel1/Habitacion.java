package hotel1;

public class Habitacion {
    private int numero;
    private String tipo;          
    private double precioPorNoche;
    private boolean disponible;

    // Constructor
    public Habitacion(int numero, String tipo, double precioPorNoche) {
        this.numero = numero;
        this.tipo = tipo;
        this.precioPorNoche = precioPorNoche;
        this.disponible = true;   // Al crearla, está libre
    }

    // Getters y Setters
    public int getNumero() {
        return numero;
    }

    public String getTipo() {
        return tipo;
    }

    public double getPrecioPorNoche() {
        return precioPorNoche;
    }

    public boolean isDisponible() {
        return disponible;
    }

    public void setDisponible(boolean disponible) {
        this.disponible = disponible;
    }

    @Override
    public String toString() {
        return "Habitación " + numero 
             + " (" + tipo + "), Precio: $" + precioPorNoche 
             + ", Disponible: " + (disponible ? "Sí" : "No");
    }
}
