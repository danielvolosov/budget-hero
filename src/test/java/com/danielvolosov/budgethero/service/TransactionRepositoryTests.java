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
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

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
    @DisplayName("Test for create transaction")
    public void givenTransactionObject_whenCreate_thenReturnCreatedTransaction() {

        // given
        Transaction currentTransaction = new Transaction(1, new BigDecimal(799.99), "Ordered a box of oranges", new Date(), new Category());

        // when
        Transaction createdTransaction = _transactionRepository.save(currentTransaction);

        // then
        assertThat(createdTransaction).isNotNull();
        assertThat(createdTransaction.getTransactionId()).isGreaterThan(0);
    }

    @Test
    @DisplayName("Test for create multiple transaction")
    public void givenMultipleTransactionObjects_whenCreate_thenReturnCreatedTransactions() {

        // given
        Transaction transaction1 = new Transaction(1, new BigDecimal(799.99), "Ordered a box of oranges", new Date(), new Category());
        Transaction transaction2 = new Transaction(2, new BigDecimal(899.99), "Ordered a box of apples", new Date(), new Category());
        Transaction transaction3 = new Transaction(3, new BigDecimal(999.99), "Ordered a box of grapes", new Date(), new Category());

        List<Transaction> transactionList = new ArrayList<>();
        transactionList.add(transaction1);
        transactionList.add(transaction2);
        transactionList.add(transaction3);

        // when
        List<Transaction> createdTransactions = _transactionRepository.saveAll(transactionList);

        // then
        assertThat(createdTransactions).isNotNull();
        assertThat(createdTransactions.size()).isEqualTo(3);
    }

    @Test
    @DisplayName("Test for get transaction by id")
    public void givenTransactionId_whenGetById_thenReturnTransaction() {

        // given
        Transaction existingTransaction = new Transaction(1, new BigDecimal(799.99), "Ordered a box of oranges", new Date(), new Category());

        // when
        Optional retrievedTransaction = _transactionRepository.findById(1);

        // then
        assertThat(retrievedTransaction).isNotNull();
        assertThat(retrievedTransaction.isPresent());
    }

    @Test
    @DisplayName("Test for get transaction by id when id doesn't exist")
    public void givenTransactionIdThatDoesNotExist_whenGetById_thenFail() {

        // when
        Optional retrievedTransaction = _transactionRepository.findById(1);

        // then
        assertThat(retrievedTransaction.isPresent() == Optional.empty().isPresent());
    }
}
