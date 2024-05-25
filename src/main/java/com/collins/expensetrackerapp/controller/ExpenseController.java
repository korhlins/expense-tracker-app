package com.collins.expensetrackerapp.controller;

import com.collins.expensetrackerapp.dto.ExpenseDto;
import com.collins.expensetrackerapp.service.ExpenseService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(
        name = "CRUD REST APIs for Expense Resource",
        description = "CRUD REST APIs for Expense Resource - Create Expense" +
                " Update Expense, Get Expense and Delete Expense"
)
@AllArgsConstructor
@RestController
@RequestMapping("/api/expenses")
public class ExpenseController {

    private ExpenseService expenseService;

    @Operation( summary = "Create Expense REST API",
            description = "Create Expense REST API to save category into database"
    )
    @ApiResponse(
            responseCode = "201",
            description = "HTTPS STATUS 201 CREATED"
    )
    @PostMapping("/create")
    public ResponseEntity<ExpenseDto> createExpense(@RequestBody ExpenseDto expenseDto){
        ExpenseDto savedExpense = expenseService.createExpense(expenseDto);
        return new ResponseEntity<>(savedExpense, HttpStatus.CREATED);
    }

    @Operation( summary = "Get Expense REST API",
            description = "Get Expense REST API to get an expense from the database"
    )
    @ApiResponse(
            responseCode = "201",
            description = "HTTPS STATUS 201 CREATED"
    )
    @GetMapping("{id}")
    public ResponseEntity<ExpenseDto> getExpenseById(@PathVariable("id") Long expenseId){
        ExpenseDto retrievedExpense = expenseService.findById(expenseId);
        return ResponseEntity.ok(retrievedExpense);
    }

    @Operation( summary = "Get All Expense REST API",
            description = "Get All Expense REST API to get all expense from the database"
    )
    @ApiResponse(
            responseCode = "201",
            description = "HTTPS STATUS 201 CREATED"
    )
    @GetMapping
    public ResponseEntity<List<ExpenseDto>> getAllExpense(){
        List<ExpenseDto> allExpense = expenseService.getAllExpense();
        return ResponseEntity.ok(allExpense);
    }

    @Operation( summary = "Update Expense REST API",
            description = "Update Expense REST API to update an expense in the database"
    )
    @ApiResponse(
            responseCode = "201",
            description = "HTTPS STATUS 201 CREATED"
    )
    @PutMapping("/update/{id}")
    public ResponseEntity<ExpenseDto> updateExpense(@PathVariable("id") Long expenseId,@RequestBody ExpenseDto expenseDto){
        ExpenseDto updatedExpense = expenseService.updateExpense(expenseId, expenseDto);
        return ResponseEntity.ok(updatedExpense);
    }

    @Operation( summary = "Delete Expense REST API",
            description = "Delete Expense REST API to delete an expense from the database"
    )
    @ApiResponse(
            responseCode = "201",
            description = "HTTPS STATUS 201 CREATED"
    )
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteExpense(@PathVariable("id")  Long expenseId){
        expenseService.deleteExpense(expenseId);
        return  ResponseEntity.ok("Expense deleted Successfully.");
    }
}
