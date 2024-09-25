package com.et.task.repository;

import com.et.task.model.Expense;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ExpenseRepository extends JpaRepository<Expense, Long> {
    // Custom query methods can be added here if needed.
}
