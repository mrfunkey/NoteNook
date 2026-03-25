package com.funkey.notenook.dtos;

import com.funkey.notenook.models.Nook;

public record CategoryResponse(Long id, Nook nook, String name) {
}
