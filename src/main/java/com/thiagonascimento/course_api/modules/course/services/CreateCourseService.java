package com.thiagonascimento.course_api.modules.course.services;

import com.thiagonascimento.course_api.modules.category.repositories.CategoryRepository;
import com.thiagonascimento.course_api.modules.course.dtos.CreateCourseDTO;
import com.thiagonascimento.course_api.modules.course.entities.CourseEntity;
import com.thiagonascimento.course_api.modules.course.repositories.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CreateCourseService {

    @Autowired
    private CourseRepository courseRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    public CourseEntity execute(CreateCourseDTO courseDTO) {
        var category = this.categoryRepository.findById(courseDTO.getCategoryId()).orElseThrow(() -> new RuntimeException("Category not found"));

        try {
            var course = CourseEntity.builder()
                    .name(courseDTO.getName())
                    .category(category)
                    .active(courseDTO.isActive())
                    .build();

            return this.courseRepository.save(course);
        } catch (Exception e) {
            throw new RuntimeException("Error to create course");
        }
    }
}
