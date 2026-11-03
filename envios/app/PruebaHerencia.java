package envios.app;

import envios.modelo.Moto;
import envios.modelo.Camion;

public class PruebaHerencia {
    public static void main(String[] args) {
        Moto m1 = new Moto("MZL12A", 20, 150);
        Camion c1 = new Camion("WFT345", 8000, 2);

        System.out.println(m1.describir());
        System.out.println(c1.describir());
        System.out.println(m1.getPlaca());
        System.out.println(c1.getEjes());
        System.out.println(m1 instanceof envios.modelo.Vehiculo);
    }
}
