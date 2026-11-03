package envios.modelo;

public abstract class Vehiculo {
    private String placa;
    private int capacidadKg;

    public Vehiculo(String placa, int capacidadKg) {
        this.placa = placa;
        this.capacidadKg = capacidadKg;
    }

    public String getPlaca() {
        return placa;
    }

    public int getCapacidadKg() {
        return capacidadKg;
    }

    public String describir() {
        return placa + " (" + capacidadKg + " kg)";
    }

    public abstract double tarifaPorKm();

    public double costoEnvio(double km) {
        return km * tarifaPorKm();
    }

    // Sobrecarga: mismo nombre, diferentes parámetros.
    public double costoEnvio(double km, boolean urgente) {
        double costo = costoEnvio(km);
        return urgente ? costo * 1.5 : costo;
    }
}
