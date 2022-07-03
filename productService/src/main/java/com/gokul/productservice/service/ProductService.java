package com.gokul.productservice.service;


import com.gokul.productservice.dto.ProductRequest;
import com.gokul.productservice.dto.ProductResponse;
import com.gokul.productservice.model.Product;
import com.gokul.productservice.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;

    public void createProduct(ProductRequest productRequest){
        Product product=Product.builder()
                .name(productRequest.getName())
                .description(productRequest.getDescription())
                .price(productRequest.getPrice())
                .build();

        productRepository.save(product);
    }


    public List<ProductResponse> getProducts() {
        List<Product>productList=productRepository.findAll();

        List<ProductResponse>productResponseList=productList.stream().map(product -> mapToProductResponse(product)).collect(Collectors.toList());
        return productResponseList;
    }

    private ProductResponse mapToProductResponse(Product product) {
        return ProductResponse.builder()
                .id(product.getId())
                .name(product.getName())
                .description(product.getDescription())
                .price(product.getPrice())
                .build();
    }
}
