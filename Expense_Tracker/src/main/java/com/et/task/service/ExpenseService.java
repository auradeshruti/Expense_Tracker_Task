package com.et.task.service;

import com.et.task.model.Expense;
import com.et.task.repository.ExpenseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ExpenseService {

    @Autowired
    private ExpenseRepository expenseRepository;

    public List<Expense> getAllExpenses() {
        return expenseRepository.findAll();
    }

    public Optional<Expense> getExpenseById(Long id) {
        return expenseRepository.findById(id);
    }

    public Expense addExpense(Expense expense) {
        return expenseRepository.save(expense);
    }

    public void deleteExpense(Long id) {
        expenseRepository.deleteById(id);
    }
    public Page<Expense> getExpensesByPage(Pageable page) {
        return expenseRepository.findAll(page);
    }
    
    
    public void updateExpense(Long id, Expense updatedExpense) {
        Expense existingExpense = expenseRepository.findById(id).orElse(null);
        if (existingExpense != null) {
            existingExpense.setExpenseName(updatedExpense.getExpenseName());
            existingExpense.setAmount(updatedExpense.getAmount());
            existingExpense.setDate(updatedExpense.getDate());
            existingExpense.setDescription(updatedExpense.getDescription());
            expenseRepository.save(existingExpense); // Save the updated expense
        }
    }
    
    public void saveExpense(Expense expense) {
        if (expense.getId() == null) {
            // Add new expense
            expenseRepository.save(expense);
        } else {
            // Update existing expense
            Expense existingExpense = expenseRepository.findById(expense.getId()).orElseThrow();
            existingExpense.setAmount(expense.getAmount());
            existingExpense.setDate(expense.getDate());
            existingExpense.setDescription(expense.getDescription());
            expenseRepository.save(existingExpense);
        }
    }
}
