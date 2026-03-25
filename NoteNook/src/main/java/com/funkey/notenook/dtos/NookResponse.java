package com.funkey.notenook.dtos;

import java.time.LocalDateTime;
import java.util.UUID;

public record NookResponse(UUID id, String name, String formattedDate) {
}
