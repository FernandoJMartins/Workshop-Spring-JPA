package com.projectSpringJPA.project.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.projectSpringJPA.project.entities.Category;

public interface CategoryRepository extends JpaRepository<Category, Long> {
}
