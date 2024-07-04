package com.inventory.inventory_management_application.Repository;

import com.inventory.inventory_management_application.Entities.Item;
import com.inventory.inventory_management_application.Entities.Shipment;
import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemJpaRepository extends JpaRepository<Item, Long> {
    Optional<Item> findByName(String name);

    List<Item> findByDescriptionContaining(String keyword);

    Shipment save(Shipment shipment);
}
