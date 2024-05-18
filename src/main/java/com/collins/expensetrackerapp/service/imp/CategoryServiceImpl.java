package com.collins.expensetrackerapp.service.imp;

import com.collins.expensetrackerapp.dto.CategoryDto;
import com.collins.expensetrackerapp.entity.Category;
import com.collins.expensetrackerapp.mapper.CategoryMapper;
import com.collins.expensetrackerapp.repository.CategoryRepository;
import com.collins.expensetrackerapp.service.CategoryService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class CategoryServiceImpl implements CategoryService {

    private CategoryRepository categoryRepository;

    @Override
    public CategoryDto createCategory(CategoryDto categoryDto){

        Category category = CategoryMapper.mapToCategory(categoryDto);
        Category savedCategory =  categoryRepository.save(category);

//        we can use this or the mapper
//        BeanUtils.copyProperties(savedCategory, categoryDto);

        return CategoryMapper.mapToCategoryDto(savedCategory);
    }
}
