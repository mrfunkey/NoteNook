package com.funkey.notenook.controllers;

import com.funkey.notenook.dtos.ItemRequest;
import com.funkey.notenook.dtos.ItemResponse;
import com.funkey.notenook.services.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/items")
public class ItemController {

    @Autowired
    private ItemService itemService;

    @PostMapping
    public ResponseEntity<ItemResponse> createItem(@RequestBody ItemRequest request){
        ItemResponse response = itemService.createItem(request);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<ItemResponse>> getAllItems(){
        List<ItemResponse> items = itemService.getAll();
        return new ResponseEntity<>(items, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ItemResponse> getById(@PathVariable Long id){
        return new ResponseEntity<>(itemService.getById(id), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteItem(@PathVariable Long id){
        itemService.deleteItem(id);
        return ResponseEntity.noContent().build();
    }


}
