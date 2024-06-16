package com.thiagonascimento.course_api.modules.course.services;

import com.thiagonascimento.course_api.modules.category.repositories.CategoryRepository;
import com.thiagonascimento.course_api.modules.course.dtos.UpdateCourseDTO;
import com.thiagonascimento.course_api.modules.course.entities.CourseEntity;
import com.thiagonascimento.course_api.modules.course.repositories.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.UUID;

@Service
public class UpdateCourseService {

    @Autowired
    private CourseRepository courseRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    public CourseEntity execute(UpdateCourseDTO courseDTO, UUID id) {
        var course = this.courseRepository.findById(id).orElseThrow(
                () -> new RuntimeException("Course not found")
        );

        if (courseDTO.getName() == null && courseDTO.getCategory() == null) {
            throw new RuntimeException("You must provide at least one field to update");
        }

        if (courseDTO.getName() != null) {
            course.setName(courseDTO.getName());
        }

        if (courseDTO.getCategory() != null) {
            var category = this.categoryRepository.findById(courseDTO.getCategory()).orElseThrow(
                    () -> new RuntimeException("Category not found")
            );
            course.setCategory(category);
        }

        course.setUpdatedAt(LocalDateTime.now());

        return this.courseRepository.save(course);
    }
}
