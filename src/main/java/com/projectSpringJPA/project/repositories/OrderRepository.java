package com.projectSpringJPA.project.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.projectSpringJPA.project.entities.Order;

public interface OrderRepository extends JpaRepository<Order, Long> {
}
