package co.edu.uniquindio;

public class NodoGenerico<T extends Comparable<T>> implements Comparable<NodoGenerico<T>> {
    private T dato;
    private NodoGenerico<T> proximo; //Referencia al siguiente elemento

    public NodoGenerico(T dato) {
        this.dato = dato;
        proximo = null; //NULL inicialmente ya que no referencia a nada antes de ser creada
    }

    //Getters y setters
    public T getDato() {
        return dato;
    }

    public void setDato(T dato) {
        this.dato = dato;
    }

    public NodoGenerico<T> getProximo() {
        return proximo;
    }

    public void setProximo(NodoGenerico<T> proximo) {
        this.proximo = proximo;
    }

    @Override
    public String toString() {
        return "Nodo{" +
                "dato=" + dato +
                ", proximo=" + proximo +
                "}";
    }

    @Override
    public int compareTo(NodoGenerico<T> nodo) {
        return this.dato.compareTo(nodo.getDato());
    }
}
