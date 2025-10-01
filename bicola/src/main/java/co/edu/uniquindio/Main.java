package co.edu.uniquindio;

public class Main {
    public static void main(String[] args) {
        Bicola<String> bicola = new Bicola<>();
        bicola.encolarInicio("Hola");
        bicola.encolarInicio("Adios");
        System.out.println(bicola.toString());

        Bicola<String> bicola2 = new Bicola<>();
        bicola2.encolarInicio("Uno");
        bicola2.encolarInicio("Dos");
        bicola2.desencolarFinal();
        System.out.println(bicola2.toString());
    }
}
