package com.thiagonascimento.course_api.modules.category.dtos;

import com.thiagonascimento.course_api.modules.course.entities.CourseEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.UUID;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ListCategoryByIdDTO {
    private String name;
    private UUID id;
    private List<CourseEntity> courses;
}
