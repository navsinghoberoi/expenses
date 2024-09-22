package com.tracker.expenses.repository;

import com.tracker.expenses.model.Expense;
import com.tracker.expenses.util.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;


// mention custom methods here apart from already provided via JPARepo like save, findAll
public interface ExpenseRepository extends JpaRepository<Expense, Long> {
    List<Expense> findByCategory(Category category);
}
