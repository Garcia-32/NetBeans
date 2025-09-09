/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ordenacion_externa;
import java.util.*;
public class Ordenacion_MezclaEquilibrada {
    


    /*
     * Simulación de mezcla equilibrada con listas.
     * Divide en partes iguales y mezcla equilibradamente.
     */
    
    // Método para mezclar dos listas ordenadas
    public static List<Integer> mezclar(List<Integer> a, List<Integer> b) {
        List<Integer> resultado = new ArrayList<>();
        int i = 0, j = 0;
        while (i < a.size() && j < b.size()) {
            if (a.get(i) <= b.get(j)) {
                resultado.add(a.get(i++));
            } else {
                resultado.add(b.get(j++));
            }
        }
        while (i < a.size()) resultado.add(a.get(i++));
        while (j < b.size()) resultado.add(b.get(j++));
        return resultado;
    }
    
    // Método para dividir la lista en partes iguales
    public static List<List<Integer>> dividir(List<Integer> data, int partes) {
        List<List<Integer>> resultado = new ArrayList<>();
        int tam = (int) Math.ceil((double) data.size() / partes);
        for (int i = 0; i < data.size(); i += tam) {
            resultado.add(new ArrayList<>(data.subList(i, Math.min(i + tam, data.size()))));
        }
        return resultado;
    }
    
    // Método principal de mezcla equilibrada
    public static List<Integer> mezclaEquilibrada(List<Integer> data, int partes) {
        List<List<Integer>> listas = dividir(data, partes);
        
        // Ordenar cada sublista (simulando ordenación previa)
        for (int i = 0; i < listas.size(); i++) {
            Collections.sort(listas.get(i));
        }
        
        // Mezclar iterativamente hasta obtener una sola lista
        while (listas.size() > 1) {
            List<List<Integer>> nuevasListas = new ArrayList<>();
            for (int i = 0; i < listas.size(); i += 2) {
                if (i + 1 < listas.size()) {
                    nuevasListas.add(mezclar(listas.get(i), listas.get(i + 1)));
                } else {
                    nuevasListas.add(listas.get(i));
                }
            }
            listas = nuevasListas;
        }
        return listas.get(0);
    }
    
    public static void main(String[] args) {
        // Ejemplo de uso
        List<Integer> data = Arrays.asList(5, 7, 9, 1, 3, 4, 8, 2, 6);
        System.out.println("Datos originales: " + data);
        
        List<Integer> ordenado = mezclaEquilibrada(data, 3);
        System.out.println("Datos ordenados con mezcla equilibrada: " + ordenado);
    }
}
