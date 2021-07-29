package com.alura.backendchallenge.dataprovider.entity;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import java.util.UUID;

@Table(name = "category")
@Entity(name = "category")
@EqualsAndHashCode
@ToString
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CategoryDataproviderEntity {
    @Id
    @Column(name = "id")
    private UUID id;
    @Column(nullable = false)
    @Size(min = 2, max = 255, message = "O campo titulo não deve ser vazio ou conter menos de 2 caracteres.")
    private String title;
    @Column(nullable = false)
    @Size(min = 2, max = 255, message = "O campo cor não deve ser vazio ou conter menos de 5 caracteres.")
    private String color;
}
