package com.inventory.inventory_management_application.Service;

import com.inventory.inventory_management_application.Entities.Item;
import com.inventory.inventory_management_application.Entities.Stock;
import com.inventory.inventory_management_application.Repository.ItemJpaRepository;
import com.inventory.inventory_management_application.Repository.StockJpaRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StockJpaService {
    @Autowired
    private StockJpaRepository stockjpaRepository;
    @Autowired
    private ItemJpaRepository itemjpaRepository;

    public StockJpaService() {
    }

    public Item addItem(Item item) {
        return (Item)this.itemjpaRepository.save(item);
    }

    public Stock updateStock(Long itemId, int quantity) {
        Optional<Stock> stockOpt = this.stockjpaRepository.findByItemId(itemId);
        Stock stock;
        if (stockOpt.isPresent()) {
            stock = (Stock)stockOpt.get();
            stock.setQuantity(quantity);
        } else {
            stock = new Stock();
            stock.setItemId(itemId);
            stock.setQuantity(quantity);
        }

        return (Stock)this.stockjpaRepository.save(stock);
    }

    public void removeItem(Long itemId) {
        this.itemjpaRepository.deleteById(itemId);
        this.stockjpaRepository.deleteById(itemId);
    }

    public List<Stock> getLowStockItems(int threshold) {
        return this.stockjpaRepository.findByQuantityLessThan(threshold);
    }

    public List<Item> getAllItems() {
        return this.itemjpaRepository.findAll();
    }
}
