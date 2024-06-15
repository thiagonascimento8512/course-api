package com.thiagonascimento.course_api.modules.course.dtos;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.util.UUID;

@Data
public class CreateCourseDTO {
    @NotNull(message = "Name is required")
    private String name;

    @NotNull(message = "Category is required")
    private UUID categoryId;

    @NotNull(message = "Active is required")
    private boolean active;
}
