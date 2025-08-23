/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ordensele;

/**
 *
 * @author user
 */
public class OrdenSele {
//el número más pequeño recorre todo el arreglo

    public static void main(String[] args) {
        int arreglo[] = {6, 4, 5, 7, 8, 9, 2};
        for (int i = 0; i < arreglo.length - 1; i++) {
            int pos = i; //posición del número más pequeño
            for (int j = i; j < arreglo.length; j++) {
                if (arreglo[j] < arreglo[pos]) {
                    pos = j;
                }
            }
            if (pos != i) {
                int aux = arreglo[i];
                arreglo[i] = arreglo[pos];
                arreglo[pos] = aux;

            }
        }
        for (int i = 0; i < arreglo.length; i++) {
            System.out.println("Arreglo: " + arreglo[i]);
        }
    }
}
