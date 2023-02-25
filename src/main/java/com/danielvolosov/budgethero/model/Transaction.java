package com.danielvolosov.budgethero.model;

import jakarta.annotation.Nullable;
import jakarta.persistence.*;

import java.math.BigDecimal;
import java.util.Date;

@Entity
@Table(name = "TRANSACTION")
public class Transaction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "TRANSACTION_ID", columnDefinition = "INTEGER")
    private int transactionId;

    @Column(name = "TOTAL", columnDefinition = "DECIMAL(12,2)")
    private BigDecimal total;

    @Nullable
    @Column(name = "DESCRIPTION", columnDefinition = "VARCHAR(250)")
    private String description;

    @Column(name = "DATE_OF_TRANSACTION", columnDefinition = "DATE DEFAULT CURRENT_DATE")
    private Date dateOfTransaction = new Date();

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="CATEGORY_ID")
    private Category category;

    public Transaction(int transactionId, BigDecimal total, String description, Date dateOfTransaction, Category category) {
        this.transactionId = transactionId;
        this.total = total;
        this.description = description;
        this.dateOfTransaction = dateOfTransaction;
        this.category = category;
    }

    public Transaction() {
    }

    public int getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(int transactionId) {
        this.transactionId = transactionId;
    }

    public BigDecimal getTotal() {
        return total;
    }

    public void setTotal(BigDecimal total) {
        this.total = total;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getDateOfTransaction() {
        return dateOfTransaction;
    }

    public void setDateOfTransaction(Date dateOfTransaction) {
        this.dateOfTransaction = dateOfTransaction;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }
}
