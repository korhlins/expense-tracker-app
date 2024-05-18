package com.collins.expensetrackerapp.mapper;

import com.collins.expensetrackerapp.dto.CategoryDto;
import com.collins.expensetrackerapp.entity.Category;

public class CategoryMapper {

    public static Category mapToCategory(CategoryDto categoryDto){
        return new Category(categoryDto.id(), categoryDto.name());
    }

    public static CategoryDto mapToCategoryDto(Category category){
        return new CategoryDto(category.getId(), category.getName());
    }
}
