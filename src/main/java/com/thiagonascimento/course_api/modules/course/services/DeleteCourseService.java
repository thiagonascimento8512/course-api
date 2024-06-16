package com.thiagonascimento.course_api.modules.course.services;

import com.thiagonascimento.course_api.modules.course.repositories.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class DeleteCourseService {

    @Autowired
    private CourseRepository courseRepository;

    public void execute(UUID id) {
        var course = this.courseRepository.findById(id).orElseThrow(
                () -> new RuntimeException("Course not found")
        );

        this.courseRepository.delete(course);
    }
}
