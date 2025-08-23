/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ordensele;

import java.util.Scanner;

/**
 *
 * @author user
 */
public class OrdenInser {

    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        int arreglo[], nElementos, pos, aux;

        System.out.println("Digite el número de elementos del arreglo: ");
        nElementos = entrada.nextInt();

        arreglo = new int[nElementos];
        System.out.println("Digite el arreglo: ");
        for (int i = 0; i < nElementos; i++) {
            System.out.print((i + 1) + ". Digiste un número: ");
            arreglo[i] = entrada.nextInt();
        }
        for (int i = 0; i < nElementos; i++) {
            pos = i;
            aux = arreglo[i];

            while ((pos > 0) && (arreglo[pos - 1] > aux)) {
                arreglo[pos] = arreglo[pos - 1];
                pos--;

            }
            arreglo[pos] = aux;

        }
        System.out.println("\nOrden Ascendente: ");
        for (int i = 0; i < nElementos; i++) {
            System.out.print(arreglo[i] + " - ");
        }
        System.out.println("");

        System.out.println("Orden Desendente: ");
        for (int i = (nElementos - 1); i >= 0; i--) {
            System.out.print(arreglo[i] + " - ");
        }
        System.out.println("");

    }

}
