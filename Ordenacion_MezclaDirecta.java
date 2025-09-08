/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ordenacion_externa;

import java.util.*;

public class Ordenacion_MezclaDirecta {
  
    /*
     * Este programa simula la ordenación mezcla directa.
     * Divide el arreglo en mitades, ordena y mezcla.
     */
    
    // Método para mezclar dos subarreglos ordenados
    public static void mezclar(int[] arr, int inicio, int medio, int fin) {
        int n1 = medio - inicio + 1;
        int n2 = fin - medio;
        
        int[] L = new int[n1];
        int[] R = new int[n2];
        
        for (int i = 0; i < n1; i++) L[i] = arr[inicio + i];
        for (int j = 0; j < n2; j++) R[j] = arr[medio + 1 + j];
        
        int i = 0, j = 0, k = inicio;
        while (i < n1 && j < n2) {
            if (L[i] <= R[j]) {
                arr[k++] = L[i++];
            } else {
                arr[k++] = R[j++];
            }
        }
        while (i < n1) arr[k++] = L[i++];
        while (j < n2) arr[k++] = R[j++];
    }
    
    // Método recursivo de mezcla directa (merge sort)
    public static void mezclaDirecta(int[] arr, int inicio, int fin) {
        if (inicio < fin) {
            int medio = (inicio + fin) / 2;
            mezclaDirecta(arr, inicio, medio);
            mezclaDirecta(arr, medio + 1, fin);
            mezclar(arr, inicio, medio, fin);
        }
    }
    
    public static void main(String[] args) {
        // Ejemplo de uso
        int[] data = {5, 7, 9, 1, 3, 4, 8, 2, 6};
        System.out.println("Datos originales: " + Arrays.toString(data));
        
        mezclaDirecta(data, 0, data.length - 1);
        System.out.println("Datos ordenados con mezcla directa: " + Arrays.toString(data));
    }
}
