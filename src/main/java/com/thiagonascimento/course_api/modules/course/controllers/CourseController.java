package com.thiagonascimento.course_api.modules.course.controllers;

import com.thiagonascimento.course_api.modules.course.dtos.CreateCourseDTO;
import com.thiagonascimento.course_api.modules.course.services.CreateCourseService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/course")
public class CourseController {

    @Autowired
    private CreateCourseService createCourseService;

    @PostMapping("/")
    public ResponseEntity<Object> create(@Valid @RequestBody CreateCourseDTO courseDTO) {
        try {
            return ResponseEntity.ok(this.createCourseService.execute(courseDTO));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Error to create course");
        }
    }
}
