package com.thiagonascimento.course_api.modules.course.services;

import com.thiagonascimento.course_api.modules.course.entities.CourseEntity;
import com.thiagonascimento.course_api.modules.course.repositories.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class ListCoursesByCategoryIdService {

    @Autowired
    private CourseRepository courseRepository;

    public List<CourseEntity> execute(UUID categoryId) {
        try {
            return this.courseRepository.findByCategoryId(categoryId);
        } catch (Exception e) {
            throw new RuntimeException("Error to list courses by category id");
        }
    }
}
