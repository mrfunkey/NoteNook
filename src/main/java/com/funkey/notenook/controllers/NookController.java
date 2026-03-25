package com.funkey.notenook.controllers;

import com.funkey.notenook.dtos.NookRequest;
import com.funkey.notenook.dtos.NookResponse;
import com.funkey.notenook.services.NookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/api/nook")
public class NookController {

    @Autowired
    private NookService nookService;

    @PostMapping
    public ResponseEntity<NookResponse> createNook(@RequestBody NookRequest request){
        NookResponse response = nookService.createNook(request);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteNook(@PathVariable UUID id){
        nookService.deleteNook(id);
        return ResponseEntity.noContent().build();
    }


}

