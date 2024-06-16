package com.thiagonascimento.course_api.modules.course.dtos;

import lombok.Data;

import java.util.UUID;

@Data
public class UpdateCourseDTO {
    private String name;
    private UUID category;
}
