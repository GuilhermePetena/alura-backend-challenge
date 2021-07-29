package com.alura.backendchallenge.core.service;

import com.alura.backendchallenge.core.entity.Video;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public interface VideoService {
    Video saveVideo(Video video);
    Video getOne(String id);
    List<Video> getAll();
    Boolean videoExists(String id);
    void delete(String id);
}
