package com.collins.expensetrackerapp.repository;

import com.collins.expensetrackerapp.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {
}
