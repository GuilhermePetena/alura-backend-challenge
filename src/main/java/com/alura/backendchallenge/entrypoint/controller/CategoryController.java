package com.alura.backendchallenge.entrypoint.controller;

import com.alura.backendchallenge.core.service.CategoryService;
import com.alura.backendchallenge.entrypoint.mapper.CategoryEntrypointMapper;
import com.alura.backendchallenge.entrypoint.model.CategoryEntrypointModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/category")
public class CategoryController {
    private CategoryService categoryService;

    @Autowired
    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping
    public ResponseEntity<List<CategoryEntrypointModel>> getAllCategories() {
        return ResponseEntity.ok()
                .body(categoryService.getAll()
                        .stream()
                        .map(CategoryEntrypointMapper::convertToEntrypoint)
                        .collect(Collectors.toList()));
    }

    @GetMapping("/{id}")
    public ResponseEntity<CategoryEntrypointModel> getCategory(@PathVariable String id) {
        if (Objects.nonNull(id) && categoryService.categoryExists(id)) {
            return ResponseEntity.ok().body(CategoryEntrypointMapper.convertToEntrypoint(categoryService.getOne(id)));
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<CategoryEntrypointModel> saveCategory(@Valid @RequestBody CategoryEntrypointModel categoryEntrypointModel) {
        if (Objects.nonNull(categoryEntrypointModel)) {
            return ResponseEntity
                    .status(HttpStatus.CREATED)
                    .body(CategoryEntrypointMapper
                            .convertToEntrypoint(categoryService.saveCategory(CategoryEntrypointMapper.convertToDomain(categoryEntrypointModel))));
        }
        return ResponseEntity.badRequest().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteCategory(@PathVariable String id) {
        if (Objects.nonNull(id) && categoryService.categoryExists(id)) {
            categoryService.delete(id);
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.notFound().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<CategoryEntrypointModel> updateCategory(@PathVariable String id, @Valid @RequestBody CategoryEntrypointModel categoryEntrypointModel) {
        if (Objects.nonNull(id) && categoryService.categoryExists(id)) {
            return ResponseEntity.ok().body(CategoryEntrypointMapper.convertToEntrypoint(categoryService.saveCategory(CategoryEntrypointMapper.convertToDomain(categoryEntrypointModel))));
        }
        return ResponseEntity.notFound().build();
    }
}
