package com.example.nxttrendz2.repository;

import com.example.nxttrendz2.model.Product;
import java.util.*;

public interface ProductRepository {
    List<Product> getProducts();
    Product addProduct(Product product);
    Product getProductById(int productId);
    Product updateProduct(int productId, Product product);
    void deleteProduct(int productId);
    Object getCategoryByProductId(int productId);
}
