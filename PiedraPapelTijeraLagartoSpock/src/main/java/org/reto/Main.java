package org.reto;

import java.util.Scanner;

public class Main {

    /*
     * Crea un programa que calcule quien gana más partidas al piedra,
     * papel, tijera, lagarto, spock.
     * - El resultado puede ser: "Player 1", "Player 2", "Tie" (empate)
     * - La función recibe un listado que contiene pares, representando cada jugada.
     * - El par puede contener combinaciones de "🗿" (piedra), "📄" (papel),
     *   "✂️" (tijera), "🦎" (lagarto) o "🖖" (spock).
     * - Ejemplo. Entrada: [("🗿","✂️"), ("✂️","🗿"), ("📄","✂️")]. Resultado: "Player 2".
     * - Debes buscar información sobre cómo se juega con estas 5 posibilidades.
     */

    public static void main(String[] args) {
        final String[] values = new String[]{"PIEDRA", "PAPEL", "TIJERAS", "LAGARTO", "SPOCK"};
        Scanner myScanner = new Scanner(System.in);
        String jugadaP1;
        String jugadaP2;
        int puntosP1 = 0;
        int puntosP2 = 0;
        int value;
        int playerWin;
        int totalRondas;

        System.out.println("Empieza la partida!!");

        System.out.println("Indica el numero de rondas que quieres jugar (max. 5): ");
        String rondas = myScanner.nextLine();

        while (!rondas.matches("[1-5]")){
            System.out.println("Error, Indica el numero de rondas que quieres jugar: ");
            rondas = myScanner.nextLine();
        }
        totalRondas = Integer.parseInt(rondas);

        for(int i = 0; i <= totalRondas; i++){

            System.out.println("Escoge una opción Jugador 1:\n1-Pidra\n2-Papel\n3-Tijeras\n4-Lagarto\n5-Spock");
            value = myScanner.nextInt();

            while (value < 1 || value > 5){
                System.out.println("Opción incorrecta. Elija una opción valida entre 1-5: ");
                value = myScanner.nextInt();
            }
            jugadaP1=values[value-1];

            System.out.println("Escoge una opción Jugador 2:\n1-Pidra\n2-Papel\n3-Tijeras\n4-Lagarto\n5-Spock");
            value = myScanner.nextInt();

            while (value < 1 || value > 5){
                System.out.println("Opción incorrecta. Elija una opción valida entre 1-5: ");
                value = myScanner.nextInt();
            }
            jugadaP2=values[value-1];

            System.out.println("Player1( " + jugadaP1 + " - " + jugadaP2 + " )Player2\n");

            playerWin = comprobarValores(jugadaP1, jugadaP2);

            if(playerWin==1)
                puntosP1++;
            else if(playerWin==2)
                puntosP2++;
            else
                System.out.println("EMPATE");

            System.out.println("--MARCADOR--\nPlayer1( " + puntosP1+ " - " + puntosP2 + " )Player2\n");
        }

        if(puntosP1==puntosP2)
            System.out.println("---------------------\nEMPATE!!\n---------------------");
        else if(puntosP1>puntosP2)
            System.out.println("---------------------\nEl Player1 HA GANADO!!\n---------------------");
        else
            System.out.println("---------------------\nEl Player2 HA GANADO!!\n---------------------");
    }

    private static int comprobarValores(String jugadaP1, String jugadaP2) {

        if(jugadaP1.equals(jugadaP2)){
            return 0;
        }
        else if(jugadaP1.equals("PIEDRA")){
            if(jugadaP2.equals("LAGARTO") || jugadaP2.equals("TIJERAS")){
                return 1;
            }
            else
                return 2;
        }
        else if(jugadaP1.equals("PAPEL")){
            if(jugadaP2.equals("PIEDRA") || jugadaP2.equals("SPOCK")){
                return 1;
            }
            else
                return 2;
        }
        else if(jugadaP1.equals("TIJERAS")){
            if(jugadaP2.equals("PAPEL") || jugadaP2.equals("LAGARTO")){
                return 1;
            }
            else
                return 2;
        }
        else if(jugadaP1.equals("LAGARTO")){
            if(jugadaP2.equals("SPOCK") || jugadaP2.equals("PAPEL")){
                return 1;
            }
            else
                return 2;
        }
        else {
            if(jugadaP2.equals("TIJERAS") || jugadaP2.equals("PIEDRA")){
                return 1;
            }
            else
                return 2;
        }
    }
}