package com.collins.expensetrackerapp.service.imp;

import com.collins.expensetrackerapp.dto.CategoryDto;
import com.collins.expensetrackerapp.entity.Category;
import com.collins.expensetrackerapp.exception.ResourceNotFoundException;
import com.collins.expensetrackerapp.mapper.CategoryMapper;
import com.collins.expensetrackerapp.repository.CategoryRepository;
import com.collins.expensetrackerapp.service.CategoryService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@Service
public class CategoryServiceImpl implements CategoryService {

    private CategoryRepository categoryRepository;

    @Override
    public CategoryDto createCategory(CategoryDto categoryDto){

        Category existingCategory = categoryRepository.findCategoriesByName(categoryDto.name());
        if (existingCategory != null){
            throw new ResourceNotFoundException("category " + existingCategory.getName() + " already exist!");
        }

        Category category = CategoryMapper.mapToCategory(categoryDto);
        Category savedCategory =  categoryRepository.save(category);

//        we can use this or the mapper
//        BeanUtils.copyProperties(savedCategory, categoryDto);

        return CategoryMapper.mapToCategoryDto(savedCategory);
    }

    @Override
    public CategoryDto findById(Long categoryId){
        Category category = categoryRepository.findById(categoryId).
                orElseThrow(() -> new ResourceNotFoundException("Category does not found with id:" + categoryId));
        return  CategoryMapper.mapToCategoryDto(category);
    }

    @Override
    public List<CategoryDto> getAllCategories(){
       return categoryRepository.findAll().stream().map(CategoryMapper::mapToCategoryDto).collect(Collectors.toList());
    }

    @Override
    public CategoryDto updateCategory(Long categoryId, CategoryDto categoryDto){
        CategoryDto retrievedCategory = this.findById(categoryId);

        Category category = CategoryMapper.mapToCategory(retrievedCategory);
        category.setName(categoryDto.name());
        return CategoryMapper.mapToCategoryDto(categoryRepository.save(category));
    }

    @Override
    public void deleteCategory(Long categoryId){
        this.findById(categoryId);
        categoryRepository.deleteById(categoryId);
    }
}
