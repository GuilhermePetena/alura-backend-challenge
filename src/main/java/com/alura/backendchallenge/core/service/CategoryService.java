package com.alura.backendchallenge.core.service;

import com.alura.backendchallenge.core.entity.Category;

import java.util.List;

public interface CategoryService {
    Category saveCategory(Category category);
    Category getOne(String id);
    List<Category> getAll();
    Boolean categoryExists(String id);
    void delete(String id);
}
