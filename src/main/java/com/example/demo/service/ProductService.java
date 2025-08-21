package com.example.demo.service;

import com.example.demo.entity.Producto;
import com.example.demo.repository.ProductoRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ProductService {
    private ProductoRepository repositoryJPA;

    //public ProductService() {}

    public ProductService(ProductoRepository repositoryJPA){
        this.repositoryJPA = repositoryJPA;
    }

    public List<Producto> listar(){
         return this.repositoryJPA.findAll();
     }

    public Producto crear(Producto producto){
        Producto productoGuardado = this.repositoryJPA.save(producto);
        return productoGuardado;
    }

    public Producto buscarPorId(Integer id){
        Optional<Producto> encontrado = this.repositoryJPA.findById(id);
        return encontrado.orElse(null);
    }

    public Producto editar(Integer id, Producto objProducto){
        Producto encontrado = this.buscarPorId(id);
        encontrado.setPrecio(objProducto.getPrecio());
        this.repositoryJPA.save(encontrado);
        return encontrado;
    }
    public Producto eliminar(Integer id){
        Producto encontrado = this.buscarPorId(id);
        this.repositoryJPA.delete(encontrado);
        return encontrado;
    }
}
