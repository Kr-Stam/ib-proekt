package com.example.ibproekt.service;

import com.example.ibproekt.entity.Product;

import java.util.List;

public interface ProductService {

    List<Product> getAllProducts();

    void deleteProductById(long id);

    Product saveProduct(Product product);
}
