package com.damiao.controledegastos.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.damiao.controledegastos.repository.ExpensesRepository;
import com.damiao.controledegastos.model.Expenses;

import java.time.LocalDate;
import java.util.List;

@Service
public class ExpensesService {
    @Autowired
    private ExpensesRepository repository;

    public Expenses save(Expenses expense) {
    // Exemplo de regra de negócio: garantir que a data não seja futura
    if (expense.getDate().isAfter(LocalDate.now())) {
        throw new RuntimeException("A data da despesa não pode ser futura.");
    }
        return repository.save(expense);
    }

    public List<Expenses> findAll() {
        return repository.findAll();
    }
}
