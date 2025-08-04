package com.example.demo.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductDTO {
    private Integer id;

    private String nombre;
    private double precio;
    private int stock;
    private int cantAComprar;
}
