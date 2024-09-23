package com.tracker.expenses.controller;


import com.tracker.expenses.model.Expense;
import com.tracker.expenses.service.ExpenseService;
import com.tracker.expenses.util.Category;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/v1/expenses")
public class ExpenseController {

    @Autowired
    private ExpenseService expenseService;

    @PostMapping
    public Expense addExpense(@Valid @RequestBody Expense expense) {
        return expenseService.addExpense(expense);
    }

    @GetMapping("/total")
    public double getTotalExpenses() {
        return expenseService.getTotalExpenses();
    }

    @GetMapping("/totalCategoryWise")
    public Map<Category, Double> getTotalExpensesCategoryWise() {
        return expenseService.getTotalExpensesByCategory();
    }

    @GetMapping()
    public List<Expense> getExpensesByCategory(@RequestParam("category") Category category) {
        return expenseService.getExpensesByCategory(category);
    }

    @GetMapping("/year")
    public Map<Category, Double> getExpensesByYear(@RequestParam("year") int year) {
        return expenseService.getExpensesByYear(year);
    }

    @DeleteMapping("/{id}")
    public void deleteExpense(@PathVariable Long id) {
        expenseService.deleteExpense(id);
    }

    @PatchMapping("/{id}")
    public Expense updateExpenses(@PathVariable Long id, @RequestBody Expense expense) {
        return expenseService.updateCategory(id, expense);
    }

}
