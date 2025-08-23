/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ordensele;

import java.util.Arrays;

/**
 *
 * @author user
 */
public class OrdenBurbuja {

    public static void main(String[] args) {

        int[] miLista = {1, 52, 12, 53, 15, 3, 5};
        System.out.println("lista original: " + Arrays.toString(miLista));

        ordenamientoBurbuja(miLista);
        System.out.println("lista ordenada: " + Arrays.toString(miLista));
    }

    public static int[] ordenamientoBurbuja(int[] lista) {
        for (int i = 0; i < lista.length - 1; i++) {
            for (int j = 0; j < lista.length - 1; j++) {
                if (lista[j] > lista[j + 1]) {
                    int temporal = lista[j];
                    lista[j] = lista[j + 1];
                    lista[j + 1] = temporal;
                }
            }
        }
        return lista;
    }

}
