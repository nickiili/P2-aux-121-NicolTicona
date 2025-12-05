/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.composicion_agregacion;

import java.util.Scanner;

/**
 *
 * @author HP-RYZEN 5
 */
//Nicol Yanina Ticona Aduviri
//CI: 6786427
class Ropero {

    private String material;
    private Ropa[] prendas;
    private int nroRopas;

    public Ropero(String material) {
        this.material = material;
        this.prendas = new Ropa[20];
        this.nroRopas = 0;
    }

    // b) Agregar N prendas
    public void agregarN() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Cuántas prendas desea añadir? ");
        int n = sc.nextInt();
        sc.nextLine();

        for (int i = 0; i < n && nroRopas < 20; i++) {
            System.out.print("Tipo de la prenda: ");
            String tipo = sc.nextLine();

            System.out.print("Material de la prenda: ");
            String mat = sc.nextLine();

            prendas[nroRopas++] = new Ropa(tipo, mat);
        }
    }

    // c) Eliminar prendas de material X o tipo Y
    public void eliminar(String mat, String tipo) {
        for (int i = 0; i < nroRopas; i++) {
            if (prendas[i].getMaterial().equalsIgnoreCase(mat)
                    || prendas[i].getTipo().equalsIgnoreCase(tipo)) {

                // mover todo un lugar atrás
                for (int j = i; j < nroRopas - 1; j++) {
                    prendas[j] = prendas[j + 1];
                }
                nroRopas--;
                i--; // revisar nueva posición
            }
        }
    }

    // d) Mostrar prendas de material X *y* tipo Y
    public void mostrar(String mat, String tipo) {
        System.out.println("\nPrendas de material '" + mat
                + "' y tipo '" + tipo + "':");

        boolean found = false;

        for (int i = 0; i < nroRopas; i++) {
            if (prendas[i].getMaterial().equalsIgnoreCase(mat)
                    && prendas[i].getTipo().equalsIgnoreCase(tipo)) {

                System.out.println(prendas[i]);
                found = true;
            }
        }

        if (!found) {
            System.out.println("No existen prendas que coincidan.");
        }
    }

    // mostrar todas para verificar
    public void listarTodo() {
        System.out.println("\n--- Contenido actual del ropero ---");
        for (int i = 0; i < nroRopas; i++) {
            System.out.println(prendas[i]);
        }
    }
}
