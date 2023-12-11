package com.chris.learn.springcloud.productservice.controllers;

import com.chris.learn.springcloud.productservice.dto.CouponDto;
import com.chris.learn.springcloud.productservice.model.Product;
import com.chris.learn.springcloud.productservice.repository.ProductRepository;
import com.chris.learn.springcloud.productservice.restclients.CouponClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/products")
public class ProductRestController {

    @Autowired
    ProductRepository productRepository;

    @Autowired
    CouponClient couponClient;

    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody Product product) {
        CouponDto couponDto = couponClient.getCoupon(product.getCouponCode());
        product.setPrice(product.getPrice().subtract(couponDto.getDiscount()));
        return ResponseEntity.ok(productRepository.save(product));
    }

    @GetMapping("/{name}")
    public ResponseEntity<?> getProduct(@PathVariable("name") String name) {
        return ResponseEntity.ok(productRepository.findByName(name));
    }
}
