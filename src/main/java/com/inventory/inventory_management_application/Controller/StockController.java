package com.inventory.inventory_management_application.Controller;

import com.inventory.inventory_management_application.Entities.Item;
import com.inventory.inventory_management_application.Entities.Stock;
import com.inventory.inventory_management_application.Service.StockJpaService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping({"/stock"})
public class StockController {
    @Autowired
    private StockJpaService stockService;

    public StockController() {
    }

    @PostMapping({"/addItem"})
    public ResponseEntity<Item> addItem(@RequestBody Item item) {
        return ResponseEntity.ok(this.stockService.addItem(item));
    }

    @PutMapping({"/updateStock/{itemId}"})
    public ResponseEntity<Stock> updateStock(@PathVariable Long itemId, @RequestParam int quantity) {
        return ResponseEntity.ok(this.stockService.updateStock(itemId, quantity));
    }

    @DeleteMapping({"/removeItem/{itemId}"})
    public ResponseEntity<Void> removeItem(@PathVariable Long itemId) {
        this.stockService.removeItem(itemId);
        return ResponseEntity.ok().build();
    }

    @GetMapping({"/lowStock"})
    public ResponseEntity<List<Stock>> getLowStockItems(@RequestParam int threshold) {
        return ResponseEntity.ok(this.stockService.getLowStockItems(threshold));
    }

    @GetMapping({"/items"})
    public ResponseEntity<List<Item>> getAllItems() {
        return ResponseEntity.ok(this.stockService.getAllItems());
    }
}
