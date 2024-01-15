package com.example.demo1mvc.reposity;

import com.example.demo1mvc.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductReposity extends JpaRepository<Product, Integer> {
    List<Product>findByNameContainingIgnoreCase(String name);
}
