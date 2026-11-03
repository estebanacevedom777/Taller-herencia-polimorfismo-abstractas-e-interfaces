package envios.modelo;

public class Bodega implements Asegurable {
    private String nombre;
    private int metros;

    public Bodega(String nombre, int metros) {
        this.nombre = nombre;
        this.metros = metros;
    }

    public String getNombre() {
        return nombre;
    }

    public int getMetros() {
        return metros;
    }

    @Override
    public double valorSeguro() {
        return metros * 2000;
    }
}
