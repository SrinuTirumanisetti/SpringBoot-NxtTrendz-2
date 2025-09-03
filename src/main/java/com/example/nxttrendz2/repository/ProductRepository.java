package com.example.nxttrendz2.repository;

import com.example.nxttrendz2.model.Product;
import java.util.ArrayList;

public interface ProductRepository {
    ArrayList<Product> getAllProducts();
    Product createProduct(Product product);
    Product getProductById(int productId);
    Product updateProduct(int productId, Product product);
    void deleteProduct(int productId);
}
