package com.example.demo.repository;
import java.util.ArrayList;
import java.util.List;
import com.example.demo.entity.Producto;
import org.springframework.stereotype.Repository;

@Repository
public class ProductRepository {
     private final  ArrayList<Producto> productoList;

     public ProductRepository(){
         this.productoList = new ArrayList<>();
     }



    public List<Producto> obtenerTodosLosProductos(){
        return this.productoList;
    }

    public String agregarProducto(Producto producto){
         productoList.add(producto);
         return "Producto agregado exitosamente. Id:" + producto.getId();
    }
}
