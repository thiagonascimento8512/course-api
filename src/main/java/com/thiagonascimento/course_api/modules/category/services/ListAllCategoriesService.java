package com.thiagonascimento.course_api.modules.category.services;

import com.thiagonascimento.course_api.modules.category.entities.CategoryEntity;
import com.thiagonascimento.course_api.modules.category.repositories.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ListAllCategoriesService {

    @Autowired
    private CategoryRepository categoryRepository;

    public List<CategoryEntity> execute() {
        var categories = this.categoryRepository.findAll();

        System.out.println("Categories:");

        categories.forEach(category -> {
            System.out.println("Category: " + category.getName());
            category.getCourses().forEach(course -> {
                System.out.println("Course: " + course.getName());
            });
        });

        return categories;
    }
}
