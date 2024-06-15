package com.thiagonascimento.course_api.modules.category.services;

import com.thiagonascimento.course_api.modules.category.entities.CategoryEntity;
import com.thiagonascimento.course_api.modules.category.repositories.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class ListCategoryByIdService {

    @Autowired
    private CategoryRepository categoryRepository;

    public CategoryEntity execute(UUID id) {
        return this.categoryRepository.findById(id).orElseThrow(
                () -> new RuntimeException("Category not found")
        );
    }
}
