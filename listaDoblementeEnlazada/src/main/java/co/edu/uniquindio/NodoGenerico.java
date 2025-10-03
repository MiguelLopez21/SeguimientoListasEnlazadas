package co.edu.uniquindio;

public class NodoGenerico<T extends Comparable<T>> implements Comparable<NodoGenerico<T>> {
    private T dato;
    private NodoGenerico<T> proximo; //Referencia al siguiente elemento
    private NodoGenerico<T> anterior; //Referencia al elemento anterior

    public NodoGenerico(T dato) {
        this.dato = dato;
        proximo = null; //NULL inicialmente ya que no referencia a nada antes de ser creada
        anterior = null; //NULL inicialmente ya que no referencia a nada antes de ser creada
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

    public NodoGenerico<T> getAnterior() {
        return anterior;
    }

    public void setAnterior(NodoGenerico<T> anterior) {
        this.anterior = anterior;
    }

    @Override
    public String toString() {
        return "Nodo{" +
                "dato=" + dato +
                //", proximo=" + proximo +
                ", anterior=" + (anterior != null ? anterior.getDato() : null) +
                ", proximo=" + (proximo != null ? proximo.getDato() : null) +
                "}";
    }

    @Override
    public int compareTo(NodoGenerico<T> nodo) {
        return this.dato.compareTo(nodo.getDato());
    }
}

