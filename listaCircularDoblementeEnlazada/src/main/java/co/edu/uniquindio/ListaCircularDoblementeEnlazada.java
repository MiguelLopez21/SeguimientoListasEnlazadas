package co.edu.uniquindio;

public class ListaCircularDoblementeEnlazada <T extends Comparable<T>> {
    private NodoGenerico<T> primero;
    private NodoGenerico<T> ultimo;
    int tam;

    public ListaCircularDoblementeEnlazada() {
        primero = null;
        ultimo = null;
        tam = 0;
    }

    public NodoGenerico<T> getPrimero() {
        return primero;
    }

    public void setPrimero(NodoGenerico<T> primero) {
        this.primero = primero;
    }

    public NodoGenerico<T> getUltimo() {
        return ultimo;
    }

    public void setUltimo(NodoGenerico<T> ultimo) {
        this.ultimo = ultimo;
    }

    public int getTam() {
        return tam;
    }

    public void setTam(int tam) {
        this.tam = tam;
    }

    public void mostrarConexiones() {
        if (primero == null) {
            System.out.println("La lista está vacía.");
            return;
        }

        System.out.println("Primero: " + primero.getDato());
        System.out.println("Ultimo: " + ultimo.getDato());

        // Mostrar conexiones del primero
        System.out.println("Primero -> Proximo: " + primero.getProximo().getDato());
        System.out.println("Primero -> Anterior: " + primero.getAnterior().getDato());

        // Mostrar conexiones del ultimo
        System.out.println("Ultimo -> Proximo: " + ultimo.getProximo().getDato());
        System.out.println("Ultimo -> Anterior: " + ultimo.getAnterior().getDato());
    }

    public void mostrar() {
        if (primero == null) {
            System.out.println("La lista está vacía.");
            return;
        }

        NodoGenerico<T> actual = primero;
        do {
            System.out.print(actual.getDato() + " ");
            actual = actual.getProximo();
        } while (actual != primero);
        System.out.println();
    }

    public void agregarPrimero(T dato){
        NodoGenerico<T> newNodo = new NodoGenerico<>(dato);

        if(primero == null) {
            primero = newNodo;
            ultimo = newNodo;
            primero.setProximo(primero);
            primero.setAnterior(ultimo);
        } else {
            newNodo.setProximo(primero);
            newNodo.setAnterior(ultimo);
            primero.setAnterior(newNodo);
            ultimo.setProximo(newNodo);
            primero = newNodo;
        }
        tam++;
    }

    public void agregarUltimo(T dato){
        NodoGenerico<T> newNodo = new NodoGenerico<>(dato);

        if(primero == null) {
            primero = newNodo;
            ultimo = newNodo;
            primero.setProximo(primero);
            primero.setAnterior(ultimo);
        } else {
            ultimo.setProximo(newNodo);
            newNodo.setAnterior(ultimo);
            newNodo.setProximo(primero);
            primero.setAnterior(newNodo);
            ultimo = newNodo;
        }
        tam++;
    }
}
