package co.edu.uniquindio;

import java.util.Iterator;

public class ListaSimplementeEnlazadaCircular<T extends Comparable<T>> {
    private NodoGenerico<T> primero;
    private int tam;

    public ListaSimplementeEnlazadaCircular() {
        primero = null;
        tam = 0;
    }

    //Getters y setters
    public NodoGenerico<T> getPrimero() {
        return primero;
    }

    public void setPrimero(NodoGenerico<T> primero) {
        this.primero = primero;
    }

    public int getTam() {
        return tam;
    }

    public void setTam(int tam) {
        this.tam = tam;
    }

    @Override
    public String toString() {
        return "";
    }

    public void agregarPrimero(T dato) {
        NodoGenerico<T> newNodo = new NodoGenerico<>(dato);

        if (primero == null) {
            primero = newNodo;
            primero.setProximo(primero);
            tam++;
        }
        else {
            NodoGenerico<T> actual = primero;

            while(actual.getProximo() != primero) {
                actual = actual.getProximo();
            }
            newNodo.setProximo(primero);
            primero = newNodo;
            actual.setProximo(primero);
            tam++;
        }
    }

    public void agregarUltimo(T dato) {
        NodoGenerico<T> newNodo = new NodoGenerico<>(dato);

        if (primero == null) {
            primero = newNodo;
            primero.setProximo(primero);
            tam++;
        } else {
            NodoGenerico<T> actual = primero;

            while (actual.getProximo() != primero) {
                actual = actual.getProximo();
            }
            actual.setProximo(newNodo);
            newNodo.setProximo(primero);
            tam++;
        }
    }

    public void mostrar() {
        NodoGenerico<T> actual = primero;
        String mensaje = "[";

        //Usando do while
        do {
            mensaje += actual.getDato() + ",";

            actual = actual.getProximo();
        } while (actual != primero);

        mensaje += "]";
        System.out.println(mensaje);

        /***Usando while
         while(actual != null) {
         mensaje += actual.getDato() + ",";

         actual = actual.getProximo();
         }
         ***/
    }
}
