package com.alura.backendchallenge.entrypoint.model;

import lombok.*;

import javax.validation.constraints.NotBlank;
import java.util.UUID;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
@EqualsAndHashCode
public class CategoryEntrypointModel {
    private String id = UUID.randomUUID().toString();
    @NotBlank(message = "O Campo titulo nao deve ser nulo ou vazio.")
    private String title;
    @NotBlank(message = "O Campo cor nao deve ser nulo ou vazio.")
    private String color;
}
