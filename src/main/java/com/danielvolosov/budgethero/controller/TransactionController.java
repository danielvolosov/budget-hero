package com.danielvolosov.budgethero.controller;

import com.danielvolosov.budgethero.model.Transaction;
import com.danielvolosov.budgethero.service.TransactionService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/transaction")
public class TransactionController {

    private TransactionService _transactionService;

    public TransactionController(TransactionService transactionService) {
        _transactionService = transactionService;
    }

    @PostMapping("/addTransaction")
    public Transaction addTransaction(@RequestBody Transaction transaction) {

        return _transactionService.createTransaction(transaction);
    }

    @PostMapping("/addTransactions")
    public List<Transaction> addTransactions(@RequestBody List<Transaction> transactions) {

        return _transactionService.createTransactions(transactions);
    }

    @GetMapping("/{id}")
    public Transaction getTransactionById(@PathVariable int id) {
        return _transactionService.getTransactionById(id);
    }

    @GetMapping("/transactions")
    public List<Transaction> getAllTransactions() {
        return _transactionService.getTransactions();
    }

    @PutMapping("/updateTransaction")
    public Transaction updateTransaction(@RequestBody Transaction transaction) {
        return _transactionService.updateTransaction(transaction);
    }

    @DeleteMapping("/{id}")
    public String deleteTransaction(@PathVariable int id) {
        return _transactionService.deleteTransactionById(id);
    }
}
