package com.ecommerce.service;

import java.util.List;

import com.ecommerce.entity.Product;

public interface ProductService {
    Product addProduct(Product product);
    void deleteProduct(int productId);
    Product updateProduct(int productId, Product product);
    Product searchProduct(int productId);
    List<Product> getAllProducts();
}
