package com.alura.backendchallenge.entrypoint.controller;

import com.alura.backendchallenge.core.service.VideoService;
import com.alura.backendchallenge.entrypoint.mapper.VideoEntrypointMapper;
import com.alura.backendchallenge.entrypoint.model.VideoEntrypointModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/video")
public class VideoController {

    private VideoService videoService;

    @Autowired
    public VideoController(VideoService videoService) {
        this.videoService = videoService;
    }

    @GetMapping
    public ResponseEntity<List<VideoEntrypointModel>> getAllVideos() {
        return ResponseEntity.ok()
                .body(videoService.getAll()
                        .stream()
                        .map(VideoEntrypointMapper::convertToEntrypoint)
                        .collect(Collectors.toList()));
    }

    @GetMapping("/{id}")
    public ResponseEntity<VideoEntrypointModel> getVideo(@PathVariable String id) {
        if (Objects.nonNull(id) && videoService.videoExists(id)) {
            return ResponseEntity.ok().body(VideoEntrypointMapper.convertToEntrypoint(videoService.getOne(id)));
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<VideoEntrypointModel> saveVideo(@Valid @RequestBody VideoEntrypointModel videoEntrypointModel) {
        if (Objects.nonNull(videoEntrypointModel)) {
            return ResponseEntity
                    .status(HttpStatus.CREATED)
                    .body(VideoEntrypointMapper
                            .convertToEntrypoint(videoService.saveVideo(VideoEntrypointMapper.convertToDomain(videoEntrypointModel))));
        }
        return ResponseEntity.badRequest().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteVideo(@PathVariable String id) {
        if (Objects.nonNull(id) && videoService.videoExists(id)) {
            videoService.delete(id);
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.notFound().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<VideoEntrypointModel> updateVideo(@PathVariable String id, @Valid @RequestBody VideoEntrypointModel videoEntrypointModel) {
        if (Objects.nonNull(id) && videoService.videoExists(id)) {
            return ResponseEntity.ok().body(VideoEntrypointMapper.convertToEntrypoint(videoService.saveVideo(VideoEntrypointMapper.convertToDomain(videoEntrypointModel))));
        }
        return ResponseEntity.notFound().build();
    }
}
