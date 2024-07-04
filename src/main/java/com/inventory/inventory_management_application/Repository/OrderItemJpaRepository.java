package com.inventory.inventory_management_application.Repository;

import com.inventory.inventory_management_application.Entities.OrderItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderItemJpaRepository extends JpaRepository<OrderItem, Long> {
}