package com.example.demo.controller;

import com.example.demo.entity.Producto;
import com.example.demo.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/producto")
public class ProductController {

    private ProductService service;

    @Autowired
    public ProductController(ProductService productService){
        this.service = productService;
    }

    @GetMapping("/listar")
    ResponseEntity<List<Producto>> listar(){
       return ResponseEntity.status(HttpStatus.NOT_FOUND).body(this.service.listarProductos());
    }
    @PostMapping("/crear")
    public ResponseEntity<Producto> crearProducto(@RequestBody Producto producto){
        return ResponseEntity.status(HttpStatus.CREATED).body(this.service.crearProducto(producto));
    }
}
