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
public class VideoEntrypointModel {
    private String id = UUID.randomUUID().toString();
    @NotBlank(message = "O Campo title nao deve ser nulo ou vazio.")
    private String title;
    @NotBlank(message = "O Campo description nao deve ser nulo ou vazio.")
    private String description;
    @NotBlank(message = "O Campo url nao deve ser nulo ou vazio.")
    private String url;
    private CategoryEntrypointModel category;
}
