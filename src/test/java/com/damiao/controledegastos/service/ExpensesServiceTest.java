package com.damiao.controledegastos.service;

import com.damiao.controledegastos.model.Expenses;
import com.damiao.controledegastos.repository.ExpensesRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.math.BigDecimal;
import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.verifyNoInteractions;

@ExtendWith(MockitoExtension.class)
public class ExpensesServiceTest {
    @Mock
    private ExpensesRepository repository;

    @InjectMocks
    private ExpensesService service;

    @Test
    @DisplayName("Deve lançar exceção ao salvar despesa com data futura")
    void deveLancarExcecaoQuandoDataFutura() {
        // Cenário
        Expenses despesaFutura = new Expenses();
        despesaFutura.setDescription("Compra Futura");
        despesaFutura.setValue(new BigDecimal("100.00"));
        despesaFutura.setDate(LocalDate.now().plusDays(1)); // Data amanhã

        // Ação e Verificação
        assertThrows(RuntimeException.class, () -> {
            service.save(despesaFutura);
        }, "A data da despesa não pode ser futura.");

        // Garante que o repository sequer foi chamado (Mock)
        verifyNoInteractions(repository);
    }

    @Test
    @DisplayName("Deve salvar despesa com sucesso quando os dados forem válidos")
    void deveSalvarDespesaComSucesso() {
        // Cenário
        Expenses despesaValida = new Expenses();
        despesaValida.setDescription("Almoço");
        despesaValida.setValue(new BigDecimal("35.50"));
        despesaValida.setDate(LocalDate.now());

        // Configurando o Mock do Repository
        org.mockito.Mockito.when(repository.save(despesaValida)).thenReturn(despesaValida);

        // Ação
        Expenses salva = service.save(despesaValida);

        // Verificação
        org.junit.jupiter.api.Assertions.assertNotNull(salva);
        org.junit.jupiter.api.Assertions.assertEquals("Almoço", salva.getDescription());
        org.mockito.Mockito.verify(repository, org.mockito.Mockito.times(1)).save(despesaValida);
    }

    @Test
    @DisplayName("Deve lançar exceção ao salvar despesa com valor negativo ou zero")
    void deveLancarExcecaoQuandoValorInvalido() {
        // Cenário
        Expenses despesaInvalida = new Expenses();
        despesaInvalida.setDescription("Erro de valor");
        despesaInvalida.setValue(new BigDecimal("-10.00"));
        despesaInvalida.setDate(LocalDate.now());

        // Ação e Verificação
        assertThrows(RuntimeException.class, () -> {
            service.save(despesaInvalida);
        });

        verifyNoInteractions(repository);
    }
}
