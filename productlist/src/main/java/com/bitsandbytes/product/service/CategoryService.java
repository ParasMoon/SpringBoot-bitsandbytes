package com.bitsandbytes.product.service;


import com.bitsandbytes.product.dto.CategoryDTO;
import com.bitsandbytes.product.entity.Category;
import com.bitsandbytes.product.mapper.CategoryMapper;
import com.bitsandbytes.product.repository.CategoryRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class CategoryService {

    private CategoryRepository categoryRepository;

    public CategoryDTO createCategory(CategoryDTO categoryDTO) {
      Category category = CategoryMapper.toCategoryEntity(categoryDTO);
      category = categoryRepository.save(category);
      return CategoryMapper.toCategoryDTO(category);
    }
        public List<CategoryDTO> getAllCategories() {
            return categoryRepository.findAll().stream().map(CategoryMapper::toCategoryDTO).toList();
        }
        public CategoryDTO getCategoryById(Long id) {
       Category category =  categoryRepository.findById(id).orElseThrow(()-> new RuntimeException("Category not found"));
       return CategoryMapper.toCategoryDTO(category);
    }
      public String deleteCategory(Long id) {
        categoryRepository.deleteById(id);
        return "Category "+ id +"has been deleted";
      }
}


