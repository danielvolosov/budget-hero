package com.danielvolosov.budgethero.service;

import com.danielvolosov.budgethero.model.Transaction;
import com.danielvolosov.budgethero.repository.TransactionRepository;
import org.hibernate.ObjectNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TransactionServiceImpl implements TransactionService {

    private TransactionRepository _transactionRepository;

    public TransactionServiceImpl(TransactionRepository TransactionRepository) {
        _transactionRepository = TransactionRepository;
    }

    @Override
    public Transaction createTransaction(Transaction transaction) {
        return _transactionRepository.save(transaction);
    }

    @Override
    public List<Transaction> createTransactions(List<Transaction> transactions) {
        return _transactionRepository.saveAll(transactions);
    }

    @Override
    public Transaction getTransactionById(int id) {
        return _transactionRepository.findById(id).orElse(null);
    }

    @Override
    public List<Transaction> getTransactions() {
        return _transactionRepository.findAll();
    }

    @Override
    public Transaction updateTransaction(Transaction transaction) throws ObjectNotFoundException {
        Optional<Transaction> formerTransaction = _transactionRepository.findById(transaction.getTransactionId());

        Transaction transactionToUpdate = formerTransaction.get();

        if (formerTransaction.isPresent()) {
            transactionToUpdate.setDateOfTransaction(transaction.getDateOfTransaction());
            transactionToUpdate.setTotal(transaction.getTotal());
            transactionToUpdate.setCategory(transaction.getCategory());
            transactionToUpdate.setDescription(transaction.getDescription());

            _transactionRepository.save(transactionToUpdate);
        } else {
            throw new ObjectNotFoundException(formerTransaction, "Could not find Transaction id " + transaction.getTransactionId());
        }

        return transactionToUpdate;
    }

    @Override
    public String deleteTransactionById(int id) {
        _transactionRepository.deleteById((id));

        return "Transaction has been deleted";
    }

}
