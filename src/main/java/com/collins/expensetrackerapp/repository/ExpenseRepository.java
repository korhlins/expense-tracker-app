package com.collins.expensetrackerapp.repository;

import com.collins.expensetrackerapp.entity.Expense;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ExpenseRepository extends JpaRepository<Expense, Long> {
}
