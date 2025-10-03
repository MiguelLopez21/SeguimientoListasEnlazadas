package co.edu.uniquindio;

public class ListaDoblementeEnlazada<T extends Comparable<T>> {
    private NodoGenerico<T> primero;
    private int tam;

    public ListaDoblementeEnlazada() {
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
            tam++;
        }
        else {
            newNodo.setProximo(primero);
            primero.setAnterior(newNodo);
            primero = newNodo;
            tam++;
        }
    }

    public void agregarUltimo(T dato) {
        NodoGenerico<T> newNodo = new NodoGenerico<>(dato);

        if (primero == null) {
            primero = newNodo;
            tam++;
        } else {
            NodoGenerico<T> actual = primero;
            while(actual.getProximo() != null) {
                actual = actual.getProximo();
            }
            actual.setProximo(newNodo);
            newNodo.setAnterior(actual);
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
        } while (actual != null);

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

