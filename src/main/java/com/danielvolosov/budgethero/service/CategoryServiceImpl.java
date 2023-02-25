package com.danielvolosov.budgethero.service;

import com.danielvolosov.budgethero.model.Category;
import com.danielvolosov.budgethero.repository.CategoryRepository;
import org.hibernate.ObjectNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryServiceImpl implements CategoryService {

    private CategoryRepository _categoryRepository;

    public CategoryServiceImpl(CategoryRepository categoryRepository) {
        _categoryRepository = categoryRepository;
    }

    @Override
    public Category createCategory(Category category) {
        return _categoryRepository.save(category);
    }

    @Override
    public List<Category> createCategories(List<Category> categories) {
        return _categoryRepository.saveAll(categories);
    }

    @Override
    public Category getCategoryById(int id) {
        return _categoryRepository.findById(id).orElse(null);
    }

    @Override
    public List<Category> getCategories() {
        return _categoryRepository.findAll();
    }

    @Override
    public Category updateCategory(Category category) throws ObjectNotFoundException {
        Optional<Category> formerCategory = _categoryRepository.findById(category.getCategoryId());

        Category categoryToUpdate = formerCategory.get();

        if (formerCategory.isPresent()) {
            categoryToUpdate.setName(category.getName());
            categoryToUpdate.setIcon(category.getIcon());
            categoryToUpdate.setTransactionType(category.getTransactionType());

            _categoryRepository.save(categoryToUpdate);
        } else {
            throw new ObjectNotFoundException(formerCategory, "Could not find category id " + category.getCategoryId());
        }

        return categoryToUpdate;
    }

    @Override
    public String deleteCategoryById(int id) {
        _categoryRepository.deleteById((id));

        return "Category has been deleted";
    }
}
