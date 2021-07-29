package com.alura.backendchallenge.core.entity;

import lombok.*;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@EqualsAndHashCode
@ToString
public class Category {
    private String id;
    private String title;
    private String color;
}
