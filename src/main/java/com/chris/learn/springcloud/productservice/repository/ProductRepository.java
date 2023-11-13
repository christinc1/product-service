package com.chris.learn.springcloud.productservice.repository;

import com.chris.learn.springcloud.productservice.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {

    Product findByName(String name);
}
