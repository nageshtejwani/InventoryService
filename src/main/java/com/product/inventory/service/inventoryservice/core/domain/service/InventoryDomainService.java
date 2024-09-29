package com.product.inventory.service.inventoryservice.core.domain.service;

import com.product.inventory.service.inventoryservice.core.domain.entity.Inventory;

public class InventoryDomainService {
    public boolean isStockAvailable(Inventory inventory, int requiredQuantity) {
        return inventory.getQuantity() >= requiredQuantity;
    }

    public void addStock(Inventory inventory, int quantityToAdd) {
        int newQuantity = inventory.getQuantity() + quantityToAdd;
        inventory.setQuantity(newQuantity);
    }

    public void reduceStock(Inventory inventory, int quantityToReduce) {
        int newQuantity = inventory.getQuantity() - quantityToReduce;
        if (newQuantity < 0) {
            throw new IllegalArgumentException("Insufficient stock");
        }
        inventory.setQuantity(newQuantity);
    }
}
