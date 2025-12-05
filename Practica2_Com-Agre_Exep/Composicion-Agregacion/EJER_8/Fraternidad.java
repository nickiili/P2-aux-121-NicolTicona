/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.composicion_agregacion;

import java.util.ArrayList;

/**
 *
 * @author HP-RYZEN 5
 */
//Nicol Yanina Ticona Aduviri
//CI: 6786427
class Fraternidad {

    private String nombre;
    private Persona encargado;
    private ArrayList<Participante> bailarines;

    public Fraternidad(String nombre, Persona encargado) {
        this.nombre = nombre;
        this.encargado = encargado;
        this.bailarines = new ArrayList<>();
    }

    public String getNombre() {
        return nombre;
    }

    public Persona getEncargado() {
        return encargado;
    }

    public ArrayList<Participante> getBailarines() {
        return bailarines;
    }

    public void agregarParticipante(Participante p) {
        // Validar que NO esté en otra fraternidad
        if (p.getFraternidad() != null) {
            System.out.println("\n¡¡ERROR!! " + p.getNombre() + " ya pertenece a la fraternidad "
                    + p.getFraternidad().getNombre());
            return;
        }

        bailarines.add(p);
        p.setFraternidad(this);
        System.out.println(p.getNombre() + " agregado a fraternidad " + nombre);
    }

    @Override
    public String toString() {
        return "Fraternidad: " + nombre + ", Encargado: " + encargado.getNombre();
    }
}
