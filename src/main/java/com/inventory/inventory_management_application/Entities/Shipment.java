package com.inventory.inventory_management_application.Entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import java.util.Date;

@Entity
public class Shipment {
    @Id
    @GeneratedValue(
            strategy = GenerationType.IDENTITY
    )
    private Long id;
    private Long supplierId;
    private Date shipmentDate;
    private Date arrivalDate;

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getSupplierId() {
        return this.supplierId;
    }

    public void setSupplierId(Long supplierId) {
        this.supplierId = supplierId;
    }

    public Date getShipmentDate() {
        return this.shipmentDate;
    }

    public void setShipmentDate(Date shipmentDate) {
        this.shipmentDate = shipmentDate;
    }

    public Date getArrivalDate() {
        return this.arrivalDate;
    }

    public void setArrivalDate(Date arrivalDate) {
        this.arrivalDate = arrivalDate;
    }

    public Shipment() {
    }

    public Shipment(final Long id, final Long supplierId, final Date shipmentDate, final Date arrivalDate) {
        this.id = id;
        this.supplierId = supplierId;
        this.shipmentDate = shipmentDate;
        this.arrivalDate = arrivalDate;
    }
}

