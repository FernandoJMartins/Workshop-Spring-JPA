package com.projectSpringJPA.project.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.projectSpringJPA.project.entities.OrderItem;
import com.projectSpringJPA.project.entities.pk.OrderItemPK;

public interface OrderItemRepository extends JpaRepository<OrderItem, OrderItemPK> {
}
