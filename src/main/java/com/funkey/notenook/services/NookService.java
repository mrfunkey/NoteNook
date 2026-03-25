package com.funkey.notenook.services;

import com.funkey.notenook.dtos.NookRequest;
import com.funkey.notenook.dtos.NookResponse;
import com.funkey.notenook.models.Category;
import com.funkey.notenook.models.Item;
import com.funkey.notenook.models.Nook;
import com.funkey.notenook.repositories.CategoryRepository;
import com.funkey.notenook.repositories.ItemRepository;
import com.funkey.notenook.repositories.NookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.UUID;

@Service
public class NookService {

    private NookRepository nookRepository;
    private CategoryRepository categoryRepository;
    private ItemRepository itemRepository;

    @Autowired
    public NookService(NookRepository nookRepository){
        this.nookRepository = nookRepository;
    }

    public NookResponse createNook (NookRequest request){
        String name = request.name();
        String passkey = request.passkey();

        Nook nook = new Nook();
        nook.setName(name);
        nook.setPasskey(passkey);
        Nook savedNook = nookRepository.save(nook);

        return new NookResponse(savedNook.getId(), savedNook.getName(), savedNook.formattedDate());
    }

    public void deleteNook(@PathVariable UUID nookId){
        nookRepository.deleteById(nookId);
    }


}
