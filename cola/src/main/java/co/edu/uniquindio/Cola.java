package co.edu.uniquindio;

public class Cola <T extends Comparable<T>> {
    private NodoGenerico<T> inicio;
    private NodoGenerico<T> fin;
    int tam;

    public Cola() {
        inicio = null;
        fin = null;
        tam = 0;
    }

    public NodoGenerico<T> getInicio() {
        return inicio;
    }

    public void setInicio(NodoGenerico<T> inicio) {
        this.inicio = inicio;
    }

    public NodoGenerico<T> getFin() {
        return fin;
    }

    public void setFin(NodoGenerico<T> fin) {
        this.fin = fin;
    }

    public int getTam() {
        return tam;
    }

    public void setTam(int tam) {
        this.tam = tam;
    }

    @Override
    public String toString() {
        return "Cola{" + "inicio=" + inicio + ", fin=" + fin + '}';
    }

    public void encolar(T dato) {
        NodoGenerico<T> newNodo = new NodoGenerico<>(dato);

        if(inicio == null) {
            inicio = newNodo;
            fin = newNodo;
            tam++;
        }
        else {
            NodoGenerico<T> actual = inicio;
            while(actual.getProximo() != null) {
                actual = actual.getProximo();
            }
            actual.setProximo(newNodo);
            fin = newNodo;
            tam++;
        }
    }

    public T desencolar() {
        if(inicio == null) {
            return null;
        }

        NodoGenerico<T> aux = inicio;
        inicio = inicio.getProximo();
        tam--;
        return aux.getDato();
    }
}
