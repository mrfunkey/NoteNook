package com.funkey.notenook.dtos;

import com.funkey.notenook.models.Category;

public record ItemResponse(Long id, String name, String brand, String description,  String categoryName) {
}
