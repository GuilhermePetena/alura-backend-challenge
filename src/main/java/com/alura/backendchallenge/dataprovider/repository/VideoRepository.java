package com.alura.backendchallenge.dataprovider.repository;

import com.alura.backendchallenge.dataprovider.entity.VideoDataproviderEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface VideoRepository extends JpaRepository<VideoDataproviderEntity, UUID> {
}