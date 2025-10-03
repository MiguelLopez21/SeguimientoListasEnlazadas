package co.edu.uniquindio;

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

    public class ListaCircular<T extends Comparable<T>> {
        private class Nodo {
            T dato;
            Nodo siguiente;

            Nodo(T dato) {
                this.dato = dato;
            }
        }

        private Nodo primero;
        private int tam;

        // Insertar en orden natural
        public void insertarOrdenado(T dato) {
            Nodo nuevo = new Nodo(dato);

            // Caso 1: lista vacía
            if (primero == null) {
                primero = nuevo;
                primero.siguiente = primero; // circular
            }
            // Caso 2: insertar antes del primero (nuevo menor o igual que el primero)
            else if (dato.compareTo(primero.dato) <= 0) {
                Nodo ultimo = primero;
                while (ultimo.siguiente != primero) {
                    ultimo = ultimo.siguiente;
                }
                nuevo.siguiente = primero;
                ultimo.siguiente = nuevo;
                primero = nuevo; // actualizar primero
            }
            // Caso 3: insertar en medio o al final
            else {
                Nodo actual = primero;
                while (actual.siguiente != primero && dato.compareTo(actual.siguiente.dato) > 0) {
                    actual = actual.siguiente;
                }
                nuevo.siguiente = actual.siguiente;
                actual.siguiente = nuevo;
            }

            tam++;
        }

        // Ordenar con burbuja adaptado a circular simplemente enlazada
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