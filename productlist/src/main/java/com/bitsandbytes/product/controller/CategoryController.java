package com.bitsandbytes.product.controller;


import com.bitsandbytes.product.dto.CategoryDTO;
import com.bitsandbytes.product.service.CategoryService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/categories")
@AllArgsConstructor
public class CategoryController {

    private CategoryService categoryService;

    @GetMapping
    public List<CategoryDTO> getAllCategories() {
     return categoryService.getAllCategories();
    }

    @PostMapping
    public ResponseEntity<CategoryDTO> createCategory(@RequestBody CategoryDTO categoryDTO) {
        return new ResponseEntity<>(categoryService.createCategory(categoryDTO), HttpStatus.CREATED);
            }
     @GetMapping("/{id}")
    public CategoryDTO getCategoryById(@PathVariable Long id){
      return categoryService.getCategoryById(id);
     }
      @DeleteMapping("/{id}")
      public String deleteCategory(@PathVariable Long id) {
       return categoryService.deleteCategory(id);
      }
        }

