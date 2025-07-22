package com.example.demo.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Producto {
     @Id
     @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String nombre;
    private double precio;
    private int stock;
    private int cantAComprar;
/*
    public Producto() {
    }

    public Producto(String nombre,double precio, Integer id, int stock){
        this.nombre = nombre;
        this.stock = stock;
        this.precio = precio;
        this.cantAComprar = 0;
    }
*/
    public void mostrarInfo(){
        System.out.println("======================");
            System.out.println("""
                Id:
                Nombre:
                Precio:
                """);
        System.out.println("======================");
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

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public int getCantAComprar() {
        return cantAComprar;
    }

    public void setCantAComprar(int cantAComprar) {
        this.cantAComprar = cantAComprar;
    }
}
