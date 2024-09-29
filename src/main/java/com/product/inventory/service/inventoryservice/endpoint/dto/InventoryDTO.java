package com.product.inventory.service.inventoryservice.endpoint.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class InventoryDTO {
    private Long id;
    private String productName;
    private int quantity;
    private double price;


}