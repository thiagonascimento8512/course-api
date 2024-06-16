package com.thiagonascimento.course_api.modules.course.services;

import com.thiagonascimento.course_api.modules.course.entities.CourseEntity;
import com.thiagonascimento.course_api.modules.course.repositories.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ListAllCoursesService {

    @Autowired
    private CourseRepository courseRepository;

    public List<CourseEntity> execute() {
        return this.courseRepository.findAll();
    }
}
