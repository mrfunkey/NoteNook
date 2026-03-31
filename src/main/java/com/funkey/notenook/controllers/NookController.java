package com.funkey.notenook.controllers;

import com.funkey.notenook.dtos.NookRequest;
import com.funkey.notenook.dtos.NookResponse;
import com.funkey.notenook.services.NookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/nooks")
public class NookController {

    @Autowired
    private NookService nookService;

    @PostMapping
    public ResponseEntity<NookResponse> createNook(@RequestBody NookRequest request){
        NookResponse response = nookService.createNook(request);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<NookResponse>> getAllNooks(){
        List<NookResponse> response = nookService.getAll();
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<NookResponse> getById(@PathVariable UUID id){
        return new ResponseEntity<>(nookService.getById(id), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteNook(@PathVariable UUID id){
        nookService.deleteNook(id);
        return ResponseEntity.noContent().build();
    }



}

