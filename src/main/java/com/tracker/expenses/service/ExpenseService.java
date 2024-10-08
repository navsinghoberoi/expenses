package com.tracker.expenses.service;

import com.tracker.expenses.model.Expense;
import com.tracker.expenses.repository.ExpenseRepository;
import com.tracker.expenses.util.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class ExpenseService {

    @Autowired
    private ExpenseRepository expenseRepository;

    public Expense addExpense(Expense expense) {
        return expenseRepository.save(expense);
    }

    public List<Expense> getExpensesByCategory(Category category) {
        return expenseRepository.findByCategory(category);
    }

    public Map<Category, Double> getExpensesByYear(int year) {
        List<Object[]> results = expenseRepository.findByYear(year);
        Map<Category, Double> totals = new HashMap<>();
        for (Object[] result : results) {
            Category category = Category.valueOf((String) result[0]);
            Double amount = (Double) result[1];
            totals.put(category, amount);
        }
        return totals;
    }

    public double getTotalExpenses() {
        return expenseRepository.findAll().stream().mapToDouble(Expense::getAmount).sum();
    }

    public void deleteExpense(Long id) {
        expenseRepository.deleteById(id);
    }

    public Expense updateCategory(Long id, Expense newExpense) {
        Optional<Expense> expenseOptional = expenseRepository.findById(id);
        if (expenseOptional.isPresent()) {
            Expense existingExpense = expenseOptional.get();

            if (newExpense.getCategory() != null) {
                existingExpense.setCategory(newExpense.getCategory());
            }
            if (newExpense.getDescription() != null) {
                existingExpense.setDescription(newExpense.getDescription());
            }
            if (newExpense.getAmount() != 0.0) {
                existingExpense.setAmount(newExpense.getAmount());
            }
            if (newExpense.getDate() != null) {
                existingExpense.setDate(newExpense.getDate());
            }
            return expenseRepository.save(existingExpense);
        } else {
            throw new RuntimeException("Expense not found via id{}:" + id);
        }
    }

    public Map<Category, Double> getTotalExpensesByCategory() {
        List<Object[]> results = expenseRepository.findTotalAmountGroupedByCategory();
        Map<Category, Double> totals = new HashMap<>();
        for (Object[] result : results) {
            Category category = Category.valueOf((String) result[0]);
            Double amount = (Double) result[1];
            totals.put(category, amount);
        }
        return totals;
    }

    public Map<Category, Double> getExpensesByMonth(int month, int year) {
        List<Object[]> results = expenseRepository.findByMonth(month, year);
        Map<Category, Double> totals = new HashMap<>();
        for (Object[] result : results) {
            Category category = Category.valueOf((String) result[0]);
            Double amount = (Double) result[1];
            totals.put(category, amount);
        }
        return totals;
    }
}
