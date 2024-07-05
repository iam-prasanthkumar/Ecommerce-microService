package com.ecommerce.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecommerce.entity.Inventory;
import com.ecommerce.exception.InventoryNotFoundException;
import com.ecommerce.repo.InventoryRepository;

@Service
public class InventoryServiceImpl implements InventoryService {

    @Autowired
    private InventoryRepository inventoryRepository;

    @Override
    public Inventory addInventory(int productId, int quantity) {
        Inventory inventory = new Inventory();
        inventory.setProductId(productId);
        inventory.setQuantity(quantity);
        return inventoryRepository.save(inventory);
    }

    @Override
    public void deleteInventory(int productId) {
        Inventory inventory = inventoryRepository.findByProductId(productId);
        if (inventory == null) {
            throw new InventoryNotFoundException("Inventory not found for product id: " + productId);
        }
        inventoryRepository.deleteByProductId(productId);
    }

    @Override
    public Inventory updateInventory(int productId, int quantity) {
        Inventory inventory = inventoryRepository.findByProductId(productId);
        if (inventory == null) {
            throw new InventoryNotFoundException("Inventory not found for product id: " + productId);
        }
        inventory.setQuantity(quantity);
        return inventoryRepository.save(inventory);
    }

    @Override
    public Inventory searchInventory(int productId) {
        Inventory inventory = inventoryRepository.findByProductId(productId);
        if (inventory == null) {
            throw new InventoryNotFoundException("Inventory not found for product id: " + productId);
        }
        return inventory;
    }
}
