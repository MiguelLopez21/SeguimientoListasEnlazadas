package co.edu.uniquindio;

public class Main {
    public static void main(String[] args) {
        ListaDoblementeEnlazada<Integer> lista = new ListaDoblementeEnlazada<>();

        lista.agregarPrimero(3);
        lista.agregarPrimero(2);
        lista.agregarPrimero(1);

        lista.agregarUltimo(4);
        lista.agregarUltimo(5);
        lista.agregarUltimo(6);

        System.out.println(lista.getPrimero());
        System.out.println(lista.getPrimero().getProximo());
        System.out.println(lista.getPrimero().getProximo().getProximo());
        System.out.println(lista.getPrimero().getProximo().getProximo().getProximo());
        System.out.println(lista.getPrimero().getProximo().getProximo().getProximo().getProximo());
        System.out.println(lista.getPrimero().getProximo().getProximo().getProximo().getProximo().getProximo());

        lista.mostrar();
    }
}