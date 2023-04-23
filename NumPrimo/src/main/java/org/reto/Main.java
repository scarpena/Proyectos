package org.reto;

import java.util.Scanner;

public class Main {
    /*
     * Reto #3
     * ¿ES UN NÚMERO PRIMO?
     * Fecha publicación enunciado: 17/01/22
     * Fecha publicación resolución: 24/01/22
     * Dificultad: MEDIA
     *
     * Enunciado: Escribe un programa que se encargue de comprobar si un número es o no primo.
     * Hecho esto, imprime los números primos entre 1 y 100.
     *
     */
    public static void main(String[] args) {
        Scanner myScanner = new Scanner(System.in);
        System.out.println("Escribe un numero para saber si es primo: ");
        int num = myScanner.nextInt();
        if(esPrimo(num)){
            System.out.println("El numero "+ num + " es primo");
        }
        else
            System.out.println("El numero "+ num + " no es primo");

        System.out.print("\nNumeros primos entre el 1 y el 100:\n");
        for(int i =0; i<= 100; i++){

            if(esPrimo(i)){
                System.out.print(i + ", ");
            }
        }
    }

    public static boolean esPrimo(int numero) {
        // El 0, 1 y 4 no son primos
        if (numero == 0 || numero == 1 || numero == 4) {
            return false;
        }
        for (int x = 2; x < numero / 2; x++) {
            // Si es divisible por cualquiera de estos números, no es primo
            if (numero % x == 0)
                return false;
        }
        // Si no se pudo dividir por ninguno de los de arriba, sí es primo
        return true;
    }
}