package co.edu.uniquindio;

public class Main {
    public static void main(String[] args) {
        Cola<String> cola = new Cola<>();
        cola.encolar("Hola");
        cola.encolar("Adios");
        System.out.println(cola.toString());

        Cola<String> cola2 = new Cola<>();
        cola2.encolar("Uno");
        cola2.encolar("Dos");
        cola2.desencolar();
        System.out.println(cola2.toString());
    }
}
