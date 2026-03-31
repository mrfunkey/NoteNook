package com.funkey.notenook.models;


import jakarta.persistence.*;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Entity (name = "Category")
@Table (name = "Category")
@Data
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "nook_id")
    private Nook nook;

    private String name;

    @OneToMany(mappedBy = "category",  cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Item> items =  new ArrayList<>();
    
}
