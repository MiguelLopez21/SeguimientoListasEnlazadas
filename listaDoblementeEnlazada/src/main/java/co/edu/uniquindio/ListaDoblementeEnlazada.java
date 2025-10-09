package co.edu.uniquindio;

public class ListaDoblementeEnlazada<T extends Comparable<T>> {
    private NodoGenerico<T> primero;
    private NodoGenerico<T> ultimo;
    private int tam;

    public ListaDoblementeEnlazada() {
        primero = null;
        ultimo = null;
        tam = 0;
    }

    // Getters y setters
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

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("[");
        NodoGenerico<T> actual = primero;

        while (actual != null) {
            sb.append(actual.getDato());
            if (actual.getProximo() != null) sb.append(", ");
            actual = actual.getProximo();
        }

        sb.append("]");
        return sb.toString();
    }

    public void agregarPrimero(T dato) {
        NodoGenerico<T> nuevo = new NodoGenerico<>(dato);

        if (primero == null) {
            primero = nuevo;
            ultimo = nuevo;
        } else {
            nuevo.setProximo(primero);
            primero.setAnterior(nuevo);
            primero = nuevo;
        }
        tam++;
    }

    public void agregarUltimo(T dato) {
        NodoGenerico<T> nuevo = new NodoGenerico<>(dato);

        if (primero == null) {
            primero = nuevo;
            ultimo = nuevo;
        } else {
            ultimo.setProximo(nuevo);
            nuevo.setAnterior(ultimo);
            ultimo = nuevo;
        }
        tam++;
    }

    public void mostrar() {
        NodoGenerico<T> actual = primero;
        StringBuilder mensaje = new StringBuilder("[");

        while (actual != null) {
            mensaje.append(actual.getDato());
            if (actual.getProximo() != null) mensaje.append(", ");
            actual = actual.getProximo();
        }

        mensaje.append("]");
        System.out.println(mensaje);
    }

    // ✅ Inserta manteniendo el orden natural
    public void insertarOrdenado(T dato) {
        NodoGenerico<T> nuevo = new NodoGenerico<>(dato);

        // Caso 1: lista vacía
        if (primero == null) {
            primero = nuevo;
            ultimo = nuevo;
        }
        // Caso 2: el dato es menor que el primero
        else if (dato.compareTo(primero.getDato()) <= 0) {
            nuevo.setProximo(primero);
            primero.setAnterior(nuevo);
            primero = nuevo;
        }
        // Caso 3: el dato es mayor que el último
        else if (dato.compareTo(ultimo.getDato()) >= 0) {
            ultimo.setProximo(nuevo);
            nuevo.setAnterior(ultimo);
            ultimo = nuevo;
        }
        // Caso 4: insertar en el medio
        else {
            NodoGenerico<T> actual = primero;
            while (actual != null && dato.compareTo(actual.getDato()) > 0) {
                actual = actual.getProximo();
            }
            // Insertar antes de "actual"
            NodoGenerico<T> anterior = actual.getAnterior();
            nuevo.setProximo(actual);
            nuevo.setAnterior(anterior);
            anterior.setProximo(nuevo);
            actual.setAnterior(nuevo);
        }

        tam++;
    }

    // ✅ Método para ordenar (burbuja)
    public void ordenar() {
        if (primero == null) return;

        boolean huboCambio;
        do {
            huboCambio = false;
            NodoGenerico<T> actual = primero;

            while (actual != null && actual.getProximo() != null) {
                if (actual.getDato().compareTo(actual.getProximo().getDato()) > 0) {
                    // Intercambiar valores
                    T temp = actual.getDato();
                    actual.setDato(actual.getProximo().getDato());
                    actual.getProximo().setDato(temp);
                    huboCambio = true;
                }
                actual = actual.getProximo();
            }
        } while (huboCambio);
    }
}


