package com.gokul.productservice.controller;


import com.gokul.productservice.dto.ProductRequest;
import com.gokul.productservice.dto.ProductResponse;
import com.gokul.productservice.model.Product;
import com.gokul.productservice.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/product")
public class ProductController {

    private final ProductService productService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void createProduct(@RequestBody ProductRequest productRequest){
        productService.createProduct(productRequest);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<ProductResponse>getProduct(){
        return productService.getProducts();
    }
}
