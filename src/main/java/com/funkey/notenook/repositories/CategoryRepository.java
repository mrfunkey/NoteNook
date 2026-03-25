package com.funkey.notenook.repositories;

import com.funkey.notenook.models.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {
}
