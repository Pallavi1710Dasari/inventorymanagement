package com.inventory.inventory_management_application.Service;

import com.inventory.inventory_management_application.Entities.Item;
import com.inventory.inventory_management_application.Entities.Shipment;
import com.inventory.inventory_management_application.Entities.Supplier;
import com.inventory.inventory_management_application.Repository.ItemJpaRepository;
import com.inventory.inventory_management_application.Repository.SupplierJpaRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SupplierJpaService {
    @Autowired
    private SupplierJpaRepository supplierjpaRepository;
    @Autowired
    private ItemJpaRepository shipmentRepository;

    public SupplierJpaService() {
    }

    public Supplier addSupplier(Supplier supplier) {
        return (Supplier)this.supplierjpaRepository.save(supplier);
    }

    public Supplier updateSupplier(Supplier supplier) {
        return (Supplier)this.supplierjpaRepository.save(supplier);
    }

    public void removeSupplier(Long supplierId) {
        this.supplierjpaRepository.deleteById(supplierId);
    }

    public Shipment placeRestockOrder(Long supplierId, Shipment shipment) {
        shipment.setSupplierId(supplierId);
        return this.shipmentRepository.save(shipment);
    }

    public Optional<Item> trackIncomingShipments(Long supplierId) {
        return this.shipmentRepository.findById(supplierId);
    }

    public List<Supplier> getAllSuppliers() {
        return this.supplierjpaRepository.findAll();
    }
}
