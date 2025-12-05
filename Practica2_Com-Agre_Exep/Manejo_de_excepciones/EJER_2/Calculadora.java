/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.manejo_de_exepciones;

/**
 *
 * @author HP-RYZEN 5
 */
//Nicol Yanina Ticona Aduviri
//CI: 6786427
public class Calculadora {

    public static int sumar(int a, int b) {
        return a + b;
    }

    public static int restar(int a, int b) {
        return a - b;
    }

    public static int multiplicar(int a, int b) {
        return a * b;
    }

    public static double dividir(int a, int b) {
        if (b == 0) {
            throw new ArithmeticException("Error: división entre cero");
        }
        return (double) a / b;
    }

    public static int convertirAEntero(String valor) throws NumeroInvalidoException {

        if (valor == null || valor.trim().isEmpty()) {
            throw new NumeroInvalidoException("Valor inválido: '" + valor + "'");
        }

        try {
            return Integer.parseInt(valor.trim());
        } catch (NumberFormatException e) {
            throw new NumeroInvalidoException("Valor inválido: '" + valor + "' no es un número entero.");
        }
    }
}
