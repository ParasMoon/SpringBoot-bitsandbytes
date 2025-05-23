package com.bitsandbytes.product.service;


import com.bitsandbytes.product.dto.ProductDTO;
import com.bitsandbytes.product.entity.Product;
import com.bitsandbytes.product.mapper.CategoryMapper;
import com.bitsandbytes.product.mapper.ProductMapper;
import com.bitsandbytes.product.repository.CategoryRepository;
import com.bitsandbytes.product.repository.ProductRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import com.bitsandbytes.product.entity.Category;

@Service
@AllArgsConstructor
public class ProductService {

    @Autowired
    private ProductRepository productRepository;
    private CategoryRepository categoryRepository;


    public ProductDTO createProduct(ProductDTO productDTO) {
        Category category = categoryRepository.findById(productDTO.getCategoryId())
                .orElseThrow(() -> new RuntimeException("Category not found!"));

        Product product = ProductMapper.toProductEntity(productDTO, category);
        product = productRepository.save(product);

        return ProductMapper.toProductDTO(product);
    }

    public List<ProductDTO> getAllProducts() {
        return productRepository.findAll().stream().map(ProductMapper::toProductDTO).toList();
    }

    public ProductDTO getProductById(Long id) {
        Product product = productRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Product not found!"));
        return ProductMapper.toProductDTO(product);
    }

    public ProductDTO updateProduct(Long id, ProductDTO productDTO) {

        Product product = productRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Product not found!"));
          Category category =  categoryRepository.findById(productDTO.getCategoryId())
                   .orElseThrow(()-> new RuntimeException("Category not found!"));

          product.setName(productDTO.getName());
          product.setDescription(productDTO.getDescription());
          product.setPrice(productDTO.getPrice());
          product.setCategory(category);
          productRepository.save(product);
          return ProductMapper.toProductDTO(product);
    }
     public String deleteProduct(Long id) {
        productRepository.deleteById(id);
        return "Product" + id + "has been deleted";
     }
}