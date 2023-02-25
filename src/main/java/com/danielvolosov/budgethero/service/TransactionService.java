package com.danielvolosov.budgethero.service;

import com.danielvolosov.budgethero.model.Transaction;
import org.hibernate.ObjectNotFoundException;

import java.util.List;

public interface TransactionService {
    Transaction createTransaction(Transaction transaction);

    List<Transaction> createTransactions(List<Transaction> transactions);

    Transaction getTransactionById(int id);

    List<Transaction> getTransactions();

    Transaction updateTransaction(Transaction transaction) throws ObjectNotFoundException;

    String deleteTransactionById(int id);
}
