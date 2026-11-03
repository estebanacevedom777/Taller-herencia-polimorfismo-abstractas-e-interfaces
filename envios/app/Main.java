package envios.app;

import java.util.ArrayList;
import envios.modelo.*;

public class Main {
    public static void main(String[] args) {
        Moto m1 = new Moto("MZL12A", 20, 150);
        Camion c1 = new Camion("WFT345", 8000, 2);
        Moto m2 = new Moto("KJH78B", 25, 200);

        Flota flota = new Flota("Envíos Caldas");
        System.out.println(flota.agregar(m1));
        System.out.println(flota.agregar(c1));
        System.out.println(flota.agregar(m2));
        System.out.println(flota.agregar(m1));
        flota.mostrar();
        System.out.println(flota.cantidadCamiones());

        System.out.println(m1.costoEnvio(12));
        System.out.println(c1.costoEnvio(12));

        Bicicleta b1 = new Bicicleta("BIC001", 10);
        flota.agregar(b1);
        flota.mostrar();

        Vehiculo e8 = flota.masEconomico(8);
        Vehiculo e22 = flota.masEconomico(22);
        Vehiculo e500 = flota.masEconomico(500);
        System.out.println(e8 == null ? null : e8.getPlaca());
        System.out.println(e22 == null ? null : e22.getPlaca());
        System.out.println(e500 == null ? null : e500.getPlaca());
        Vehiculo e9000 = flota.masEconomico(9000);
        System.out.println(e9000 == null ? null : e9000.getPlaca());

        System.out.println(m1.valorSeguro());
        System.out.println(c1.valorSeguro());
        System.out.println(flota.totalSeguros());

        Bodega bodega = new Bodega("Bodega Chipre", 300);
        ArrayList<Asegurable> asegurables = new ArrayList<>();
        asegurables.add(c1);
        asegurables.add(bodega);

        double suma = 0;
        for (Asegurable asegurable : asegurables) {
            System.out.println(asegurable.valorSeguro());
            suma += asegurable.valorSeguro();
        }
        System.out.println(suma);

        // Reto 3: se conserva el tipo Vehiculo de la variable w.
        Vehiculo w = c1;
        if (w instanceof Camion) {
            System.out.println(((Camion) w).getEjes());
        }

        // Reto 4: sobrecarga de costoEnvio.
        System.out.println(c1.costoEnvio(10, true));
        System.out.println(c1.costoEnvio(10, false));

        // Reto 6: predicción del taller.
        Vehiculo v = new Moto("AAA11A", 20, 100);
        System.out.println(v.describir());
        System.out.println(v.costoEnvio(10));
        System.out.println(v instanceof Asegurable);
        System.out.println(v instanceof Camion);

        Asegurable a = new Bodega("Bodega Norte", 50);
        System.out.println(a.valorSeguro());
    }
}
