package com.danielvolosov.budgethero.service;

import com.danielvolosov.budgethero.model.Category;
import org.hibernate.ObjectNotFoundException;

import java.util.List;

public interface CategoryService {
    Category createCategory(Category category);

    List<Category> createCategories(List<Category> categories);

    Category getCategoryById(int id);

    List<Category> getCategories();

    Category updateCategory(Category category) throws ObjectNotFoundException;

    String deleteCategoryById(int id);
}
