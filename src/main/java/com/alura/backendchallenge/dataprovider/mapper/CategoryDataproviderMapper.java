package com.alura.backendchallenge.dataprovider.mapper;

import com.alura.backendchallenge.core.entity.Category;
import com.alura.backendchallenge.dataprovider.entity.CategoryDataproviderEntity;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class CategoryDataproviderMapper {
    public static Category convertToDomain(CategoryDataproviderEntity categoryDataproviderEntity) {
        return Category.builder()
                .id(categoryDataproviderEntity.getId().toString())
                .title(categoryDataproviderEntity.getTitle())
                .color(categoryDataproviderEntity.getColor())
                .build();
    }

    public static CategoryDataproviderEntity convertToDataprovider(Category category) {
        return CategoryDataproviderEntity.builder()
                .id(UUID.fromString(category.getId()))
                .title(category.getTitle())
                .color(category.getColor())
                .build();
    }
}
