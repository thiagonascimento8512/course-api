package com.thiagonascimento.course_api.modules.course.services;

import com.thiagonascimento.course_api.modules.course.entities.CourseEntity;
import com.thiagonascimento.course_api.modules.course.repositories.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.UUID;

@Service
public class UpdateCourseActiveService {

    @Autowired
    private CourseRepository courseRepository;

    public CourseEntity execute(UUID courseId) {
        var course = this.courseRepository.findById(courseId).orElseThrow(
                () -> new RuntimeException("Course not found")
        );

        course.setActive(!course.isActive());
        course.setUpdatedAt(LocalDateTime.now());
        return this.courseRepository.save(course);
    }
}
