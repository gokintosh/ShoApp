package com.gokul.productservice.controller;


import com.gokul.productservice.dto.ProductRequest;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/product")
public class ProductController {

    @PostMapping
    public void createProduct(@RequestBody ProductRequest productRequest){

    }
}
