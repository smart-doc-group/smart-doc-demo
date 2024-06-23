package com.smartdoc.example.controller;

import com.smartdoc.example.exception.ResourceNotFoundException;
import com.smartdoc.example.model.Product;
import com.smartdoc.example.repository.ProductRepository;
import com.smartdoc.example.response.ResponseResult;
import org.springframework.web.bind.annotation.*;


import java.util.List;

import jakarta.annotation.Resource;
import jakarta.validation.Valid;

/**
 * The type Product controller.
 * @author yu 2021/7/24.
 */
@RestController
@RequestMapping("/api/v1")
public class ProductController {
    @Resource
    private ProductRepository productRepository;

    /**
     * Create Product.
     *
     * @param product the Product
     * @return The Product
     */
    @PostMapping("/products")
    public ResponseResult<Product> createProduct(@Valid @RequestBody Product product) {
        productRepository.add(product);
        return ResponseResult.ok().setResultData(product);
    }

    /**
     * Get all Products list.
     *
     * @return the list
     */
    @GetMapping("/products")
    public ResponseResult<List<Product>> getAllProducts() {
        return ResponseResult.ok().setResultData(productRepository.getProducts());
    }

    /**
     * Gets Products by id.
     *
     * @param productId the Product id|1
     * @return the Products by id
     */
    @GetMapping("/products/{id}")
    public ResponseResult<Product> getProductsById(@PathVariable(value = "id") Long productId) {
        Product Product = productRepository.findById(productId).
                orElseThrow(() -> new ResourceNotFoundException("Product not found on :: " + productId));
        return ResponseResult.ok().setResultData(Product);
    }


    /**
     * Update Product response entity.
     *
     * @param productId      the Product id|1
     * @param productDetails the Product details
     * @return the response entity
     */
    @PutMapping("/products/{id}")
    public ResponseResult<Product> updateProduct(@PathVariable(value = "id") Long productId, @Valid @RequestBody Product productDetails) {
        Product product = productRepository.findById(productId).
                orElseThrow(() -> new ResourceNotFoundException("Product not found on :: " + productId));
        product.setId(productId);
        product.setName(productDetails.getName());
        product.setPrice(productDetails.getPrice());
        product.setPictureUrl(productDetails.getPictureUrl());
        productRepository.add(product);
        return ResponseResult.ok().setResultData(product);
    }

    /**
     * Delete Product.
     *
     * @param productId the Product id|1
     * @return the map
     */
    @DeleteMapping("/products/{id}")
    public ResponseResult<Boolean> deleteProduct(@PathVariable(value = "id") Long productId) {
        Product product = productRepository.findById(productId).
                orElseThrow(() -> new ResourceNotFoundException("Product not found on :: " + productId));
        return ResponseResult.ok().setResultData(productRepository.delete(product));
    }
}
