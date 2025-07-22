package com.example.demo.service;

import com.example.demo.entity.Producto;
import com.example.demo.repository.ProductRepository;
import com.example.demo.repository.ProductoRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductService {
    private List<Producto> productoList;
    private ProductRepository repository;
    private ProductoRepository repositoryJPA;

    public ProductService() {}

    public ProductService(ProductRepository repository) {
        this.repository = repository;
    }
    public List<Producto> listarProductos(){
         return this.repositoryJPA.findAll();
     }
    /*
    public List<Producto> listarProducto(){
        return this.repository.obtenerTodosLosProductos();
    }
    */
    public ProductService(ProductRepository repository,ProductoRepository repositoryJPA){
        this.repository = repository;
        this.repositoryJPA = repositoryJPA;
        this.productoList = new ArrayList<>();
    }
    public Producto crearProducto(Producto producto){
        Producto productoGuardado = this.repositoryJPA.save(producto);
        return productoGuardado;
    }
}
