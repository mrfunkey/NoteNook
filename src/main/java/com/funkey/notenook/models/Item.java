package com.funkey.notenook.models;

import jakarta.persistence.*;
import lombok.Data;

@Entity (name = "Item")
@Table(name = "Item")
@Data
public class Item {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;

    private String name;
    private String brand;
    private String description;
}
