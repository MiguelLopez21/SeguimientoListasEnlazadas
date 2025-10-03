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

    // Método para insertar en orden natural
    public void insertarOrdenado(T dato) {
        Nodo nuevo = new Nodo(dato);

        // Caso: lista vacía
        if (primero == null) {
            primero = nuevo;
            primero.siguiente = primero;
            primero.anterior = primero;
        }
        else {
            Nodo actual = primero;
            boolean insertado = false;

            do {
                // Si el dato debe ir antes del actual
                if (dato.compareTo(actual.dato) <= 0) {
                    Nodo anterior = actual.anterior;

                    nuevo.siguiente = actual;
                    nuevo.anterior = anterior;

                    anterior.siguiente = nuevo;
                    actual.anterior = nuevo;

                    // Si se inserta antes del primero, actualizar primero
                    if (actual == primero) {
                        primero = nuevo;
                    }

                    insertado = true;
                    break;
                }
                actual = actual.siguiente;
            } while (actual != primero);

            // Si no se insertó en el ciclo, va al final
            if (!insertado) {
                Nodo ultimo = primero.anterior;

                nuevo.siguiente = primero;
                nuevo.anterior = ultimo;

                ultimo.siguiente = nuevo;
                primero.anterior = nuevo;
            }
        }
        tam++;
    }

    // Método para ordenar la lista (burbuja adaptado a circular)
    public void ordenar() {
        if (primero == null || tam < 2) return;

        boolean huboCambio;
        do {
            huboCambio = false;
            Nodo actual = primero;

            for (int i = 0; i < tam; i++) {
                Nodo siguiente = actual.siguiente;

                if (actual.dato.compareTo(siguiente.dato) > 0) {
                    // Intercambiar valores
                    T temp = actual.dato;
                    actual.dato = siguiente.dato;
                    siguiente.dato = temp;
                    huboCambio = true;
                }
                actual = siguiente;
            }
        } while (huboCambio);
    }
}
