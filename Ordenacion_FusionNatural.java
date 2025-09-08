/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ordenacion_externa;
import java.util.*;
import java.io.*;

public class Ordenacion_FusionNatural {
 
    /*
     * Este programa simula la ordenación fusión natural en memoria.
     * En un entorno real, se trabaja con archivos externos.
     */
    
    // Método para detectar runs naturales en la lista
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
    
    // Método para fusionar dos listas ordenadas
    public static List<Integer> fusionar(List<Integer> a, List<Integer> b) {
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
    
    // Método principal de ordenación fusión natural
    public static List<Integer> fusionNatural(List<Integer> data) {
        List<List<Integer>> runs = detectarRuns(data);
        
        // Mientras haya más de un run, fusionamos en pares
        while (runs.size() > 1) {
            List<List<Integer>> nuevasRuns = new ArrayList<>();
            for (int i = 0; i < runs.size(); i += 2) {
                if (i + 1 < runs.size()) {
                    // Fusionar run i y run i+1
                    nuevasRuns.add(fusionar(runs.get(i), runs.get(i + 1)));
                } else {
                    // Si hay un run sin pareja, se añade tal cual
                    nuevasRuns.add(runs.get(i));
                }
            }
            runs = nuevasRuns;
        }
        return runs.get(0);
    }
    
    public static void main(String[] args) {
        // Ejemplo de uso
        List<Integer> data = Arrays.asList(5, 7, 9, 1, 3, 4, 8, 2, 6);
        System.out.println("Datos originales: " + data);
        
        List<Integer> ordenado = fusionNatural(data);
        System.out.println("Datos ordenados con fusión natural: " + ordenado);
    }
}
