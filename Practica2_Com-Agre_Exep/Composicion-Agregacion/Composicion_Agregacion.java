/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.mycompany.composicion_agregacion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

/**
 *
 * @author HP-RYZEN 5
 */
//Nicol Yanina Ticona Aduviri
//CI: 6786427
public class Composicion_Agregacion {

    public static void main(String[] args) {
        // a) Instanciar 2 departamentos
        Departamento d1 = new Departamento("Sistemas", "TI", 10);
        Departamento d2 = new Departamento("Administración", "Finanzas", 10);

        // d1 con 5 empleados
        Empleado e1 = new Empleado("Luis", "Analista", 3000);
        Empleado e2 = new Empleado("Ana", "Programadora", 3500);
        Empleado e3 = new Empleado("José", "Soporte", 2800);
        Empleado e4 = new Empleado("María", "Tester", 2900);
        Empleado e5 = new Empleado("Carlos", "DevOps", 4000);

        d1.agregarEmpleado(e1);
        d1.agregarEmpleado(e2);
        d1.agregarEmpleado(e3);
        d1.agregarEmpleado(e4);
        d1.agregarEmpleado(e5);

        // d2 sin empleados
        System.out.println("=== Departamento 1 ===");
        d1.mostrarEmpleados();
        System.out.println("\n=== Departamento 2 ===");
        d2.mostrarEmpleados();

        // b) mostrarEmpleados() ya implementado arriba
        // c) cambioSalario() a todos los empleados de d1
        d1.cambioSalario(5000);
        System.out.println("\n=== Sueldos actualizados en D1 ===");
        d1.mostrarEmpleados();

        // d) verificar si un empleado de d1 pertenece a d2
        System.out.println("\n¿Ana pertenece al d2?: " + d2.contieneEmpleado(e2));

        // e) mover empleados del d1 al d2
        d1.moverEmpleadosA(d2);

        System.out.println("\n=== Después de mover empleados ===");
        System.out.println("D1:");
        d1.mostrarEmpleados();

        System.out.println("\nD2:");
        d2.mostrarEmpleados();

        System.out.println("---------------------------------------------");
        Ropero r = new Ropero("Madera");

        System.out.println("=== Añadiendo prendas ===");
        r.agregarN();

        r.listarTodo();

        System.out.println("\n=== Eliminando ropa de material 'cuero' o tipo 'pantalón' ===");
        r.eliminar("cuero", "pantalón");
        r.listarTodo();

        System.out.println("\n=== Mostrando prendas tipo 'camisa' y material 'algodón' ===");
        r.mostrar("algodón", "camisa");

        System.out.println("---------------------------------------------");
        // 2 facultades
        Facultad f1 = new Facultad("Ingeniería");
        Facultad f2 = new Facultad("Derecho");

        // Encargados
        Persona enc1 = new Persona("Carlos Encargado", 40, "9001");
        Persona enc2 = new Persona("Martha Encargada", 38, "9002");

        // 2 fraternidades
        Fraternidad frat1 = new Fraternidad("Fraternidad Salay", enc1);
        Fraternidad frat2 = new Fraternidad("Fraternidad Caporales", enc2);

        // 5 participantes
        Participante p1 = new Participante("Ana", 20, "1111", f1);
        Participante p2 = new Participante("Luis", 22, "2222", f1);
        Participante p3 = new Participante("Maria", 21, "3333", f2);
        Participante p4 = new Participante("Pedro", 25, "4444", f2);
        Participante p5 = new Participante("Jose", 23, "5555", f1);

        // Registrar participantes en fraternidades
        frat1.agregarParticipante(p1);
        frat1.agregarParticipante(p2);

        frat2.agregarParticipante(p3);
        frat2.agregarParticipante(p4);

        // Intentar meter a alguien en 2 fraternidades
        frat2.agregarParticipante(p1); // ERROR

        // Mostrar datos
        System.out.println("\n=== Listado de participantes ===");
        ArrayList<Participante> todos = new ArrayList<>(Arrays.asList(p1, p2, p3, p4, p5));
        todos.forEach(System.out::println);

        System.out.println("\n=== Miembros de cada fraternidad ===");
        System.out.println(frat1);
        frat1.getBailarines().forEach(x -> System.out.println(" - " + x.getNombre()));

        System.out.println("\n" + frat2);
        frat2.getBailarines().forEach(x -> System.out.println(" - " + x.getNombre()));

        System.out.println("----------------------------------------------");
        Doctor dd1 = new Doctor("Carlos Pérez", "Cardiología");
        Doctor dd2 = new Doctor("María López", "Pediatría");
        Doctor dd3 = new Doctor("Juan Ramos", "Neurología");

        // Crear hospitales
        Hospital h1 = new Hospital("Hospital Central");
        Hospital h2 = new Hospital("Clinica Los Andes");

        // Asignar doctores a hospitales
        h1.agregarDoctor(dd1);
        h1.agregarDoctor(dd2);

        h2.agregarDoctor(dd2);  // María trabaja en 2 hospitales
        h2.agregarDoctor(dd3);

        // Mostrar doctores en cada hospital
        h1.mostrarDoctores();
        h2.mostrarDoctores();
    }

}
