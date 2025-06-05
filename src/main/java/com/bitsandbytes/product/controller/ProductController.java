package com.bitsandbytes.product.controller;

import com.bitsandbytes.product.dto.ProductDTO;
import com.bitsandbytes.product.service.ProductService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(
        name = "Product REST API CRUD operation",
        description = "CREATE, READ, UPDATE and DELETE operations for Product REST API"
)
@RestController
@RequestMapping("/api/products")
@AllArgsConstructor
public class ProductController {

    private ProductService productService;

    @Operation(
            summary = "Fetch all products",
            description = "REST API to fetch all products"
    )

    @GetMapping
    public List<ProductDTO> getAllProducts() {
        return productService.getAllProducts();
    }

    @Operation(
            summary = "Fetch product by product Id",
            description = "REST API to fetch product by productId"
    )
    @GetMapping("/{id}")
    public ProductDTO getProductsById(@PathVariable Long id){
       return productService.getProductById(id);
    }

    @Operation(
            summary = "Create product",
            description = "REST API to create product"
    )
    @ApiResponse(
            responseCode = "201",
            description = "CREATED"
    )
    @PostMapping
    public ResponseEntity<ProductDTO> createProduct(@RequestBody ProductDTO productDTO){
       ProductDTO createdProduct =  productService.createProduct(productDTO);
           return new ResponseEntity<>(createdProduct, HttpStatus.CREATED);
            }

            @Operation(
                   summary = "Update product by productId",
                    description = "REST API to update product"
           )
       @PutMapping("/{id}")
       public ProductDTO updateProduct(@PathVariable Long id, @RequestBody ProductDTO productDTO) {
        return productService.updateProduct(id, productDTO);
       }

       @Operation(
               summary = "Delete product by productId",
               description = "REST API to delete product by productId"
       )
       @DeleteMapping("/{id}")
       public String deleteProduct(@PathVariable Long id) {
        return productService.deleteProduct(id);
       }
    }













