/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ordensele;

/**
 *
 * @author user
 */
public class Promedio {
    public static void main(String[] args) {
       
     // Arreglos paralelos inicializados
        String[] nombres = { 
            "JUAN CARLOS GARCIA RODRIGEZ", 
            "ANA MARIELA TORRES MONTEZ", 
            "ROSA BENAMENTE FARRO", 
            "CARLOS ALBERTO ROJAS TORRES", 
            "GABRIELA LUCIA ALVITES AGUILAR"};
        int[] edad = { 19, 25, 22, 24, 25};
        int[] grado = {5, 5, 4, 5, 5};
        double[] pc1 = { 20, 20, 20, 16, 20};
        double[] pc2 = { 19, 17, 18, 18, 20};
        double[] pc3 = { 15, 18, 12, 15, 14};
        double[] ef = { 17, 16, 13, 12, 15};
        double[] calificaciones = {17.75, 17.75, 15.75, 15.25, 17.25};

        // Copias de los arreglos
        String[] nombresC = nombres.clone();
        int[] edadC = edad.clone();
        int[] gradoC = grado.clone();
        double[] pc1C = pc1.clone();
        double[] pc2C = pc2.clone();
        double[] pc3C = pc3.clone();
        double[] efC = ef.clone();
        double[] calificacionesC = calificaciones.clone();

        // Calcular promedios por alumno y promedio total
        double sumaPromedios = 0;
        double[] promedios = new double[nombresC.length];

        for (int i = 0; i < nombresC.length; i++) {
            promedios[i] = (pc1C[i] + pc2C[i] + pc3C[i] + efC[i]) / 4.0;
            sumaPromedios += promedios[i];
        }
        double promedioTotal = sumaPromedios / nombresC.length;

        // Generar el reporte ASCII usando StringBuilder
        StringBuilder reporte = new StringBuilder();
        
        reporte.append("--------------------------------------REPORTE DE NOTAS---------------------------------------\n");
        reporte.append(String.format(" %-30s %-4s %-5s %-5s %-5s %-5s %-5s %-10s %-10s\n", 
            "NOMBRE", "EDAD", "GRADO", "PC1", "PC2", "PC3", "EF", "PROMEDIO", "CALIFICACIÓN"));
        reporte.append("---------------------------------------------------------------------------------------------\n");

        for (int i = 0; i < nombresC.length; i++) {
            reporte.append(String.format("%-30s %-4d %-5d %-5.1f %-5.1f %-5.1f %-5.1f %-10.2f %-10.2f\n",
                nombresC[i], edadC[i], gradoC[i], pc1C[i], pc2C[i], pc3C[i], efC[i], promedios[i], calificacionesC[i]));
        }

        reporte.append("---------------------------------------------------------------------------------------------\n");
        reporte.append(String.format("PROMEDIO TOTAL: %.2f\n", promedioTotal));

        // Mostrar el reporte
        System.out.println(reporte.toString());
    }
} 
             

