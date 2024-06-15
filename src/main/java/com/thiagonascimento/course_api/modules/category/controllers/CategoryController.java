package com.thiagonascimento.course_api.modules.category.controllers;

import com.thiagonascimento.course_api.modules.category.dtos.CreateCategoryDTO;
import com.thiagonascimento.course_api.modules.category.services.*;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.UUID;

@RestController
@RequestMapping("/category")
public class CategoryController {

    @Autowired
    private CreateCategoryService createCategoryService;

    @Autowired
    private ListAllCategoriesService listAllCategoriesService;

    @Autowired
    private ListCategoryByIdService listCategoryByIdService;

    @Autowired
    private DeleteCategoryService deleteCategoryService;

    @Autowired
    private UpdateCategoryService updateCategoryService;

    @PostMapping("/")
    public ResponseEntity<Object> create(@Valid @RequestBody CreateCategoryDTO categoryDTO) {
        try {
            var category = createCategoryService.execute(categoryDTO);
            return ResponseEntity.ok(category);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping("/")
    public ResponseEntity<Object> get() {
        try {
            var categories = this.listAllCategoriesService.execute();
            return ResponseEntity.ok(categories);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> getById(@PathVariable UUID id) {
        try {
            var category = this.listCategoryByIdService.execute(id);
            return ResponseEntity.ok(category);
        } catch (Exception e) {
            System.out.println(Arrays.toString(e.getStackTrace()));
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> delete(@PathVariable UUID id) {
        try {
            this.deleteCategoryService.execute(id);
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> update(@PathVariable UUID id, @Valid @RequestBody CreateCategoryDTO categoryDTO) {
        try {
            var category = this.updateCategoryService.execute(id, categoryDTO);
            return ResponseEntity.ok(category);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}
