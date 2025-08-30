/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package empleado;

public class Empleado {

    private String nombre;
    private String apellido;
    private double sueldoMensual;

    public Empleado(String nombre, String apellido, double sueldoMensual) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.sueldoMensual = sueldoMensual;
    }

    public String getNombreCompleto() {
        return nombre + " " + apellido;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public double getSueldoMensual() {
        return sueldoMensual;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public void setSueldoMensual(double sueldoMensual) {
        if (sueldoMensual >= 0) {
            this.sueldoMensual = sueldoMensual;
        } else {
            System.out.println("El sueldo no puede ser negativo.");
        }
    }

    public double calcularImpuesto() {
        double sueldoAnual = sueldoMensual * 12;
        double UIT = 5150;
        double impuesto;

        double UITs = sueldoAnual / UIT;
        if (UITs <= 7) {
            impuesto = 0;
        } else if (UITs <= 12) {
            impuesto = sueldoAnual * 0.08;
        } else if (UITs <= 21) {
            impuesto = sueldoAnual * 0.14;
        } else if (UITs <= 30) {
            impuesto = sueldoAnual * 0.21;
        } else {
            impuesto = sueldoAnual * 0.30;
        }
        return impuesto;
    }

}
