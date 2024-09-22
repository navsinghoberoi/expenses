package com.tracker.expenses.service;

import com.tracker.expenses.model.Expense;
import com.tracker.expenses.repository.ExpenseRepository;
import com.tracker.expenses.util.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

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

//    public List<Expense> getExpensesByCategoryInDateRange(String category, int month, int year) {
//        LocalDate startDate = LocalDate.of(year, month, 1);
//        LocalDate endDate = startDate.withDayOfMonth(startDate.lengthOfMonth());
//        return expenseRepository.findByCategoryAndDate(category, startDate, endDate);
//    }

//    public List<Expense> getExpensesInDateRange(int month, int year) {
//        LocalDate startDate = LocalDate.of(year, month, 1);
//        LocalDate endDate = startDate.withDayOfMonth(startDate.lengthOfMonth());
//        return expenseRepository.findByDateRange(startDate, endDate);
//    }

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
}
