package com.alura.backendchallenge.dataprovider.impl;

import com.alura.backendchallenge.core.entity.Category;
import com.alura.backendchallenge.core.service.CategoryService;
import com.alura.backendchallenge.dataprovider.mapper.CategoryDataproviderMapper;
import com.alura.backendchallenge.dataprovider.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Component
public class CategoryDataprovider implements CategoryService {

    private CategoryRepository categoryRepository;

    @Autowired
    public CategoryDataprovider(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }


    @Override
    public Category saveCategory(Category category) {
        return CategoryDataproviderMapper.convertToDomain(categoryRepository.save(CategoryDataproviderMapper.convertToDataprovider(category)));
    }

    @Override
    public Category getOne(String id) {
        return CategoryDataproviderMapper.convertToDomain(categoryRepository.findById(UUID.fromString(id)).get());
    }

    @Override
    public List<Category> getAll() {
        return categoryRepository.findAll().stream()
                .map(CategoryDataproviderMapper::convertToDomain)
                .collect(Collectors.toList());
    }

    @Override
    public Boolean categoryExists(String id) {
        return categoryRepository.existsById(UUID.fromString(id));
    }

    @Override
    public void delete(String id) {
        categoryRepository.deleteById(UUID.fromString(id));
    }
}
