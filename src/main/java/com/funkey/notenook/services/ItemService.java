package com.funkey.notenook.services;

import com.funkey.notenook.dtos.ItemRequest;
import com.funkey.notenook.dtos.ItemResponse;
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

@Service
public class ItemService {

    private final ItemRepository itemRepository;
    private CategoryRepository categoryRepository;

    @Autowired
    public ItemService(CategoryRepository categoryRepository, ItemRepository itemRepository) {
        this.categoryRepository = categoryRepository;
        this.itemRepository = itemRepository;
    }

    public ItemResponse createItem(@RequestBody ItemRequest request){
        Category category = categoryRepository.findById(request.categoryId())
                .orElseThrow(() -> new RuntimeException("Category not found"));

        String name = request.name();
        String brand = request.brand();
        String description = request.description();

        Item item = new Item();
        item.setCategory(category);
        item.setName(name);
        item.setBrand(brand);
        item.setDescription(description);

        Item savedItem = itemRepository.save(item);

        return new ItemResponse(savedItem.getId(), savedItem.getName(), savedItem.getBrand(), savedItem.getDescription(),  savedItem.getCategory().getName());
    }

    public void deleteItem(@PathVariable Long id){
        itemRepository.deleteById(id);
    }
}
