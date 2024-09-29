package com.product.inventory.service.inventoryservice.application.converter;

import com.product.inventory.service.inventoryservice.core.domain.entity.Inventory;
import com.product.inventory.service.inventoryservice.endpoint.dto.InventoryDTO;

public class InventoryConverter {

    public static InventoryDTO toDTO(Inventory inventory) {
        return new InventoryDTO(
                inventory.getId(),
                inventory.getProductName(),
                inventory.getQuantity(),
                inventory.getPrice()
        );
    }

    public static Inventory toEntity(InventoryDTO inventoryDTO) {
        return new Inventory(
                inventoryDTO.getProductName(),
                inventoryDTO.getQuantity(),
                inventoryDTO.getPrice()
        );
    }
}