package com.inventory.inventory_management_application.Repository;

import com.inventory.inventory_management_application.Entities.Supplier;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SupplierJpaRepository extends JpaRepository<Supplier, Long> {
    Optional<Supplier> findByName(String name);
}