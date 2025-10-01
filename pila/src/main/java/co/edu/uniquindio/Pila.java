package co.edu.uniquindio;

public class Pila<T extends Comparable<T>> {
    private NodoGenerico<T> cima;
    private int tam;

    public Pila() {
        cima = null;
        tam = 0;
    }

    public NodoGenerico<T> getCima() {
        return cima;
    }

    public void setCima(NodoGenerico<T> cima) {
        this.cima = cima;
    }

    public int getTam() {
        return tam;
    }

    public void setTam(int tam) {
        this.tam = tam;
    }

    public void enpilar(T dato) {
        NodoGenerico<T> newNodo = new NodoGenerico<>(dato);

        if(cima == null) {
            cima = newNodo;
            tam++;
        }
        else {
            newNodo.setProximo(cima);
            cima = newNodo;
            tam++;
        }
    }

    public void desenpilar() {
        if(cima == null) {
            return;
        }
        else {
            cima = cima.getProximo();
            tam--;
        }
    }

}
