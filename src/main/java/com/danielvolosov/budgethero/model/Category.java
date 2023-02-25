package com.danielvolosov.budgethero.model;

import jakarta.persistence.*;

@Entity
@Table(name = "CATEGORY")
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "CATEGORY_ID", columnDefinition = "INTEGER")
    private int categoryId;
    @Column(name = "NAME", columnDefinition = "VARCHAR(50)")
    private String name;
    @Column(name = "ICON", columnDefinition = "VARCHAR(25)")
    private String icon;
    @Column(name = "TRANSACTION_TYPE", columnDefinition = "VARCHAR(15)")
    private String transactionType;

    public Category(int categoryId, String name, String icon, String transactionType) {
        this.categoryId = categoryId;
        this.name = name;
        this.icon = icon;
        this.transactionType = transactionType;
    }

    public Category() {
    }

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public String getTransactionType() {
        return transactionType;
    }

    public void setTransactionType(String transactionType) {
        this.transactionType = transactionType;
    }
}
