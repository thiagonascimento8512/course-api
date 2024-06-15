package com.thiagonascimento.course_api.modules.category.entities;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.thiagonascimento.course_api.modules.course.entities.CourseEntity;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.util.List;
import java.util.UUID;

@Data
@Entity(name = "category")
public class CategoryEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @NotNull(message = "Name is required")
    private String name;

    @OneToMany(mappedBy = "category", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JsonManagedReference
    private List<CourseEntity> courses;
}
