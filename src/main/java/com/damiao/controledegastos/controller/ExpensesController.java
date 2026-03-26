package com.damiao.controledegastos.controller;

import com.damiao.controledegastos.model.Expenses;
import com.damiao.controledegastos.service.ExpensesService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/expenses")
public class ExpensesController {
    @Autowired
    private ExpensesService service;

    @PostMapping
    public ResponseEntity<Expenses> create(@Valid @RequestBody Expenses expense) {
        // O @Valid garante que as anotações do Model (como @Positive) sejam respeitadas
        Expenses savedExpense = service.save(expense);
        return ResponseEntity.ok(savedExpense);
    }

    @GetMapping
    public List<Expenses> listAll() {
        return service.findAll();
    }
}
