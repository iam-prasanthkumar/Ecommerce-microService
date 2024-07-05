package com.ecommerce.service;

import com.ecommerce.entity.Inventory;

public interface InventoryService {
    Inventory addInventory(int productId, int quantity);
    void deleteInventory(int productId);
    Inventory updateInventory(int productId, int quantity);
    Inventory searchInventory(int productId);
}
