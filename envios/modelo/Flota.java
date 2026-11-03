package envios.modelo;

import java.util.ArrayList;

public class Flota {
    private String nombre;
    private ArrayList<Vehiculo> vehiculos;

    public Flota(String nombre) {
        this.nombre = nombre;
        this.vehiculos = new ArrayList<>();
    }

    public boolean agregar(Vehiculo vehiculo) {
        if (vehiculo == null || vehiculos.contains(vehiculo)) {
            return false;
        }
        vehiculos.add(vehiculo);
        return true;
    }

    public void mostrar() {
        System.out.println(nombre + ":");
        for (Vehiculo vehiculo : vehiculos) {
            System.out.println("- " + vehiculo.describir());
        }
    }

    public int cantidadCamiones() {
        int cantidad = 0;
        for (Vehiculo vehiculo : vehiculos) {
            if (vehiculo instanceof Camion) {
                cantidad++;
            }
        }
        return cantidad;
    }

    public Vehiculo masEconomico(int pesoKg) {
        Vehiculo economico = null;
        for (Vehiculo vehiculo : vehiculos) {
            if (vehiculo.getCapacidadKg() >= pesoKg) {
                if (economico == null
                        || vehiculo.tarifaPorKm() < economico.tarifaPorKm()) {
                    economico = vehiculo;
                }
            }
        }
        return economico;
    }

    public double totalSeguros() {
        double total = 0;
        for (Vehiculo vehiculo : vehiculos) {
            if (vehiculo instanceof Asegurable) {
                total += ((Asegurable) vehiculo).valorSeguro();
            }
        }
        return total;
    }
}
