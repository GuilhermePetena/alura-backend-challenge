package com.alura.backendchallenge.dataprovider.mapper;

import com.alura.backendchallenge.core.entity.Video;
import com.alura.backendchallenge.dataprovider.entity.VideoDataproviderEntity;
import org.springframework.stereotype.Component;
import java.util.UUID;
@Component
public class VideoDataproviderMapper {

    public static Video convertToDomain(VideoDataproviderEntity videoDataProvider) {
        return Video.builder()
                .id(videoDataProvider.getId().toString())
                .description(videoDataProvider.getDescription())
                .title(videoDataProvider.getTitle())
                .url(videoDataProvider.getUrl())
                .category(CategoryDataproviderMapper.convertToDomain(videoDataProvider.getCategory()))
                .build();
    }

    public static VideoDataproviderEntity convertToDataprovider(Video video) {
        return VideoDataproviderEntity.builder()
                .id(UUID.fromString(video.getId()))
                .description(video.getDescription())
                .title(video.getTitle())
                .url(video.getUrl())
                .category(CategoryDataproviderMapper.convertToDataprovider(video.getCategory()))
                .build();
    }
}
