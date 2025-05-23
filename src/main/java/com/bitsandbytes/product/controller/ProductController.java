package com.bitsandbytes.product.controller;

import com.bitsandbytes.product.dto.CategoryDTO;
import com.bitsandbytes.product.dto.ProductDTO;
import com.bitsandbytes.product.entity.Product;
import com.bitsandbytes.product.repository.ProductRepository;
import com.bitsandbytes.product.service.ProductService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/products")
@AllArgsConstructor
public class ProductController {

    private ProductService productService;

    @GetMapping
    public List<ProductDTO> getAllProducts() {
        return productService.getAllProducts();
    }
    @GetMapping("/{id}")
    public ProductDTO getProductsById(@PathVariable Long id){
       return productService.getProductById(id);
    }


    @PostMapping
    public ResponseEntity<ProductDTO> createProduct(@RequestBody ProductDTO productDTO){
       ProductDTO createdProduct =  productService.createProduct(productDTO);
           return new ResponseEntity<>(createdProduct, HttpStatus.CREATED);
            }
       @PutMapping("/{id}")
       public ProductDTO updateProduct(@PathVariable Long id, @RequestBody ProductDTO productDTO) {
        return productService.updateProduct(id, productDTO);
       }
       @DeleteMapping("/{id}")
       public String deleteProduct(@PathVariable Long id) {
        return productService.deleteProduct(id);
       }
    }













