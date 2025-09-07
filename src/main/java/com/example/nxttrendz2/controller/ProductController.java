package com.example.nxttrendz2.controller;

import com.example.nxttrendz2.model.Product;
import com.example.nxttrendz2.service.ProductJpaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.*;

@RestController
public class ProductController {

    @Autowired
    private ProductJpaService productJpaService;

    @GetMapping("/categories/products")
    public List<Product> getProducts() {
        return productJpaService.getProducts();
    }

    @PostMapping("/categories/products")
    public Product addProduct(@RequestBody Product product) {
        return productJpaService.addProduct(product);
    }

    @GetMapping("/categories/products/{productId}")
    public Product getProductById(@PathVariable int productId) {
        return productJpaService.getProductById(productId);
    }

    @PutMapping("/categories/products/{productId}")
    public Product updateProduct(@PathVariable int productId, @RequestBody Product product) {
        return productJpaService.updateProduct(productId, product);
    }

    @DeleteMapping("/categories/products/{productId}")
    public void deleteProduct(@PathVariable int productId) {
        productJpaService.deleteProduct(productId);
    }

    @GetMapping("/products/{productId}/category")
    public Object getCategoryByProductId(@PathVariable int productId) {
        return productJpaService.getCategoryByProductId(productId);
    }
}
