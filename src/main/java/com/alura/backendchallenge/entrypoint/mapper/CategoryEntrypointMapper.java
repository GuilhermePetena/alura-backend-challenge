package com.alura.backendchallenge.entrypoint.mapper;

import com.alura.backendchallenge.core.entity.Category;
import com.alura.backendchallenge.entrypoint.model.CategoryEntrypointModel;
import org.springframework.stereotype.Component;

@Component
public class CategoryEntrypointMapper {
    public static Category convertToDomain(CategoryEntrypointModel categoryEntrypointModel) {
        return Category.builder()
                .id(categoryEntrypointModel.getId())
                .title(categoryEntrypointModel.getTitle())
                .color(categoryEntrypointModel.getColor())
                .build();
    }

    public static CategoryEntrypointModel convertToEntrypoint(Category category) {
        return CategoryEntrypointModel.builder()
                .id(category.getId())
                .title(category.getTitle())
                .color(category.getColor())
                .build();
    }
}
