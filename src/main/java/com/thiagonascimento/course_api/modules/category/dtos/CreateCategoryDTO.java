package com.thiagonascimento.course_api.modules.category.dtos;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class CreateCategoryDTO {
    @NotNull(message = "Name is required")
    private String name;
}
