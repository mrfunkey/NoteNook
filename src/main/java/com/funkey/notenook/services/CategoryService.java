package com.funkey.notenook.services;

import com.funkey.notenook.dtos.CategoryRequest;
import com.funkey.notenook.dtos.CategoryResponse;
import com.funkey.notenook.models.Category;
import com.funkey.notenook.models.Item;
import com.funkey.notenook.repositories.CategoryRepository;
import com.funkey.notenook.repositories.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Service
public class CategoryService {

    private final CategoryRepository categoryRepository;

    @Autowired
    public CategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    public CategoryResponse createCategory(@RequestBody CategoryRequest request){
        String name = request.name();

        Category category = new Category();
        category.setName(name);
        Category savedCategory = categoryRepository.save(category);

        return new CategoryResponse(savedCategory.getId(), savedCategory.getNook(), savedCategory.getName());
    }

    public List<CategoryResponse> getAll(){
        return categoryRepository.findAll().stream()
                .map(category -> new CategoryResponse(category.getId(), category.getNook(), category.getName()))
                .toList();
    }

    public CategoryResponse getById(@PathVariable Long id){
        Category category = categoryRepository.findById(id).orElse(null);
        return new CategoryResponse(category.getId(), category.getNook(), category.getName());
    }

    public void deleteCategory(@PathVariable Long id){
        categoryRepository.deleteById(id);
    }




}
