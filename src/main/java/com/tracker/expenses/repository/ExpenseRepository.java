package com.tracker.expenses.repository;

import com.tracker.expenses.model.Expense;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

import java.time.LocalDate;
import java.util.List;


// mention custom methods here apart from already provided via JPARepo like save, findAll
public interface ExpenseRepository extends JpaRepository<Expense, Long> {
    //List<Expense> findByCategoryAndDate(String category, LocalDate startDate, LocalDate endDate);
    List<Expense> findByCategory(String category);
    //List<Expense> findByDateRange(LocalDate startDate, LocalDate endDate);
}
