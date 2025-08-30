/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package empleado;

import java.util.ArrayList;
import java.util.List;

public class Empresa {

    private final List<Empleado> empleados;

    public Empresa() {
        empleados = new ArrayList<>();
    }

    public void agregarEmpleado(Empleado empleado) {
        empleados.add(empleado);
    }

    public void mostrarImpuestos() {
        double totalImpuesto = 0;
        System.out.println("Impuestos de los empleados:");
        for (Empleado empleado : empleados) {
            double impuesto = empleado.calcularImpuesto();
            totalImpuesto += impuesto;
            System.out.printf("%s: S/. %.2f\n", empleado.getNombreCompleto(), impuesto);
        }
        System.out.printf("Total de impuestos: S/. %.2f\n", totalImpuesto);
    }
}
