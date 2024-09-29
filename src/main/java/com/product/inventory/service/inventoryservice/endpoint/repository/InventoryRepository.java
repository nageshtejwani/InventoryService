package com.product.inventory.service.inventoryservice.endpoint.repository;

import com.product.inventory.service.inventoryservice.core.domain.entity.Inventory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InventoryRepository extends JpaRepository<Inventory, Long> {
}