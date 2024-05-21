package com.collins.expensetrackerapp.mapper;

import com.collins.expensetrackerapp.dto.CategoryDto;
import com.collins.expensetrackerapp.dto.ExpenseDto;
import com.collins.expensetrackerapp.entity.Category;
import com.collins.expensetrackerapp.entity.Expense;

public class ExpenseMapper {

    public static ExpenseDto mapToExpenseDto(Expense expense){
        return new ExpenseDto(expense.getId(),
                expense.getAmount(),
                expense.getExpenseDate(),
                new CategoryDto(
                        expense.getCategory().getId(),
                        expense.getCategory().getName())
        );
    }

    public static Expense mapToExpense(ExpenseDto expenseDto){

        Category category = new Category();
        category.setId(expenseDto.categoryDto().id());
        category.setName(expenseDto.categoryDto().name());

        return new Expense(
                expenseDto.id(),
                expenseDto.amount(),
                expenseDto.expenseDate(),
                category
        );
    }
}
