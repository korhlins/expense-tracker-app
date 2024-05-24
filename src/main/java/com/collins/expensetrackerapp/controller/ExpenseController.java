package com.collins.expensetrackerapp.controller;

import com.collins.expensetrackerapp.dto.ExpenseDto;
import com.collins.expensetrackerapp.service.ExpenseService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/api/expenses")
public class ExpenseController {

    private ExpenseService expenseService;

    @PostMapping("/create")
    public ResponseEntity<ExpenseDto> createExpense(@RequestBody ExpenseDto expenseDto){
        ExpenseDto savedExpense = expenseService.createExpense(expenseDto);
        return new ResponseEntity<>(savedExpense, HttpStatus.CREATED);
    }

    @GetMapping("{id}")
    public ResponseEntity<ExpenseDto> getExpenseById(@PathVariable("id") Long expenseId){
        ExpenseDto retrievedExpense = expenseService.findById(expenseId);
        return ResponseEntity.ok(retrievedExpense);
    }

    @GetMapping
    public ResponseEntity<List<ExpenseDto>> getAllExpense(){
        List<ExpenseDto> allExpense = expenseService.getAllExpense();
        return ResponseEntity.ok(allExpense);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<ExpenseDto> updateExpense(@PathVariable("id") Long expenseId,@RequestBody ExpenseDto expenseDto){
        ExpenseDto updatedExpense = expenseService.updateExpense(expenseId, expenseDto);
        return ResponseEntity.ok(updatedExpense);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteExpense(@PathVariable("id")  Long expenseId){
        expenseService.deleteExpense(expenseId);
        return  ResponseEntity.ok("Expense deleted Successfully.");
    }
}
