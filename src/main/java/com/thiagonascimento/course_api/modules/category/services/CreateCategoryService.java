package com.thiagonascimento.course_api.modules.category.services;

import com.thiagonascimento.course_api.Exceptions.FoundException;
import com.thiagonascimento.course_api.modules.category.dtos.CreateCategoryDTO;
import com.thiagonascimento.course_api.modules.category.entities.CategoryEntity;
import com.thiagonascimento.course_api.modules.category.repositories.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CreateCategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    public CategoryEntity execute(CreateCategoryDTO category) {
        this.categoryRepository.findByName(category.getName())
                .ifPresent(c -> {
                    throw new FoundException("Category already exists");
                });

        CategoryEntity newCategory = new CategoryEntity();
        newCategory.setName(category.getName());

        return this.categoryRepository.save(newCategory);
    }
}
