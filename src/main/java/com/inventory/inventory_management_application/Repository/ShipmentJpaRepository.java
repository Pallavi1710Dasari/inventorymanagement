package com.inventory.inventory_management_application.Repository;

import com.inventory.inventory_management_application.Entities.Shipment;
import java.util.Date;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ShipmentJpaRepository extends JpaRepository<Shipment, Long> {
    List<Shipment> findBySupplierId(Long supplierId);

    List<Shipment> findByArrivalDateBetween(Date startDate, Date endDate);
}