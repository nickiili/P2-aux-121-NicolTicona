/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.mycompany.manejo_de_exepciones;

/**
 *
 * @author HP-RYZEN 5
 */
//Nicol Yanina Ticona Aduviri
//CI: 6786427
public class Manejo_de_exepciones {

    public static void main(String[] args) {
        System.out.println("=== PRUEBA DE CALCULADORA ===\n");

        try {
            System.out.println("Suma 5 + 3 = " + Calculadora.sumar(5, 3));
            System.out.println("Resta 10 - 4 = " + Calculadora.restar(10, 4));
            System.out.println("Multiplicación 6 * 7 = " + Calculadora.multiplicar(6, 7));
            System.out.println("División 20 / 5 = " + Calculadora.dividir(20, 5));
        } catch (Exception e) {
            System.out.println("Error en operación válida: " + e.getMessage());
        }

        System.out.println("\n--- Pruebas con errores ---\n");

        try {
            System.out.println("División 10 / 0 = " + Calculadora.dividir(10, 0));
        } catch (ArithmeticException e) {
            System.out.println("Excepción capturada: " + e.getMessage());
        }

        String[] pruebas = {"abc", "12.3", "", "   ", null, "123"};

        for (String valor : pruebas) {
            try {
                int num = Calculadora.convertirAEntero(valor);
                System.out.println("Conversión exitosa: " + valor + " -> " + num);
            } catch (NumeroInvalidoException e) {
                System.out.println("Excepción personalizada capturada: " + e.getMessage());
            }
        }

        System.out.println("---------------------------------");
        Inventario inv = new Inventario(10);

        try {
            inv.agregarProducto(new Producto("A1", "Laptop", 5000, 10));
            inv.agregarProducto(new Producto("B2", "Mouse", 50, 40));

            inv.mostrarInventario();

            System.out.println("\nBuscando B2:");
            System.out.println(inv.buscarProducto("B2"));

            inv.venderProducto("A1", 5);

        } catch (Exception e) {
            System.out.println("ERROR: " + e.getMessage());
        }

        System.out.println("---------------------------------------------*");
        CuentaBancaria cuenta = new CuentaBancaria("12345", "Juan Pérez", 1000);

        cuenta.mostrarInfo();

        try {
            cuenta.depositar(500);
        } catch (IllegalArgumentException e) {
            System.out.println("Error en depósito: " + e.getMessage());
        }

        try {
            cuenta.depositar(-200);
        } catch (IllegalArgumentException e) {
            System.out.println("Error en depósito: " + e.getMessage());
        }

        try {
            cuenta.retirar(300);
        } catch (FondosInsuficientesException e) {
            System.out.println("Error en retiro: " + e.getMessage());
        }

        try {
            cuenta.retirar(2000);
        } catch (FondosInsuficientesException e) {
            System.out.println("Error en retiro: " + e.getMessage());
        }

        cuenta.mostrarInfo();

    }

}
