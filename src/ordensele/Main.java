/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package empleado;

import java.util.Scanner;

/**
 *
 * @author user
 */
public class Main {

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            Empresa empresa = new Empresa();
            System.out.print("Ingrese el número de empleados: ");
            int n = scanner.nextInt();
            scanner.nextLine(); // Limpiar el buffer
            for (int i = 0; i < n; i++) {
                System.out.println("Empleado " + (i + 1) + ":");
                System.out.print("Nombre: ");
                String nombre = scanner.nextLine();
                System.out.print("Apellido: ");
                String apellido = scanner.nextLine();
                System.out.print("Sueldo mensual: ");
                double sueldoMensual = scanner.nextDouble();
                scanner.nextLine(); // Limpiar el buffer
                Empleado empleado = new Empleado(nombre, apellido, sueldoMensual);
                empresa.agregarEmpleado(empleado);
            }
            empresa.mostrarImpuestos();
        }
    }
}
