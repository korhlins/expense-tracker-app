package com.collins.expensetrackerapp.service.imp;


import com.collins.expensetrackerapp.dto.ExpenseDto;
import com.collins.expensetrackerapp.entity.Category;
import com.collins.expensetrackerapp.entity.Expense;
import com.collins.expensetrackerapp.mapper.ExpenseMapper;
import com.collins.expensetrackerapp.repository.CategoryRepository;
import com.collins.expensetrackerapp.repository.ExpenseRepository;
import com.collins.expensetrackerapp.service.ExpenseService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;


@AllArgsConstructor
@Service
public class ExpenseServiceImp implements ExpenseService {


    private ExpenseRepository expenseRepository;

    private CategoryRepository categoryRepository;

    @Override
    public ExpenseDto createExpense(ExpenseDto expenseDto) {

        Expense expense = ExpenseMapper.mapToExpense(expenseDto);

        Expense savedExpense = expenseRepository.save(expense);

       return ExpenseMapper.mapToExpenseDto(savedExpense);
    }

    @Transactional
    @Override
    public ExpenseDto findById(Long expenseId){

       Expense expense = expenseRepository.findById(expenseId).orElseThrow(() -> new RuntimeException("Expense was not found:" + expenseId));

        return ExpenseMapper.mapToExpenseDto(expense);
    }

    @Override
    public List<ExpenseDto> getAllExpense(){
       return expenseRepository.findAll()
                .stream().map(ExpenseMapper::mapToExpenseDto).collect(Collectors.toList());
    }

    @Transactional
    @Override
    public ExpenseDto updateExpense(Long expenseId, ExpenseDto expenseDto){
        ExpenseDto retrievedExpense = this.findById(expenseId);

        Category category = categoryRepository.findById(expenseDto.categoryDto().id())
                .orElseThrow(() -> new RuntimeException("Category not found with Id:" + expenseDto.categoryDto().id()));

        Expense expense = ExpenseMapper.mapToExpense(retrievedExpense);
        expense.setAmount(expenseDto.amount());
        expense.setExpenseDate(expenseDto.expenseDate());
        expense.setCategory(category);

        return ExpenseMapper.mapToExpenseDto(expenseRepository.save(expense));
    }

    @Transactional
    @Override
    public void deleteExpense(Long expenseId){
        this.findById(expenseId);
        expenseRepository.deleteById(expenseId);
    }
}
