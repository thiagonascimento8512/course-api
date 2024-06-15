package com.thiagonascimento.course_api.modules.category.services;

import com.thiagonascimento.course_api.modules.category.repositories.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class DeleteCategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    public void execute(UUID id) {
        try {
            var category = this.categoryRepository.findById(id).orElseThrow(
                    () -> new RuntimeException("Category not found")
            );
            this.categoryRepository.delete(category);
        } catch (Exception e) {
            throw new RuntimeException("Category not found");
        }
    }
}
