package com.alura.backendchallenge.dataprovider.impl;

import com.alura.backendchallenge.core.entity.Video;
import com.alura.backendchallenge.core.service.VideoService;
import com.alura.backendchallenge.dataprovider.mapper.VideoDataproviderMapper;
import com.alura.backendchallenge.dataprovider.repository.VideoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Component
public class VideoDataprovider implements VideoService {

    private VideoRepository videoRepository;

    @Autowired
    public VideoDataprovider(VideoRepository videoRepository) {
        this.videoRepository = videoRepository;
    }


    @Override
    public Video saveVideo(Video video) {
        return VideoDataproviderMapper
                .convertToDomain(videoRepository.save(VideoDataproviderMapper.convertToDataprovider(video)));
    }

    @Override
    public Video getOne(String id) {
        return VideoDataproviderMapper
                .convertToDomain(videoRepository.findById(UUID.fromString(id)).get());
    }

    @Override
    public List<Video> getAll() {
        return videoRepository
                .findAll().stream()
                .map(videoDataProviderEntity -> VideoDataproviderMapper.convertToDomain(videoDataProviderEntity))
                .collect(Collectors.toList());
    }

    @Override
    public Boolean videoExists(String id) {
        return videoRepository.existsById(UUID.fromString(id));
    }

    @Override
    public void delete(String id) {
        videoRepository.deleteById(UUID.fromString(id));
    }
}
