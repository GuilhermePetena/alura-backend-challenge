package com.alura.backendchallenge.entrypoint.mapper;

import com.alura.backendchallenge.core.entity.Video;
import com.alura.backendchallenge.entrypoint.model.VideoEntrypointModel;
import org.springframework.stereotype.Component;

@Component
public class VideoEntrypointMapper {
    public static Video convertToDomain(VideoEntrypointModel videoEntrypointModel) {
        return Video.builder()
                .id(videoEntrypointModel.getId())
                .description(videoEntrypointModel.getDescription())
                .title(videoEntrypointModel.getTitle())
                .url(videoEntrypointModel.getUrl())
                .category(CategoryEntrypointMapper.convertToDomain(videoEntrypointModel.getCategory()))
                .build();
    }

    public static VideoEntrypointModel convertToEntrypoint(Video video) {
        return VideoEntrypointModel.builder()
                .id(video.getId())
                .description(video.getDescription())
                .title(video.getTitle())
                .url(video.getUrl())
                .category(CategoryEntrypointMapper.convertToEntrypoint(video.getCategory()))
                .build();
    }
}
