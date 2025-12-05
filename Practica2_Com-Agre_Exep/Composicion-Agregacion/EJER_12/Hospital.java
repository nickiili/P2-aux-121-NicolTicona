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
import java.util.ArrayList;

class Hospital {

    private String nombre;
    private ArrayList<Doctor> doctores;

    public Hospital(String nombre) {
        this.nombre = nombre;
        this.doctores = new ArrayList<>();
    }

    public String getNombre() {
        return nombre;
    }

    public void agregarDoctor(Doctor d) {
        doctores.add(d);
    }

    public void mostrarDoctores() {
        System.out.println("\nDoctores en el hospital " + nombre + ":");
        if (doctores.isEmpty()) {
            System.out.println("No hay doctores registrados.");
        } else {
            for (Doctor d : doctores) {
                System.out.println(" - " + d);
            }
        }
    }
}
