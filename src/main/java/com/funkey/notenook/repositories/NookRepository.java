package com.funkey.notenook.repositories;
import com.funkey.notenook.models.Nook;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface NookRepository extends JpaRepository<Nook, UUID> {
}
