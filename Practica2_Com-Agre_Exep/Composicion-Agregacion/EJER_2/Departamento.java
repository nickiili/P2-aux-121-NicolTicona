/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.composicion_agregacion;

/**
 *
 * @author HP-RYZEN 5
 */
//Nicol Yanina Ticona Aduviri
//CI: 6786427
public class Departamento {

    private String nombre;
    private String area;
    private Empleado[] empleados;
    private int cantidad;

    public Departamento(String nombre, String area, int max) {
        this.nombre = nombre;
        this.area = area;
        empleados = new Empleado[max];
        cantidad = 0;
    }

    public void agregarEmpleado(Empleado e) {
        if (cantidad < empleados.length) {
            empleados[cantidad++] = e;
        }
    }

    public void mostrarEmpleados() {
        System.out.println("Departamento: " + nombre);
        for (int i = 0; i < cantidad; i++) {
            System.out.println("  " + empleados[i]);
        }
    }

    public void cambioSalario(double nuevoSueldo) {
        for (int i = 0; i < cantidad; i++) {
            empleados[i].setSueldo(nuevoSueldo);
        }
    }

    public boolean contieneEmpleado(Empleado e) {
        for (int i = 0; i < cantidad; i++) {
            if (empleados[i] == e) {
                return true;
            }
        }
        return false;
    }

    public void moverEmpleadosA(Departamento destino) {
        for (int i = 0; i < cantidad; i++) {
            destino.agregarEmpleado(empleados[i]);
        }
        cantidad = 0;
    }
}
