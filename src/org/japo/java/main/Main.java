/* 
 * Copyright 2019 Oscar G.4 - oscargimenez4@gmail.com.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.japo.java.main;

import java.util.Locale;
import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author Oscar G.4 - oscargimenez4@gmail.com
 */
public class Main {

    public static final Random RND = new Random();
    public static final Scanner SCN
            = new Scanner(System.in, "Windows-1252")
                    .useLocale(Locale.ENGLISH).useDelimiter("\\s+");

    public static void main(String[] args) {
        //Constantes
        //----------
        //Constantes definidas para establecer el numero de intentos
        final int INT_MAXIMOS = 3;
        final int INT_MINIMOS = 1;
        //Constantes definidas para establecer el numero minimo y maximo
        final int NUM_MAX = 10;
        final int NUM_MIN = 1;
        //Variables
        //----------
        //Variable para definir el numero de intentos del user
        int intentos = INT_MAXIMOS;
        //Variables de los numeros y para que se guarden
        int numeroGanador = 0;
        int numeroUser = 0;
        //---------
        //Cabecera Basica
        System.out.println("MEGA ADIVINATOR (c) 2019 - JAPO Labs");
        System.out.println("------------------------------------");
        System.out.println("Se ha generado un número entre 1 y 10");
        System.out.println("---");
        //Generador del numero ganador de forma aleatoria
        numeroGanador = RND.nextInt(NUM_MAX - NUM_MIN + 1) + NUM_MIN;
        //Bucle
        while (intentos >= INT_MINIMOS && intentos <= INT_MAXIMOS
                && numeroUser != numeroGanador) {
            //Entrada del usuario con Scanner
            try {
                System.out.printf("Quedan %d intentos - Número: ", intentos);
                //Introducir dato
                numeroUser = SCN.nextInt();
                //Restar un intento
                intentos--;
                //Calculos para mostar al usuario si:
                if (intentos < INT_MINIMOS && numeroUser != numeroGanador) {
                    //Se ha quedado sin intentos
                    System.out.println("Número de intentos AGOTADO.");
                } else if (numeroUser < numeroGanador) {
                    //Si su numero es menor al ganador
                    System.out.println("Prueba un número MAYOR.");
                } else if (numeroUser > numeroGanador) {
                    //Si su numero es mayor al ganador
                    System.out.println("Prueba un número MENOR.");
                }
                //Separador de linea
                System.out.println("---");
            } catch (Exception e) {
                //Mensaje por si error
                System.out.println("ERROR: Entrada incorrecta");
            } finally {
                //Limpiar buffer
                SCN.nextLine();
            }
        }
        //Mensajes finales
        if (numeroUser == numeroGanador) {
            //Mensajes final si acierta el numero
            System.out.printf("Era el %d - ¡Enhorabuena!%n", numeroGanador);
        } else {
            //Mensajes final si no acierta el numero
            System.out.printf("Era el %d - ¡Otra vez será!%n", numeroGanador);
        }
    }
}
