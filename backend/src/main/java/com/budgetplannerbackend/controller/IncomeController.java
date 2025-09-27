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

import com.budgetplannerbackend.model.Income;
import com.budgetplannerbackend.repository.IncomeRepository;

@RestController
@RequestMapping("/api/incomes")
@CrossOrigin(origins = "http://localhost:5173")
public class IncomeController {

    @Autowired
    private IncomeRepository incomeRepository;

    @PostMapping("/add")
    public ResponseEntity<Income> addIncome(@RequestBody Income income) {
        Income saved = incomeRepository.save(income);
        return ResponseEntity.ok(saved);
    }

    @GetMapping("/{userId}")
    public ResponseEntity<List<Income>> getIncomes(@PathVariable("userId") Long userId) {
        List<Income> incomes = incomeRepository.findByUserId(userId);
        return ResponseEntity.ok(incomes);
    }
}
