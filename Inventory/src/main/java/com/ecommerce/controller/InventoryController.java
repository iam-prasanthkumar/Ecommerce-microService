package com.ecommerce.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ecommerce.entity.Inventory;
import com.ecommerce.service.InventoryService;

@RestController
@RequestMapping("/api")
public class InventoryController {

    @Autowired
    private InventoryService inventoryService;

    @PostMapping("/inventory")
    public ResponseEntity<Inventory> addInventory(@RequestParam int productId, @RequestParam int quantity) {
        Inventory inventory = inventoryService.addInventory(productId, quantity);
        return new ResponseEntity<>(inventory, HttpStatus.CREATED);
    }

    @DeleteMapping("/inventory/{id}")
    public ResponseEntity<Void> deleteInventory(@PathVariable int productId) {
        inventoryService.deleteInventory(productId);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping("/inventory/{id}")
    public ResponseEntity<Inventory> updateInventory(@PathVariable int productId, @RequestParam int quantity) {
        Inventory inventory = inventoryService.updateInventory(productId, quantity);
        return new ResponseEntity<>(inventory, HttpStatus.OK);
    }

    @GetMapping("/inventory/{id}")
    public ResponseEntity<Inventory> searchInventory(@PathVariable int productId) {
        Inventory inventory = inventoryService.searchInventory(productId);
        return new ResponseEntity<>(inventory, HttpStatus.OK);
    }
}
