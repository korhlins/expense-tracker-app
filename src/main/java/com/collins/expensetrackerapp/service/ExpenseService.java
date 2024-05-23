package com.collins.expensetrackerapp.service;


import com.collins.expensetrackerapp.dto.ExpenseDto;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


public interface ExpenseService {
    public ExpenseDto createExpense(ExpenseDto expenseDto);

    ExpenseDto findById(Long expenseId);

    List<ExpenseDto> getAllExpense();

    @Transactional
    ExpenseDto updateExpense(Long expenseId, ExpenseDto expenseDto);

    void deleteExpense(Long expenseId);
}
