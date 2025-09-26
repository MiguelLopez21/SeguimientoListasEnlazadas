package co.edu.uniquindio;

public class Main {
    public static void main(String[] args) {
        ListaSimplementeEnlazadaCircular<Integer> lista = new ListaSimplementeEnlazadaCircular<>();

        NodoGenerico<Integer> nodo1 = new NodoGenerico<>(1);
        NodoGenerico<Integer> nodo2 = new NodoGenerico<>(2);
        NodoGenerico<Integer> nodo3 = new NodoGenerico<>(3);
        NodoGenerico<Integer> nodo4 = new NodoGenerico<>(4);
        NodoGenerico<Integer> nodo5 = new NodoGenerico<>(5);

        lista.agregarPrimero(nodo1.getDato());
        lista.agregarPrimero(nodo2.getDato());
        lista.agregarPrimero(nodo3.getDato());
        lista.agregarPrimero(nodo4.getDato());
        lista.agregarPrimero(nodo5.getDato());

        lista.agregarUltimo(nodo1.getDato());
        lista.agregarUltimo(nodo2.getDato());
        lista.agregarUltimo(nodo3.getDato());
        lista.agregarUltimo(nodo4.getDato());
        lista.agregarUltimo(nodo5.getDato());

        lista.mostrar();
    }
}
