package com.ccristian.curso.java.springboot.backend.services;

import com.ccristian.curso.java.springboot.backend.entities.Product;
import com.ccristian.curso.java.springboot.backend.repositories.ProductRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService {

    final private ProductRepository repository;

    public ProductServiceImpl(ProductRepository repository) {
        this.repository = repository;
    }

    @Transactional(readOnly = true)
    @Override
    public List<Product> findAll() {
        return (List<Product>) repository.findAll();
    }

    @Transactional(readOnly = true)
    @Override
    public Optional<Product> findById(Long id) {
        return repository.findById(id);
    }

    @Transactional
    @Override
    public Product save(Product product) {
        return repository.save(product);
    }

    @Transactional
    @Override
    public Optional<Product> deleteById(Long id) {

        Optional<Product> productOptional = repository.findById(id);

        if (productOptional.isPresent()) {
            repository.deleteById(id);
            return productOptional;
        }

        return Optional.empty();
    }
}
