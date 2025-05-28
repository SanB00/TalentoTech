package org.preEntregaTT;

import java.util.ArrayList;
import java.util.List;

public class Pedido {

    private List<Producto> productos;
    private static int SIGUIENTE_ID = 1;
    private final int id;
    private String nombre;
    private double precio;
    private int stock;
    private int cantidadAComprar;

    public Pedido() {
        this.productos = new ArrayList<>();
        this.nombre = nombre;
        this.precio = precio;
        this.stock = stock;
        this.cantidadAComprar = 0;
        this.id = SIGUIENTE_ID;
        SIGUIENTE_ID++;
    }

    public void agregarProductoAPedido(Producto producto){
        this.productos.add(producto);
    }
    public void mostrarInfo() {
        System.out.println("#########################");
        System.out.printf("""
                Id: %s
                Nombre: %s
                Precio: %s
                Stock: %s
                """, this.id, this.nombre, this.precio, this.stock);
        System.out.println("#########################");
    }

    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }
}
