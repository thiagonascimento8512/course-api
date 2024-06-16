package com.thiagonascimento.course_api.modules.course.controllers;

import com.thiagonascimento.course_api.modules.course.dtos.CreateCourseDTO;
import com.thiagonascimento.course_api.modules.course.dtos.UpdateCourseDTO;
import com.thiagonascimento.course_api.modules.course.services.*;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/courses")
public class CourseController {

    @Autowired
    private CreateCourseService createCourseService;

    @Autowired
    private ListAllCoursesService listAllCoursesService;

    @Autowired
    private ListCoursesByCategoryIdService listCoursesByCategoryIdService;

    @Autowired
    private ListCourseByNameService listCourseByNameService;

    @Autowired
    private UpdateCourseService updateCourseService;

    @Autowired
    private DeleteCourseService deleteCourseService;

    @Autowired
    private UpdateCourseActiveService updateCourseActiveService;

    @PostMapping("/")
    public ResponseEntity<Object> create(@Valid @RequestBody CreateCourseDTO courseDTO) {
        try {
            return ResponseEntity.ok(this.createCourseService.execute(courseDTO));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping("/")
    public ResponseEntity<Object> list() {
        try {
            return ResponseEntity.ok(this.listAllCoursesService.execute());
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping(params = "categoryId")
    public ResponseEntity<Object> list(@RequestParam UUID categoryId) {
        try {
            return ResponseEntity.ok(this.listCoursesByCategoryIdService.execute(categoryId));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping(params = "name")
    public ResponseEntity<Object> list(@RequestParam String name) {
        try {
            return ResponseEntity.ok(this.listCourseByNameService.execute(name));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> update(@Valid @RequestBody UpdateCourseDTO courseDTO, @PathVariable UUID id) {
        try {
            return ResponseEntity.ok(this.updateCourseService.execute(courseDTO, id));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> delete(@PathVariable UUID id) {
        try {
            this.deleteCourseService.execute(id);
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PatchMapping("/{id}/active")
    public ResponseEntity<Object> active(@PathVariable UUID id) {
        try {
            return ResponseEntity.ok(this.updateCourseActiveService.execute(id));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}
