package com.example.demo.controller;

import com.example.demo.entity.Producto;
import com.example.demo.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
    List<Producto> listar(){
       return this.service.listar();
    }

    @GetMapping("/{id}")
    ResponseEntity<Producto> buscarPorId(@PathVariable Integer id){
       return ResponseEntity.status(HttpStatus.NO_CONTENT).body(this.service.buscarPorId(id));
    }

    @PostMapping("/")
    public ResponseEntity<Producto> crear(@RequestBody Producto producto){
        return ResponseEntity.status(HttpStatus.CREATED).body(this.service.crear(producto));
    }

    @PutMapping("/")
    public ResponseEntity<Producto> editar(@RequestBody Producto producto){
         Integer id = producto.getId();
        return ResponseEntity.status(HttpStatus.CREATED).body(this.service.editar(id, producto));
    }

    @DeleteMapping("/{id}")
    ResponseEntity<Producto> eliminar(@PathVariable Integer id){
       return ResponseEntity.status(HttpStatus.NO_CONTENT).body(this.service.eliminar(id));
    }

}
