package com.example.demo.repository;

import com.example.demo.entity.Producto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
// define como tiene que comportarse el codigo
public interface ProductoRepository extends JpaRepository<Producto, Integer> {

}
