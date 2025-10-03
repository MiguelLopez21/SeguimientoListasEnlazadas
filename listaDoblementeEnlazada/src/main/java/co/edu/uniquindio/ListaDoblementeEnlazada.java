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

    public void insertarOrdenado(T dato) {
        Nodo nuevo = new Nodo(dato);

        // Si la lista está vacía
        if (primero == null) {
            primero = ultimo = nuevo;
        }
        // Si el dato es menor que el primero
        else if (dato.compareTo(primero.dato) <= 0) {
            nuevo.siguiente = primero;
            primero.anterior = nuevo;
            primero = nuevo;
        }
        // Si el dato es mayor que el último
        else if (dato.compareTo(ultimo.dato) >= 0) {
            ultimo.siguiente = nuevo;
            nuevo.anterior = ultimo;
            ultimo = nuevo;
        }
        // Si el dato va en medio
        else {
            Nodo actual = primero;
            while (actual != null && dato.compareTo(actual.dato) > 0) {
                actual = actual.siguiente;
            }
            // Insertar antes de "actual"
            nuevo.siguiente = actual;
            nuevo.anterior = actual.anterior;
            actual.anterior.siguiente = nuevo;
            actual.anterior = nuevo;
        }

        tam++;
    }

    // Método para ordenar la lista (burbuja)
    public void ordenar() {
        if (primero == null) return;

        boolean huboCambio;
        do {
            huboCambio = false;
            Nodo actual = primero;

            while (actual != null && actual.siguiente != null) {
                if (actual.dato.compareTo(actual.siguiente.dato) > 0) {
                    // Intercambiar valores
                    T temp = actual.dato;
                    actual.dato = actual.siguiente.dato;
                    actual.siguiente.dato = temp;
                    huboCambio = true;
                }
                actual = actual.siguiente;
            }
        } while (huboCambio);
    }
}

