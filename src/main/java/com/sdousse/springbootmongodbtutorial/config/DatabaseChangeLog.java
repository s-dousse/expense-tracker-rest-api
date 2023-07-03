package com.sdousse.springbootmongodbtutorial.config;

import com.github.cloudyrock.mongock.ChangeLog;
import com.github.cloudyrock.mongock.ChangeSet;
import com.sdousse.springbootmongodbtutorial.model.Expense;
import com.sdousse.springbootmongodbtutorial.model.ExpenseCategory;
import com.sdousse.springbootmongodbtutorial.repository.ExpenseRepository;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@ChangeLog
public class DatabaseChangeLog {
    @ChangeSet(order = "001", id= "seedDatabase", author = "Sarah")
    public void seedDatabase(ExpenseRepository expenseRepository) {
        List<Expense> expenseList = new ArrayList<>();
        expenseList.add(createNewExpense("My local Veggie Shop", ExpenseCategory.valueOf("GROCERIES"), BigDecimal.valueOf(14.87)));
        expenseList.add(createNewExpense("MyGym Yay", ExpenseCategory.valueOf("ENTERTAINEMENT"), BigDecimal.valueOf(45)));
        expenseList.add(createNewExpense("Little Sicily", ExpenseCategory.valueOf("RESTAURANT"), BigDecimal.valueOf(35.60)));
        expenseList.add(createNewExpense("Broadband", ExpenseCategory.valueOf("UTILITIES"), BigDecimal.valueOf(40)));
        expenseList.add(createNewExpense("Subscription I forgot to cancel", ExpenseCategory.valueOf("MISCELLANEOUS"), BigDecimal.valueOf(15)));
        expenseRepository.insert(expenseList);
    }

    private Expense createNewExpense(String expenseName, ExpenseCategory expenseCategory, BigDecimal expenseAmount) {
        Expense expense = new Expense();
        expense.setExpenseName(expenseName);
        expense.setExpenseCategory(expenseCategory);
        expense.setExpenseAmount(expenseAmount);
        return expense;
    }
}
