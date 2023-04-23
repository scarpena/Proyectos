package org.retos;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    /*
     * Reto #1
     * ¿ES UN ANAGRAMA?
     * Fecha publicación enunciado: 03/01/22
     * Fecha publicación resolución: 10/01/22
     * Dificultad: MEDIA
     *
     * Enunciado: Escribe una función que reciba dos palabras (String) y retorne verdadero o falso (Boolean) según sean o no anagramas.
     * Un Anagrama consiste en formar una palabra reordenando TODAS las letras de otra palabra inicial.
     * NO hace falta comprobar que ambas palabras existan.
     * Dos palabras exactamente iguales no son anagrama.
     */
    public static void main(String[] args) {
        String palabra = "";
        String anagrama = "";
        Scanner myScanner = new Scanner(System.in);

        System.out.println("escribe una palabra...");
        palabra = myScanner.nextLine();

        System.out.println("escribe un anagrama de la palabra introducida anteriormente...");
        anagrama = myScanner.nextLine();

        boolean res = comprobarAnagrama(palabra, anagrama);

        if(res){
            System.out.println("Correcto! La palabra introducida es un anagrama de la palabra inicial");
        }
        else
            System.out.println("Incorrecto! La palabra introducida no es un anagrama de la palabra inicial");
    }

    public static String ordenar (String palabra){
        char[] cadena = palabra.toCharArray();
        Arrays.sort(cadena);
        return new String(cadena);
    }
    public static boolean comprobarAnagrama (String palabra1, String palabra2){

        palabra1 = palabra1.toLowerCase().replace(" ", "").replace(".", "").replace(",", "").replace("á", "a").replace("é", "e").replace("í", "i").replace("ó", "o").replace("ú", "u");
        palabra2 = palabra2.toLowerCase().replace(" ", "").replace(".", "").replace(",", "").replace("á", "a").replace("é", "e").replace("í", "i").replace("ó", "o").replace("ú", "u");

        if(palabra1.equals(palabra2)){
            return false;
        }

        palabra1 = ordenar(palabra1);
        palabra2 = ordenar(palabra2);

        return palabra1.equals(palabra2);
    }
}