package co.edu.uniquindio;

import java.util.Iterator;

public class Main {
    public static void main(String[] args) {
        //Lista 1
        //ListaSimpleEnlazada lista1 = new ListaSimpleEnlazada();

        //lista1.agregarPrimero(new Nodo(1));
        //lista1.agregarPrimero(new Nodo(2));
        //lista1.agregarPrimero(new Nodo(3));
        //lista1.agregarUltimo(new Nodo(4));
        //lista1.agregarPosicionEspecifica(new Nodo(5), 0);

        //lista1.mostrar();

        //Lista 2
        ListaSimpleEnlazadaGenerica<String> lista2 = new ListaSimpleEnlazadaGenerica<>();

        lista2.agregarPrimero("Hola");
        lista2.agregarPrimero("The World");
        lista2.agregarPrimero("Pacman");
        lista2.agregarUltimo("Bye");
        lista2.agregarPosicionEspecifica("New", 0);

        lista2.mostrar();

        //Lista 3 está vacía
        ListaSimpleEnlazadaGenerica<String> lista3 = new ListaSimpleEnlazadaGenerica<>();
        System.out.println(lista3.esVacia());

        //Lista 4
        ListaSimpleEnlazadaGenerica<String> lista4 = new ListaSimpleEnlazadaGenerica<>();
        lista4.insercionNatural("D");
        lista4.insercionNatural("B");
        lista4.insercionNatural("C");
        lista4.insercionNatural("A");

        lista4.mostrar();

        Iterator<String> iterator =  lista4.iterator();

        while(iterator.hasNext()) {
            String datoNodo = iterator.next();
            System.out.println(datoNodo);
        }
    }
}
