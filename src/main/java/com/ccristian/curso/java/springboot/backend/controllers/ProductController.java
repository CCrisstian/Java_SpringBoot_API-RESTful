package com.ccristian.curso.java.springboot.backend.controllers;

import com.ccristian.curso.java.springboot.backend.entities.Product;
import com.ccristian.curso.java.springboot.backend.services.ProductService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin({"http://localhost:5173", "http://localhost:4200"}) /*React (puerto 5173) o Angular (puerto 4200).*/
public class ProductController {

    final private ProductService service;

    public ProductController(ProductService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<Product>> list() {
        return ResponseEntity.ok(service.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Product> details(@PathVariable Long id) {

        Optional<Product> optionalProduct = service.findById(id);

        if (optionalProduct.isPresent()) {
            return ResponseEntity.ok(optionalProduct.orElseThrow());
        }

        return ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<Product> create(@RequestBody Product product) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.save(product));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Product> update(@RequestBody Product product, @PathVariable Long id) {

        Optional<Product> productOptional = service.findById(id);

        if (productOptional.isPresent()) {
            productOptional.get().setName(product.getName());
            productOptional.get().setPrice(product.getPrice());
            productOptional.get().setDescription(product.getDescription());

            return ResponseEntity.status(HttpStatus.CREATED).body(service.save(productOptional.get()));
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Product> delete(@PathVariable Long id) {

        Optional<Product> optionalProduct = service.deleteById(id);

        if (optionalProduct.isPresent()) {
            Product productDeleted = optionalProduct.orElseThrow();
            return ResponseEntity.status(HttpStatus.OK).body(productDeleted);
        }

        return ResponseEntity.notFound().build();
    }

}
