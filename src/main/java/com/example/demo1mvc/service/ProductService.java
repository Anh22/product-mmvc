package com.example.demo1mvc.service;

import com.example.demo1mvc.model.Product;

import java.util.ArrayList;
import java.util.List;

public class ProductService {
    List<Product>list;
    public ProductService(){
        this.list = new ArrayList<>();
        this.add(new Product(1,"a",100));
        this.add(new Product(1,"a",100));
        this.add(new Product(1,"a",100));
        this.add(new Product(1,"a",100));

    }
    public List<Product>fillAll(){
        return list;
    }
    public void add(Product a) {
        list.add(a);
    }

    public Product findById(int productId) {
        for (Product product : list) {
            if (product.getId() == productId) {
                return product;
            }
        }
        return null;
    }
}
