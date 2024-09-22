package com.tracker.expenses.controller;


import com.tracker.expenses.model.Expense;
import com.tracker.expenses.service.ExpenseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/expenses")
public class ExpenseController {

    @Autowired
    private ExpenseService expenseService;

    @PostMapping
    public Expense addExpense(@RequestBody Expense expense) {
        return expenseService.addExpense(expense);
    }

    @GetMapping("/total")
    public double getTotalExpenses() {
        return expenseService.getTotalExpenses();
    }

    @GetMapping()
    public List<Expense> getExpensesByCategory(@RequestParam("category") String category) {
        return expenseService.getExpensesByCategory(category);
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
