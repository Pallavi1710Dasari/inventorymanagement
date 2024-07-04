package com.inventory.inventory_management_application.Repository;

import com.inventory.inventory_management_application.Entities.Orders;
import java.util.Date;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderJpaRepository extends JpaRepository<Orders, Long> {
    List<Orders> findByStatus(String status);

    List<Orders> findByOrderDateBetween(Date startDate, Date endDate);
}
