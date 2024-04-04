package com.projectSpringJPA.project.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.projectSpringJPA.project.entities.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
