package co.edu.uniquindio;

import java.util.Iterator;

public class ListaSimpleEnlazadaGenerica<T extends Comparable<T>> implements Iterable<T>{
    private NodoGenerico<T> primero;
    private int tam;

    public ListaSimpleEnlazadaGenerica() {
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

        if(primero == null) {
            primero = newNodo;
            tam++;
        }
        else {
            newNodo.setProximo(primero);
            primero = newNodo;
            tam++;
        }
    }

    public void agregarUltimo(T dato) {
        NodoGenerico<T> newNodo = new NodoGenerico<>(dato);

        if(primero == null) {
            primero = newNodo;
            tam++;
        }
        else {
            NodoGenerico<T> actual = primero;
            while(actual.getProximo() != null) {
                actual = actual.getProximo();
            }
            actual.setProximo(newNodo);
            tam++;
        }
    }

    public void agregarPosicionEspecifica(T dato, int index) {
        NodoGenerico<T> newNodo = new NodoGenerico<>(dato);

        if(index == 0) {
            newNodo.setProximo(primero);
            primero = newNodo;
        }
        else if(index > tam) {
            System.out.println("Fuera de los límites del tamaño la lista");
        }
        else{
            NodoGenerico<T> actual = primero;
            int acc = 0;

            while(acc < index - 1) {
                actual = actual.getProximo();
                acc++;
            }
            newNodo.setProximo(actual.getProximo());
            actual.setProximo(newNodo);

            /*** Método con el for
             for(int i = 0; i < index - 1; i++) {
             actual = actual.getProximo();
             }
             ***/
        }
        tam++;
    }

    public boolean esVacia() {
        return (primero == null || tam == 0) ? true: false;

        /***
         if(primero == null || tam == 0) {
         return true;
         }
         else {
         return false;
         }
         ***/
    }

    public int localizar(T datoBusqueda) {
        NodoGenerico<T> actual = primero;
        int indexBusqueda = 0;

        while(actual != null) {
            if(actual.getDato().equals(datoBusqueda)) {
                return indexBusqueda;
            }
            indexBusqueda++;
            actual = actual.getProximo();
        }

        return -1;
    }

    public boolean buscar(T datoBusqueda) {
        NodoGenerico<T> actual = primero;
        boolean flag = false;

        while(actual != null) {
            if(actual.getDato().equals(datoBusqueda)) {
                flag = true;
            }
            actual = actual.getProximo();
        }
        return flag;
    }

    public boolean eliminar(T datoBusqueda) {
        NodoGenerico<T> actual = primero;

        if(actual.getDato().equals(datoBusqueda)) {
            primero = actual.getProximo();
            tam--;
            return true;
        }
        else {

            while(actual.getProximo() != null) {
                if(actual.getProximo().getDato().equals(datoBusqueda)) {
                    actual.setProximo(actual.getProximo().getProximo());
                    tam--;
                    return true;
                }
                actual = actual.getProximo();
            }
        }
        return false;
    }

    public void insercionNatural(T dato) {
        NodoGenerico<T> newNodo = new NodoGenerico<>(dato);

        if(primero == null) {
            primero = newNodo;
            tam++;
            return;
        }

        if(dato.compareTo(primero.getDato()) < 0) {
            newNodo.setProximo(primero);
            primero = newNodo;
            tam++;
            return;
        }

        NodoGenerico<T> actual = primero;
        while(actual.getProximo() != null && dato.compareTo(actual.getProximo().getDato()) > 0) {
            actual = actual.getProximo();
        }

        newNodo.setProximo(actual.getProximo());
        actual.setProximo(newNodo);
        tam++;
    }

    //Hacer la implementación del Iterator e Iterable

    public void mostrar() {
        NodoGenerico<T> actual = primero;
        String mensaje = "[";

        //Usando do while
        do {
            mensaje += actual.getDato() + ",";

            actual = actual.getProximo();
        }while(actual != null);

        mensaje += "]";
        System.out.println(mensaje);

        /***Usando while
         while(actual != null) {
         mensaje += actual.getDato() + ",";

         actual = actual.getProximo();
         }
         ***/
    }


    @Override
    public Iterator<T> iterator() {
        return new IteratorListaSimpleGenerica<>(this);
    }
}
