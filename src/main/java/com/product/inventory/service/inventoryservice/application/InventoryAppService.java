package com.product.inventory.service.inventoryservice.application;

import com.product.inventory.service.inventoryservice.core.domain.entity.Inventory;
import com.product.inventory.service.inventoryservice.core.domain.service.InventoryDomainService;
import com.product.inventory.service.inventoryservice.application.converter.InventoryConverter;
import com.product.inventory.service.inventoryservice.endpoint.dto.InventoryDTO;
import com.product.inventory.service.inventoryservice.endpoint.repository.InventoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class InventoryAppService {

    private final InventoryRepository inventoryRepository;
    private final InventoryDomainService inventoryDomainService;

    @Autowired
    public InventoryAppService(InventoryRepository inventoryRepository, InventoryDomainService inventoryDomainService) {
        this.inventoryRepository = inventoryRepository;
        this.inventoryDomainService = inventoryDomainService;
    }

    public InventoryDTO addInventory(InventoryDTO inventoryDTO) {
        Inventory inventory = InventoryConverter.toEntity(inventoryDTO);
        Inventory savedInventory = inventoryRepository.save(inventory);
        return InventoryConverter.toDTO(savedInventory);
    }

    public Optional<InventoryDTO> getInventoryById(Long id) {
        return inventoryRepository.findById(id)
                .map(InventoryConverter::toDTO);
    }

    public void addStock(Long inventoryId, int quantityToAdd) {
        Inventory inventory = inventoryRepository.findById(inventoryId)
                .orElseThrow(() -> new IllegalArgumentException("Inventory not found"));
        inventoryDomainService.addStock(inventory, quantityToAdd);
        inventoryRepository.save(inventory);
    }

    public void reduceStock(Long inventoryId, int quantityToReduce) {
        Inventory inventory = inventoryRepository.findById(inventoryId)
                .orElseThrow(() -> new IllegalArgumentException("Inventory not found"));
        inventoryDomainService.reduceStock(inventory, quantityToReduce);
        inventoryRepository.save(inventory);
    }

    public boolean isStockAvailable(Long inventoryId, int requiredQuantity) {
        Inventory inventory = inventoryRepository.findById(inventoryId)
                .orElseThrow(() -> new IllegalArgumentException("Inventory not found"));
        return inventoryDomainService.isStockAvailable(inventory, requiredQuantity);
    }
}