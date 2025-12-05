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
class Participante extends Persona {

    private Facultad facultad;
    private Fraternidad fraternidad;

    public Participante(String nombre, int edad, String ci, Facultad f) {
        super(nombre, edad, ci);
        this.facultad = f;
    }

    public Facultad getFacultad() {
        return facultad;
    }

    public Fraternidad getFraternidad() {
        return fraternidad;
    }

    public void setFraternidad(Fraternidad f) {
        this.fraternidad = f;
    }

    @Override
    public String toString() {
        return super.toString()
                + " | Facultad: " + facultad.getNombre()
                + " | Fraternidad: " + (fraternidad != null ? fraternidad.getNombre() : "Ninguna");
    }
}
