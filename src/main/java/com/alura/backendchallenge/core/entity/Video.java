package com.alura.backendchallenge.core.entity;

import lombok.*;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@EqualsAndHashCode
@ToString
public class Video {
    private String id;
    private String title;
    private String description;
    private String url;
    private Category category;
}
