package com.et.task.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import java.time.LocalDate;

@Entity
public class Expense {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String expenseName;
    private Double amount;
    private LocalDate date;
    private String description; 

    // Constructors, Getters, and Setters

    public Expense() {}

    public Expense(String expensename, Double amount, LocalDate date, String description) {
        this.expenseName = expensename;
        this.amount = amount;
        this.date = date;
        this.description = description;
    }

    // Getters and Setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getExpenseName() { 
        return expenseName;
    }

    public void setExpenseName(String expenseName) { 
        this.expenseName = expenseName;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}