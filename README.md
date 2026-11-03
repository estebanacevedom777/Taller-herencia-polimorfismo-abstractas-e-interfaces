# Taller-herencia-polimorfismo-abstractas-e-interfaces

Parte B. Retos: errores y explicaciones
1. Intentar crear un objeto de Vehiculo
Código:
new Vehiculo("XYZ999", 50);
Error esperado:
Vehiculo is abstract; cannot be instantiated
Explicación: El error ocurre porque Vehiculo es una clase abstracta y no se pueden crear objetos directamente de ella. Esta clase sirve como base para otras clases, como Moto, Camion y Bicicleta.

2. Quitar temporalmente tarifaPorKm() de Bicicleta

Error esperado: el compilador indica que Bicicleta no implementa el método abstracto tarifaPorKm() de Vehiculo.
Explicación: Como Bicicleta hereda de una clase abstracta, debe implementar todos sus métodos abstractos para poder funcionar como una clase concreta. Por eso se debe volver a agregar el método.

3. Utilizar getEjes() desde una variable Vehiculo
Código que produce el error:
Vehiculo w = c1;
System.out.println(w.getEjes());
Error esperado:
cannot find symbol: method getEjes()
Explicación: El error ocurre porque la variable w es de tipo Vehiculo, y esa clase no tiene el método getEjes(). Aunque el objeto real sea un camión, Java revisa primero el tipo de la variable.
Corrección:
Vehiculo w = c1;
if (w instanceof Camion) {
    System.out.println(((Camion) w).getEjes());
}
El resultado es:
2

4. Sobrecarga del método costoEnvio()

Se agrega el siguiente método a Vehiculo:
public double costoEnvio(double km, boolean urgente) {
    double costo = km * tarifaPorKm();

    if (urgente) {
        costo *= 1.5;
    }    return costo;
}

Resultados:
c1.costoEnvio(10, true) = 75000.0
c1.costoEnvio(10, false) = 50000.0
Explicación: Es una sobrecarga porque se utiliza el mismo nombre del método, pero con diferentes parámetros. Cuando el envío es urgente, el costo aumenta un 50 %.

5. Cambiar describir() por describr() en Bicicleta
¿Qué cambió en la salida?
Al cambiar el nombre del método a describr(), la bicicleta deja de mostrar el texto adicional , bicicleta eléctrica. En su lugar, utiliza el método describir() heredado de Vehiculo.
¿Por qué compiló?
Porque al quitar @Override, Java interpreta describr() como un método nuevo y no como una sobrescritura.
¿Qué habría pasado si se conserva @Override?
El compilador mostraría un error porque describr() no sobrescribe ningún método de la clase padre.
La solución es dejar el nombre correcto describir() y conservar @Override.
6. Predicción de salida
Código:
Vehiculo v = new Moto("AAA11A", 20, 100);
System.out.println(v.describir());
System.out.println(v.costoEnvio(10));
System.out.println(v instanceof Asegurable);
System.out.println(v instanceof Camion);
Asegurable a = new Bodega("Bodega Norte", 50);
System.out.println(a.valorSeguro());

Resultado:
AAA11A (20 kg), moto de 100 cc
12000.0
true
false
100000.0

Explicación: La variable v es de tipo Vehiculo, pero contiene un objeto Moto. Por eso ejecuta los métodos correspondientes a la moto. Además, la moto implementa Asegurable, pero no es un camión. La bodega calcula su seguro multiplicando 50 metros por 2.000.
documentacion_taller.md

Parte C. Preguntas
1. ¿Por qué Bicicleta funcionó en mostrar() y en masEconomico() sin cambiar una sola línea de Flota?
Porque Bicicleta hereda de Vehiculo y puede utilizarse donde se espera un objeto de tipo Vehiculo. Gracias al polimorfismo, cada vehículo ejecuta su propio método describir() y su propia tarifa por kilómetro.

2. ¿Por qué Vehiculo es abstracta y Moto no? ¿Qué pasaría si Moto también lo fuera?
Vehiculo es abstracta porque representa una idea general de vehículo y tiene un método abstracto llamado tarifaPorKm(). Moto no es abstracta porque implementa ese método y puede crear objetos.

3. ¿Por qué Bodega implementa Asegurable pero no hereda de Vehiculo?
Porque una bodega no es un vehículo, pero sí necesita calcular un seguro. Por eso implementa la interfaz Asegurable, que establece el método valorSeguro() sin obligarla a heredar de Vehiculo.

4. ¿Qué diferencia hay entre super(placa, capacidadKg) y super.describir()?
super(placa, capacidadKg) llama al constructor de la clase padre para inicializar sus atributos.
super.describir() llama al método describir() de la clase padre para reutilizar su funcionamiento dentro de la clase hija.

5. Cierre del curso: explica con tus palabras qué es la POO y señala en tu código del taller un ejemplo de cada pilar.
La Programación Orientada a Objetos es una forma de desarrollar programas utilizando clases y objetos que representan elementos de la vida real. Cada objeto tiene atributos y métodos que permiten organizar mejor el código y reutilizarlo.



Los cuatro pilares son:
- Abstracción: se encuentra en la clase Vehiculo, porque representa las características generales de un vehículo sin definir todos sus comportamientos.
- Encapsulamiento: se utiliza cuando los atributos de las clases son private, evitando que puedan modificarse directamente desde cualquier parte del programa.
- Herencia: aparece cuando las clases Moto, Camion y Bicicleta utilizan extends Vehiculo para heredar sus características.
- Polimorfismo: se demuestra cuando la clase Flota guarda diferentes tipos de vehículos en una misma lista de tipo Vehiculo y cada uno responde de manera diferente a sus métodos.

- <img width="1082" height="666" alt="Diagrama_UML_Enviostaller drawio" src="https://github.com/user-attachments/assets/98c04ee9-0268-4d13-b97a-3818c372d535" />
