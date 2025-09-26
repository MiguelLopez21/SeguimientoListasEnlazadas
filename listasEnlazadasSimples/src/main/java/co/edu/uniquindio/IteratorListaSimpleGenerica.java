package co.edu.uniquindio;

import java.util.Iterator;

public class IteratorListaSimpleGenerica<T extends Comparable<T>> implements Iterator<T> {
    private ListaSimpleEnlazadaGenerica<T> listaSimpleEnlazadaGenerica;
    private NodoGenerico<T> actual;

    public IteratorListaSimpleGenerica(ListaSimpleEnlazadaGenerica listaSimpleEnlazadaGenerica) {
        this.actual = listaSimpleEnlazadaGenerica.getPrimero();

    }

    @Override
    public boolean hasNext() {
        return  actual != null;
    }

    @Override
    public T next() {
        T dato = actual.getDato();
        actual = actual.getProximo();
        return dato;
    }
}
