package com.tracker.expenses.repository;

import com.tracker.expenses.model.Expense;
import com.tracker.expenses.util.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.List;
import java.util.Objects;


// mention custom methods here apart from already provided via JPARepo like save, findAll
public interface ExpenseRepository extends JpaRepository<Expense, Long> {
    List<Expense> findByCategory(Category category);

    @Query(value = "SELECT category, SUM(amount) from expenses group by category",nativeQuery = true)
    List<Object[]> findTotalAmountGroupedByCategory();

    @Query(value = "SELECT e.category,SUM(e.amount) from expenses e WHERE YEAR(e.date) = :year group by Category",nativeQuery = true)
    List<Object[]> findByYear(@Param("year") int year);
}
