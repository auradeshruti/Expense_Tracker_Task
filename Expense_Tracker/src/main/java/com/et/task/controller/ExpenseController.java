package com.et.task.controller;

import com.et.task.model.Expense;
import com.et.task.service.ExpenseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class ExpenseController {

    @Autowired
    private ExpenseService expenseService;

    @GetMapping("/expenses")
    
    public String listExpenses(Model model) {
        // Fetch the list of expenses and add to the model
        List<Expense> expenses = expenseService.getAllExpenses();
        model.addAttribute("expenses", expenses);
        return "expenses";
    }

    @GetMapping("/addexpense")
    public String showAddExpenseForm(Model model) {
        model.addAttribute("expense", new Expense()); // Add empty Expense object for form binding
        return "addexpense"; 
    }
    

    @PostMapping("/expenses")
    public String addExpense(@ModelAttribute Expense expense) {
        expenseService.addExpense(expense);
        return "redirect:/expenses";
    }

    @GetMapping("/expenses/delete/{id}")
    public String deleteExpense(@PathVariable Long id) {
        expenseService.deleteExpense(id);
        return "redirect:/expenses";
    } 
    
    @GetMapping("/expenses/update/{id}")
    public String showUpdateExpenseForm(@PathVariable Long id, Model model) {
        Expense existingExpense = expenseService.getExpenseById(id).orElseThrow(); // Fetch expense by id
        model.addAttribute("expense", existingExpense);
        return "updateexpense"; // Refers to the 'updateexpense.html'
    }

    // Handle the form submission for updating
    @PostMapping("/expenses/update/{id}")
    public String updateExpense(@PathVariable Long id, @ModelAttribute Expense expense) {
        expenseService.updateExpense(id, expense); // Service method to handle the update logic
        return "redirect:/expenses";
    }
    @GetMapping("/home")
        public String showHomePage() {
            return "home"; 
        
    }
}
