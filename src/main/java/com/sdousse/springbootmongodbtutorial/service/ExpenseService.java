package com.sdousse.springbootmongodbtutorial.service;

import org.springframework.stereotype.Service;
import com.sdousse.springbootmongodbtutorial.model.Expense;
import com.sdousse.springbootmongodbtutorial.repository.ExpenseRepository;

import java.util.List;
import java.util.Optional;

@Service
public class ExpenseService {
    private final ExpenseRepository expenseRepository;

    public ExpenseService(ExpenseRepository expensesRepository) {
        this.expenseRepository = expensesRepository;
    }

    public void addExpense(Expense expense) {
        expenseRepository.insert(expense);
    }
    public List<Expense> getAllExpense() {
        return expenseRepository.findAll();
    }
    public Expense getExpenseByName(String name) {
        return expenseRepository.findByName(name).orElseThrow(() -> new RuntimeException(String.format("Cannot find Expense with name %s", name)));
    }
    public void updateExpense(Expense expense) {
        Optional<Expense> expenseOptional = expenseRepository.findByID(expense.getId());
        if (!expenseOptional.isPresent()) {
            throw new RuntimeException(String.format("Cannot find Expend with ID %s", expense.getId()));
        }
        Expense expenseToUpdate = expenseOptional.get();
        expenseToUpdate.setExpenseName(expense.getExpenseName());
        expenseToUpdate.setExpenseCategory(expense.getExpenseCategory());
        expenseToUpdate.setExpenseAmount(expense.getExpenseAmount());
        expenseRepository.save(expenseToUpdate);
    }
    public void deleteExpense(String id) {
        Optional<Expense> expenseOptional = expenseRepository.findByID(id);
        if (!expenseOptional.isPresent()) {
            throw new RuntimeException(String.format("Cannot find Expense with ID %s", id));
        }
        expenseRepository.deleteById(id);
    }
}