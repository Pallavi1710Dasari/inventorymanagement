package com.inventory.inventory_management_application.Service;

import com.inventory.inventory_management_application.Entities.OrderItem;
import com.inventory.inventory_management_application.Entities.Orders;
import com.inventory.inventory_management_application.Repository.OrderJpaRepository;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderJpaService {
    @Autowired
    private OrderJpaRepository orderjpaRepository;
    @Autowired
    private StockJpaService stockjpaService;

    public OrderJpaService() {
    }

    public Orders createOrder(Orders orders) {
        orders.setStatus("NEW");
        Orders savedOrders = (Orders)this.orderjpaRepository.save(orders);
        this.adjustStockLevels(savedOrders);
        return savedOrders;
    }

    public Orders updateOrder(Orders orders) {
        return (Orders)this.orderjpaRepository.save(orders);
    }

    public void cancelOrder(Long orderId) {
        Optional<Orders> orderOpt = this.orderjpaRepository.findById(orderId);
        if (orderOpt.isPresent()) {
            Orders orders = (Orders)orderOpt.get();
            orders.setStatus("CANCELLED");
            this.orderjpaRepository.save(orders);
            this.adjustStockLevels(orders);
        }

    }

    private void adjustStockLevels(Orders orders) {
        Iterator var2 = orders.getOrderItems().iterator();

        while(var2.hasNext()) {
            OrderItem item = (OrderItem)var2.next();
            this.stockjpaService.updateStock(item.getItemId(), item.getQuantity());
        }

    }

    public List<Orders> getAllOrders() {
        return this.orderjpaRepository.findAll();
    }

    public Orders getOrderById(Long orderId) {
        return (Orders)this.orderjpaRepository.findById(orderId).orElse(null);
    }
}
