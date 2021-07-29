package com.alura.backendchallenge.dataprovider.repository;

import com.alura.backendchallenge.dataprovider.entity.CategoryDataproviderEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface  CategoryRepository extends JpaRepository<CategoryDataproviderEntity, UUID> {
}