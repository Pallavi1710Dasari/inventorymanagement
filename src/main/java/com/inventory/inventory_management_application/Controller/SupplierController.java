package com.inventory.inventory_management_application.Controller;

import com.inventory.inventory_management_application.Entities.Item;
import com.inventory.inventory_management_application.Entities.Shipment;
import com.inventory.inventory_management_application.Entities.Supplier;
import com.inventory.inventory_management_application.Service.SupplierJpaService;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping({"/suppliers"})
public class SupplierController {
    @Autowired
    private SupplierJpaService supplierService;

    public SupplierController() {
    }

    @PostMapping({"/add"})
    public ResponseEntity<Supplier> addSupplier(@RequestBody Supplier supplier) {
        return ResponseEntity.ok(this.supplierService.addSupplier(supplier));
    }

    @PutMapping({"/update"})
    public ResponseEntity<Supplier> updateSupplier(@RequestBody Supplier supplier) {
        return ResponseEntity.ok(this.supplierService.updateSupplier(supplier));
    }

    @DeleteMapping({"/remove/{supplierId}"})
    public ResponseEntity<Void> removeSupplier(@PathVariable Long supplierId) {
        this.supplierService.removeSupplier(supplierId);
        return ResponseEntity.ok().build();
    }

    @PostMapping({"/restock/{supplierId}"})
    public ResponseEntity<Shipment> placeRestockOrder(@PathVariable Long supplierId, @RequestBody Shipment shipment) {
        return ResponseEntity.ok(this.supplierService.placeRestockOrder(supplierId, shipment));
    }

    @GetMapping({"/shipments/{supplierId}"})
    public ResponseEntity<Optional<Item>> trackIncomingShipments(@PathVariable Long supplierId) {
        return ResponseEntity.ok(this.supplierService.trackIncomingShipments(supplierId));
    }

    @GetMapping
    public ResponseEntity<List<Supplier>> getAllSuppliers() {
        return ResponseEntity.ok(this.supplierService.getAllSuppliers());
    }
}
