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
public class Inventario {

    private Producto[] productos;
    private int cant;

    public Inventario(int size) {
        productos = new Producto[size];
        cant = 0;
    }

    // c) Agregar producto con validaciones
    public void agregarProducto(Producto p)
            throws CodigoDuplicadoException {

        for (int i = 0; i < cant; i++) {
            if (productos[i].getCodigo().equals(p.getCodigo())) {
                throw new CodigoDuplicadoException("El código ya existe: " + p.getCodigo());
            }
        }

        if (p.getPrecio() < 0 || p.getStock() < 0) {
            throw new IllegalArgumentException("Precio o stock no pueden ser negativos");
        }

        productos[cant++] = p;
    }

    // d) Buscar producto
    public Producto buscarProducto(String codigo)
            throws ProductoNoEncontradoException {

        for (int i = 0; i < cant; i++) {
            if (productos[i].getCodigo().equals(codigo)) {
                return productos[i];
            }
        }

        throw new ProductoNoEncontradoException("No existe el producto con código: " + codigo);
    }

    // e) Vender producto
    public void venderProducto(String codigo, int cantidad)
            throws ProductoNoEncontradoException, StockInsuficienteException {

        Producto p = buscarProducto(codigo);

        if (p.getStock() < cantidad) {
            throw new StockInsuficienteException("Stock insuficiente para vender " + cantidad);
        }

        p.setStock(p.getStock() - cantidad);
        System.out.println("Venta realizada. Nuevo stock: " + p.getStock());
    }

    public void mostrarInventario() {
        for (int i = 0; i < cant; i++) {
            System.out.println(productos[i]);
        }
    }
}
