package org.reto;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Main {
    /*
     * Escribe un programa que sea capaz de generar contraseñas de forma aleatoria.
     * Podrás configurar generar contraseñas con los siguientes parámetros:
     * - Longitud: Entre 8 y 16.
     * - Con o sin letras mayúsculas.
     * - Con o sin números.
     * - Con o sin símbolos.
     * (Pudiendo combinar todos estos parámetros entre ellos)
     */

    public static void main(String[] args) {
       int length =0;
       boolean capital = false;
       boolean num = false;
       boolean sym = false;
       int numAux;
       String strAux;
       boolean controller;
       Scanner myScanner = new Scanner(System.in);

       System.out.println("Para generar una contraseña configure los siguientes parametros:");

       do {
           System.out.println("Escribe la longitud entre 8 y 16: ");
           numAux =myScanner.nextInt();
           if (numAux >= 8 && numAux <= 16)
               length = numAux;
           else
               System.out.println("La logitud escogida no es correcta. Vuelva a intentarlo");
       }
       while (numAux < 8 || numAux > 16);

        do {
            System.out.println("¿Quiere que contenga letras mayusculas? (Y/N): ");
            strAux = myScanner.next().toLowerCase();

            if (strAux.equals("y") || strAux.equals("n")) {
                capital = strAux.equals("y");
                controller = true;
            }
            else {
                System.out.println("Error, Escribe (Y)es o (N)o. Vuelva a intentarlo");
                controller=false;
            }
        }
        while (!controller);

        do {
            System.out.println("¿Quiere que contenga numeros? (Y/N): ");
            strAux = myScanner.next().toLowerCase();

            if (strAux.equals("y") || strAux.equals("n")) {
                num = strAux.equals("y");
                controller = true;
            }
            else {
                System.out.println("Error, Escribe (Y)es o (N)o. Vuelva a intentarlo");
                controller=false;
            }
        }
        while (!controller);

        do {
            System.out.println("¿Quiere que contenga simbolos? (Y/N): ");
            strAux = myScanner.next().toLowerCase();

            if (strAux.equals("y") || strAux.equals("n")) {
                sym = strAux.equals("y");
                controller = true;
            }
            else {
                System.out.println("Error, Escribe (Y)es o (N)o. Vuelva a intentarlo");
                controller=false;
            }
        }
        while (!controller);

        System.out.println("Su password es: " + passwordGenerator(length, capital, num, sym));
    }

    public static String passwordGenerator(int length, boolean capital, boolean num, boolean sym){
        Random r = new Random();
        char abc;
        List<Character> charList = new ArrayList<>();
        StringBuilder password = new StringBuilder();

        for(abc = 97; abc<123; abc++){
            charList.add(abc);
        }

        if(capital){
            for(abc = 65; abc<91; abc++){
                charList.add(abc);
            }
        }

        if(num){
            for(abc = 48; abc<58; abc++){
                charList.add(abc);
            }
        }

        if(sym){
            for(abc = 33; abc<48; abc++){
                charList.add(abc);
            }
            for(abc = 58; abc<65; abc++){
                charList.add(abc);
            }
            for(abc = 91; abc<97; abc++){
                charList.add(abc);
            }
        }

        for (int i = 0; i < length; i++){
            password.append(charList.get(r.nextInt(charList.size())));
        }

        return password.toString();
    }
}