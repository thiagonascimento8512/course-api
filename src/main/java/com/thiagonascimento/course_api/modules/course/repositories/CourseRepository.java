package com.thiagonascimento.course_api.modules.course.repositories;

import com.thiagonascimento.course_api.modules.course.entities.CourseEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface CourseRepository extends JpaRepository<CourseEntity, UUID> {
}
