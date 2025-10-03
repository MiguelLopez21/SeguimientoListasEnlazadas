package co.edu.uniquindio;

public class Main {
    public static void main(String[] args) {
        ListaCircularDoblementeEnlazada<String> lista = new ListaCircularDoblementeEnlazada<>();
        lista.agregarPrimero("Adios");
        lista.agregarPrimero("como estas");
        lista.agregarPrimero("Hola");
        lista.mostrarConexiones();
        lista.mostrar();

        ListaCircularDoblementeEnlazada<String> lista2 = new ListaCircularDoblementeEnlazada<>();
        lista2.agregarUltimo("Uno");
        lista2.agregarUltimo("Dos");
        lista2.agregarUltimo("Tres");
        lista2.mostrarConexiones();
        lista2.mostrar();
    }
}
