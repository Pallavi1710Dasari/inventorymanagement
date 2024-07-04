package com.inventory.inventory_management_application.Repository;

import com.inventory.inventory_management_application.Entities.Stock;
import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StockJpaRepository extends JpaRepository<Stock, Long> {
    Optional<Stock> findByItemId(Long itemId);

    List<Stock> findByQuantityLessThan(int quantity);
}
