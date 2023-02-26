package com.danielvolosov.budgethero.service;

import com.danielvolosov.budgethero.model.Category;
import com.danielvolosov.budgethero.model.Transaction;
import com.danielvolosov.budgethero.repository.TransactionRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.math.BigDecimal;
import java.util.Date;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

@DataJpaTest
public class TransactionRepositoryTests {

    @Autowired
    private TransactionRepository _transactionRepository;

    private Transaction _transaction;

    @BeforeEach
    public void setup() {
        Date date = new Date();
        Category testCategory = new Category();
        BigDecimal testTotal = new BigDecimal(499.99);

        _transaction = new Transaction(1, testTotal, "Ordered a box of apples", date, testCategory);
    }

    @Test
    @DisplayName("Test for save/update transaction")
    public void givenTransactionObject_whenUpdate_thenReturnUpdatedTransaction() {

        // given
        Transaction currentTransaction = new Transaction(1, new BigDecimal(799.99), "Ordered a box of oranges", new Date(), new Category());

        // when
        Transaction updatedTransaction = _transactionRepository.save(currentTransaction);

        // then
        assertThat(updatedTransaction).isNotNull();
        assertThat(updatedTransaction.getTransactionId()).isGreaterThan(0);
    }


}
