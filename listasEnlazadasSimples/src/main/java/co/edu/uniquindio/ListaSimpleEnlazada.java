package co.edu.uniquindio;

public class ListaSimpleEnlazada {
    private Nodo primero;
    private int tam;

    public ListaSimpleEnlazada() {
        primero = null;
        tam = 0;
    }

    //Getters y setters
    public Nodo getPrimero() {
        return primero;
    }

    public void setPrimero(Nodo primero) {
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

    public void agregarPrimero(Nodo newNodo) {
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

    public void agregarUltimo(Nodo newNodo) {
        if(primero == null) {
            primero = newNodo;
            tam++;
        }
        else {
            Nodo actual = primero;
            while(actual.getProximo() != null) {
                actual = actual.getProximo();
            }
            actual.setProximo(newNodo);
            tam++;
        }
    }

    public void agregarPosicionEspecifica(Nodo newNodo, int index) {
        if(index == 0) {
            newNodo.setProximo(primero);
            primero = newNodo;
        }
        else if(index > tam) {
            System.out.println("Fuera de los límites del tamaño la lista");
        }
        else{
            Nodo actual = primero;
            int acc = 0;

            while(acc < index - 1) {
                actual = actual.getProximo();
                acc++;
            }
            newNodo.setProximo(actual.getProximo());
            actual.setProximo(newNodo);
        }
        tam++;
    }

    public void mostrar() {
        Nodo actual = primero;
        String mensaje = "[";

        //Usando while
        while(actual != null) {
            mensaje += actual.getDato() + ",";

            actual = actual.getProximo();
        }

        mensaje += "]";
        System.out.println(mensaje);

        /***Usando do while
        do {
            mensaje += actual.getDato() + ",";

            actual = actual.getProximo();
         }while(actual != null);
         ***/
    }
}
