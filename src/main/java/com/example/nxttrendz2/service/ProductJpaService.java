package com.example.nxttrendz2.service;

import com.example.nxttrendz2.model.Category;
import com.example.nxttrendz2.model.Product;
import com.example.nxttrendz2.repository.ProductJpaRepository;
import com.example.nxttrendz2.repository.ProductRepository;
import com.example.nxttrendz2.repository.CategoryJpaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.*;

@Service
public class ProductJpaService implements ProductRepository {

    @Autowired
    private ProductJpaRepository productJpaRepository;

    @Autowired
    private CategoryJpaRepository categoryJpaRepository;

    @Override
    public List<Product> getProducts() {
        return productJpaRepository.findAll();
    }

    @Override
    public Product addProduct(Product product) {
        Category category = categoryJpaRepository.findById(product.getCategory().getId())
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
        product.setCategory(category);
        return productJpaRepository.save(product);
    }

    @Override
    public Product getProductById(int productId) {
        return productJpaRepository.findById(productId)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    @Override
    public Product updateProduct(int productId, Product product) {
        Product existing = getProductById(productId);
        existing.setName(product.getName());
        existing.setDescription(product.getDescription());
        existing.setPrice(product.getPrice());
        if (product.getCategory() != null) {
            Category category = categoryJpaRepository.findById(product.getCategory().getId())
                    .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
            existing.setCategory(category);
        }
        return productJpaRepository.save(existing);
    }

    @Override
    public void deleteProduct(int productId) {
        Product existing = getProductById(productId);
        productJpaRepository.delete(existing);
        throw new ResponseStatusException(HttpStatus.NO_CONTENT);
    }

    @Override
    public Object getCategoryByProductId(int productId) {
        Product product = getProductById(productId);
        return product.getCategory();
    }
}
 