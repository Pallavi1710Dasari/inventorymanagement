package com.inventory.inventory_management_application.Entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import java.util.Date;
import java.util.List;

@Entity
public class Orders {
    @Id
    @GeneratedValue(
            strategy = GenerationType.IDENTITY
    )
    private Long id;
    private Date orderDate;
    private String status;
    @OneToMany
    @JoinColumn(
            name = "order_id",
            referencedColumnName = "id"
    )
    private List<OrderItem> orderItems;

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getOrderDate() {
        return this.orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    public String getStatus() {
        return this.status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public List<OrderItem> getOrderItems() {
        return this.orderItems;
    }

    public void setOrderItems(List<OrderItem> orderItems) {
        this.orderItems = orderItems;
    }

    public Orders() {
    }

    public Orders(final Long id, final Date orderDate, final String status, final List<OrderItem> orderItems) {
        this.id = id;
        this.orderDate = orderDate;
        this.status = status;
        this.orderItems = orderItems;
    }
}
