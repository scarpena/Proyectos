package org.reto;

import java.util.Scanner;

public class Main {

    /*
     * Escribe un programa que muestre cómo transcurre un juego de tenis y quién lo ha ganado.
     * El programa recibirá una secuencia formada por "P1" (Player 1) o "P2" (Player 2), según quien
     * gane cada punto del juego.
     *
     * - Las puntuaciones de un juego son "Love" (cero), 15, 30, 40, "Deuce" (empate), ventaja.
     * - Ante la secuencia [P1, P1, P2, P2, P1, P2, P1, P1], el programa mostraría lo siguiente:
     *   15 - Love
     *   30 - Love
     *   30 - 15
     *   30 - 30
     *   40 - 30
     *   Deuce
     *   Ventaja P1
     *   Ha ganado el P1
     * - Si quieres, puedes controlar errores en la entrada de datos.
     * - Consulta las reglas del juego si tienes dudas sobre el sistema de puntos.
     */

    public static void main(String[] args) {

        System.out.println("(Utiliza 'P1' y 'P2' para indicar que jugador ha anotado un punto Ejemplo: P1, P2, P2, P1...)\nEmpieza el partido!!");

        empezarPartido();
    }

    private static void empezarPartido() {
        String[] puntuacion = new String[]{"LOVE", "15", "30", "40", "DEUCE", "ADVANTAGE"};
        Scanner myScanner = new Scanner(System.in);
        String punto = "";
        int diferencia;
        boolean endMatch = false;
        int p1 = 0;
        int p2 = 0;

        do {
            System.out.println("Introduzca que jugador anota el siguiente punto:");
            punto = myScanner.nextLine();
            if (punto.equalsIgnoreCase("p1") || punto.equalsIgnoreCase("p2")) {

                if (punto.equalsIgnoreCase("p1"))
                    p1++;
                else
                    p2++;

                if (p1 == 3 && p2 == 3) {
                    System.out.println("Deuce");
                } else if (p1 >= 4 || p2 >= 4) {
                    diferencia = p1 - p2;

                    if (diferencia == 0) {
                        System.out.println("Deuce");
                    } else if (diferencia == 1) {
                        System.out.println("Ventaja Player1");
                    } else if (diferencia == -1) {
                        System.out.println("Ventaja Player2");
                    } else if (diferencia >= 2) {
                        System.out.println("Ha ganado el P1");
                        endMatch = true;
                    } else {
                        System.out.println("Ha ganado el P2");
                        endMatch = true;
                    }
                }
                else {
                    System.out.println(puntuacion[p1] + " - " + puntuacion[p2]);
                }
            }
            else
                System.out.println("Error al introducir jugador, introduzca 'P1' para Player1 o 'P2' para Player2");

        }
        while (!endMatch);
    }

}
