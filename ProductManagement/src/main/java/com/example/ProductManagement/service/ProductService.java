package com.example.ProductManagement.service;

import com.example.ProductManagement.model.Product;
import com.example.ProductManagement.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
    @Autowired
    private ProductRepository productRepository;

    public List<Product> listAll () {
        return productRepository.findAll();
    }

    public void save(Product product) {
        productRepository.save(product);
    }

    public Product get(Long id) {
        return productRepository.findById(id).get();
    }
    public void delete (Long id) {
        productRepository.deleteById(id);
    }
}
