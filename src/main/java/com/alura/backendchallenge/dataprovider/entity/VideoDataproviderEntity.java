package com.alura.backendchallenge.dataprovider.entity;

import lombok.*;
import org.springframework.data.jpa.domain.AbstractPersistable;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.UUID;

@Table(name = "video")
@Entity(name = "video")
@EqualsAndHashCode
@ToString
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class VideoDataproviderEntity {
    @Id
    @Column(name = "id")
    private UUID id;
    @Column(nullable = false)
    @Size(min = 2, max = 255, message = "O campo titulo não deve ser vazio ou conter menos de 2 caracteres.")
    private String title;
    @Column(nullable = false, length = 1500)
    private String description;
    @Column(nullable = false)
    @Size(min = 5, max = 255, message = "O campo url não deve ser vazio ou conter menos de 5 caracteres.")
    private String url;
    @OneToMany
    private CategoryDataproviderEntity category;
}