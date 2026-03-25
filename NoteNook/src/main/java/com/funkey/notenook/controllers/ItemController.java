package com.funkey.notenook.controllers;

import com.funkey.notenook.dtos.ItemRequest;
import com.funkey.notenook.dtos.ItemResponse;
import com.funkey.notenook.services.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/item")
public class ItemController {

    @Autowired
    private ItemService itemService;

    @PostMapping
    public ResponseEntity<ItemResponse> createItem(@RequestBody ItemRequest request){
        ItemResponse response = itemService.createItem(request);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteItem(@PathVariable Long id){
        itemService.deleteItem(id);
        return ResponseEntity.noContent().build();
    }
}
