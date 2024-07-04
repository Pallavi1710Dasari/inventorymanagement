package com.inventory.inventory_management_application.Controller;

import com.inventory.inventory_management_application.Entities.Orders;
import com.inventory.inventory_management_application.Service.OrderJpaService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping({"/orders"})
public class OrderController {
    @Autowired
    private OrderJpaService orderService;

    public OrderController() {
    }

    @PostMapping({"/create"})
    public ResponseEntity<Orders> createOrder(@RequestBody Orders orders) {
        return ResponseEntity.ok(this.orderService.createOrder(orders));
    }

    @PutMapping({"/update"})
    public ResponseEntity<Orders> updateOrder(@RequestBody Orders orders) {
        return ResponseEntity.ok(this.orderService.updateOrder(orders));
    }

    @PutMapping({"/cancel/{orderId}"})
    public ResponseEntity<Void> cancelOrder(@PathVariable Long orderId) {
        this.orderService.cancelOrder(orderId);
        return ResponseEntity.ok().build();
    }

    @GetMapping
    public ResponseEntity<List<Orders>> getAllOrders() {
        return ResponseEntity.ok(this.orderService.getAllOrders());
    }

    @GetMapping({"/{orderId}"})
    public ResponseEntity<Orders> getOrderById(@PathVariable Long orderId) {
        return ResponseEntity.ok(this.orderService.getOrderById(orderId));
    }
}
