package com.budgetplannerbackend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.budgetplannerbackend.model.Expense;
import com.budgetplannerbackend.repository.ExpenseRepository;

@RestController
@RequestMapping("/api/expenses")
@CrossOrigin(origins = "http://localhost:5173")
public class ExpenseController {

    @Autowired
    private ExpenseRepository expenseRepository;

    @PostMapping("/add")
    public ResponseEntity<Expense> addExpense(@RequestBody Expense expense) {
        Expense saved = expenseRepository.save(expense);
        return ResponseEntity.ok(saved);
    }

    @GetMapping("/{userId}")
    public ResponseEntity<List<Expense>> getExpenses(@PathVariable("userId") Long userId) {
        List<Expense> expenses = expenseRepository.findByUserId(userId);
        return ResponseEntity.ok(expenses);
    }
}
