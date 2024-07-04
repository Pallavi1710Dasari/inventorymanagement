package com.inventory.inventory_management_application.Service;

import com.inventory.inventory_management_application.Entities.Orders;
import com.inventory.inventory_management_application.Entities.Stock;
import com.inventory.inventory_management_application.Entities.Supplier;
import com.inventory.inventory_management_application.Repository.OrderJpaRepository;
import com.inventory.inventory_management_application.Repository.StockJpaRepository;
import com.inventory.inventory_management_application.Repository.SupplierJpaRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReportJpaService {
    @Autowired
    private StockJpaRepository stockRepository;
    @Autowired
    private OrderJpaRepository orderRepository;
    @Autowired
    private SupplierJpaRepository supplierRepository;

    public ReportJpaService() {
    }

    public List<Stock> generateStockLevelReport() {
        return this.stockRepository.findAll();
    }

    public List<Orders> generateOrderStatusReport() {
        return this.orderRepository.findAll();
    }

    public List<Supplier> generateSupplierPerformanceReport() {
        return this.supplierRepository.findAll();
    }
}
