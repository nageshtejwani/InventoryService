package com.product.inventory.service.inventoryservice.endpoint.controller;

import com.product.inventory.service.inventoryservice.application.InventoryAppService;
import com.product.inventory.service.inventoryservice.endpoint.dto.InventoryDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/inventory")
public class InventoryController {

    private final InventoryAppService inventoryAppService;

    @Autowired
    public InventoryController(InventoryAppService inventoryAppService) {
        this.inventoryAppService = inventoryAppService;
    }

    @PostMapping
    public InventoryDTO addInventory(@RequestBody InventoryDTO inventoryDTO) {
        return inventoryAppService.addInventory(inventoryDTO);
    }

    @GetMapping("/{id}")
    public Optional<InventoryDTO> getInventoryById(@PathVariable Long id) {
        return inventoryAppService.getInventoryById(id);
    }

    @PostMapping("/{id}/addStock")
    public void addStock(@PathVariable Long id, @RequestParam int quantity) {
        inventoryAppService.addStock(id, quantity);
    }

    @PostMapping("/{id}/reduceStock")
    public void reduceStock(@PathVariable Long id, @RequestParam int quantity) {
        inventoryAppService.reduceStock(id, quantity);
    }

    @GetMapping("/{id}/isStockAvailable")
    public boolean isStockAvailable(@PathVariable Long id, @RequestParam int requiredQuantity) {
        return inventoryAppService.isStockAvailable(id, requiredQuantity);
    }
}