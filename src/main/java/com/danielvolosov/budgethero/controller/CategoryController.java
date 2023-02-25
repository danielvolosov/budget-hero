package com.danielvolosov.budgethero.controller;

import com.danielvolosov.budgethero.model.Category;
import com.danielvolosov.budgethero.service.CategoryService;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
@RequestMapping("/api/category")
public class CategoryController {
    private CategoryService _categoryService;

    public CategoryController(CategoryService categoryService) {
        _categoryService = categoryService;
    }

    @PostMapping("/addCategory")
    public Category addCategory(@RequestBody Category category) {

        return _categoryService.createCategory(category);
    }

    @PostMapping("/addCategories")
    public List<Category> addCategories(@RequestBody List<Category> Categories) {

        return _categoryService.createCategories(Categories);
    }

    @GetMapping("/{id}")
    public Category getCategoryById(@PathVariable int id) {
        return _categoryService.getCategoryById(id);
    }

    @GetMapping("/categories")
    public List<Category> getAllCategories() {
        return _categoryService.getCategories();
    }

    @PutMapping("/updateCategory")
    public Category updateCategory(@RequestBody Category Category) {
        return _categoryService.updateCategory(Category);
    }

    @DeleteMapping("/{id}")
    public String deleteCategory(@PathVariable int id) {
        return _categoryService.deleteCategoryById(id);
    }
}
