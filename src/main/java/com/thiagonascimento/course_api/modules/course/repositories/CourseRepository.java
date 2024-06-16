package com.thiagonascimento.course_api.modules.course.repositories;

import com.thiagonascimento.course_api.modules.course.entities.CourseEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.UUID;

public interface CourseRepository extends JpaRepository<CourseEntity, UUID> {
    List<CourseEntity> findByCategoryId(UUID id);

    @Query("SELECT c FROM course c WHERE LOWER(c.name) LIKE LOWER(CONCAT('%', :name, '%'))")
    List<CourseEntity> findByNameContainingIgnoreCase(@Param("name") String name);
}
