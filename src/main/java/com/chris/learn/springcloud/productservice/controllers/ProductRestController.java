package com.chris.learn.springcloud.productservice.controllers;

import com.chris.learn.springcloud.productservice.model.Product;
import com.chris.learn.springcloud.productservice.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/products")
public class ProductRestController {

    @Autowired
    ProductRepository productRepository;

    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody Product product) {
        return ResponseEntity.ok(productRepository.save(product));
    }

    @GetMapping("/{name}")
    public ResponseEntity<?> getProduct(@PathVariable("name") String name) {
        return ResponseEntity.ok(productRepository.findByName(name));
    }
}
