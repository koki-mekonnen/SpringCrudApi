package com.example.demo.service;

import com.example.demo.model.Products;
import com.example.demo.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public List<Products> getAllProducts() {
        return productRepository.findAll();
    }

    public Optional<Products> getProductById(Long id) {
        return productRepository.findById(id);
    }

    public Products createProduct(Products product) {
        return productRepository.save(product);
    }

    public Products updateProduct(Long id, Products productDetails) {
        Products product = productRepository.findById(id).orElseThrow(() -> new RuntimeException("Products not found"));
        product.setName(productDetails.getName());
        product.setPrice(productDetails.getPrice());
        return productRepository.save(product);
    }

    public void deleteProduct(Long id) {
        Products product = productRepository.findById(id).orElseThrow(() -> new RuntimeException("Products not found"));
        productRepository.delete(product);
    }
}