package com.collins.expensetrackerapp.controller;

import com.collins.expensetrackerapp.dto.CategoryDto;
import com.collins.expensetrackerapp.service.imp.CategoryServiceImpl;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@AllArgsConstructor
@RestController
@RequestMapping("/api/categories")
public class CategoryController {

    private CategoryServiceImpl categoryService;

    @PostMapping("/create")
    public ResponseEntity<CategoryDto> createCategory(@RequestBody CategoryDto categoryDto){
       CategoryDto createdCategory = categoryService.createCategory(categoryDto);
       return new ResponseEntity<>(createdCategory, HttpStatus.CREATED);
    }
}
