/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ordenacion_externa;

import java.util.*;
public class Ordenacion_Polifasico {
    
    /*
     * Simulación simplificada de ordenación polifásica.
     * Distribuye secuencias en 3 "archivos" y mezcla.
     */
    
    // Método para detectar runs naturales
    public static List<List<Integer>> detectarRuns(List<Integer> data) {
        List<List<Integer>> runs = new ArrayList<>();
        List<Integer> run = new ArrayList<>();
        run.add(data.get(0));
        
        for (int i = 1; i < data.size(); i++) {
            if (data.get(i) >= data.get(i - 1)) {
                run.add(data.get(i));
            } else {
                runs.add(run);
                run = new ArrayList<>();
                run.add(data.get(i));
            }
        }
        runs.add(run);
        return runs;
    }
    
    // Método para mezclar múltiples listas ordenadas
    public static List<Integer> mezclarListas(List<List<Integer>> listas) {
        PriorityQueue<Elemento> pq = new PriorityQueue<>(Comparator.comparingInt(e -> e.valor));
        int[] indices = new int[listas.size()];
        List<Integer> resultado = new ArrayList<>();
        
        // Inicializar la cola con el primer elemento de cada lista
        for (int i = 0; i < listas.size(); i++) {
            if (!listas.get(i).isEmpty()) {
                pq.add(new Elemento(i, listas.get(i).get(0)));
            }
        }
        
        while (!pq.isEmpty()) {
            Elemento e = pq.poll();
            resultado.add(e.valor);
            indices[e.lista]++;
            if (indices[e.lista] < listas.get(e.lista).size()) {
                pq.add(new Elemento(e.lista, listas.get(e.lista).get(indices[e.lista])));
            }
        }
        return resultado;
    }
    
    static class Elemento {
        int lista;
        int valor;
        Elemento(int lista, int valor) {
            this.lista = lista;
            this.valor = valor;
        }
    }
    
    // Método principal de ordenación polifásica
    public static List<Integer> ordenacionPolifasica(List<Integer> data) {
        List<List<Integer>> runs = detectarRuns(data);
        
        // Distribuir runs en 3 "archivos" de forma polifásica (simplificado)
        List<List<Integer>> archivos = new ArrayList<>();
        for (int i = 0; i < 3; i++) archivos.add(new ArrayList<>());
        
        for (int i = 0; i < runs.size(); i++) {
            archivos.get(i % 3).addAll(runs.get(i));
        }
        
        // Ordenar cada archivo
        for (List<Integer> archivo : archivos) {
            Collections.sort(archivo);
        }
        
        // Mezclar los 3 archivos
        return mezclarListas(archivos);
    }
    
    public static void main(String[] args) {
        // Ejemplo de uso
        List<Integer> data = Arrays.asList(5, 7, 9, 1, 3, 4, 8, 2, 6);
        System.out.println("Datos originales: " + data);
        
        List<Integer> ordenado = ordenacionPolifasica(data);
        System.out.println("Datos ordenados con ordenación polifásica: " + ordenado);
    }
}
