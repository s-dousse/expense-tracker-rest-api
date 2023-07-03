package com.sdousse.springbootmongodbtutorial.controller;

import com.sdousse.springbootmongodbtutorial.model.Expense;
import com.sdousse.springbootmongodbtutorial.service.ExpenseService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/expense")
public class ExpenseController {
    private final ExpenseService expenseService;

    public ExpenseController(ExpenseService expenseService) {
        this.expenseService = expenseService;
    }

    @PostMapping
    public ResponseEntity<String> addExpense(@RequestBody Expense expense) {
        expenseService.addExpense(expense);
        return new ResponseEntity<>("New Expense Created", HttpStatus.CREATED);
    }
    @GetMapping
    public ResponseEntity<List> getAllExpense() {
        return new ResponseEntity<>(expenseService.getAllExpense(), HttpStatus.OK);
    }
    @GetMapping("/{name}")
    public ResponseEntity<Expense> getExpenseByName(@PathVariable String name) {
        return new ResponseEntity<>(expenseService.getExpenseByName(name), HttpStatus.OK);
    }
    @PutMapping
    public ResponseEntity<String>updateExpense(@RequestBody Expense expense) {
        expenseService.updateExpense(expense);
        return new ResponseEntity<>("Expense Updated", HttpStatus.OK);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteExpense(@PathVariable String id) {
        expenseService.deleteExpense(id);
        return new ResponseEntity<>("Expense Deleted", HttpStatus.OK);
    }
}