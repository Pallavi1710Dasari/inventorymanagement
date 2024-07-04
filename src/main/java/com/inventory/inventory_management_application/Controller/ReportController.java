package com.inventory.inventory_management_application.Controller;

import com.inventory.inventory_management_application.Entities.Orders;
import com.inventory.inventory_management_application.Entities.Stock;
import com.inventory.inventory_management_application.Entities.Supplier;
import com.inventory.inventory_management_application.Service.ReportJpaService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping({"/reports"})
public class ReportController {
    @Autowired
    private ReportJpaService reportService;

    public ReportController() {
    }

    @GetMapping({"/stockLevels"})
    public ResponseEntity<List<Stock>> generateStockLevelReport() {
        return ResponseEntity.ok(this.reportService.generateStockLevelReport());
    }

    @GetMapping({"/orderStatuses"})
    public ResponseEntity<List<Orders>> generateOrderStatusReport() {
        return ResponseEntity.ok(this.reportService.generateOrderStatusReport());
    }

    @GetMapping({"/supplierPerformance"})
    public ResponseEntity<List<Supplier>> generateSupplierPerformanceReport() {
        return ResponseEntity.ok(this.reportService.generateSupplierPerformanceReport());
    }
}
