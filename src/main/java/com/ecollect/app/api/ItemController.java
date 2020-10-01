package com.ecollect.app.api;

import com.ecollect.app.module.Item;
import com.ecollect.app.service.ItemService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("api/v1/item")
@RestController
public class ItemController {
    private final ItemService itemService;

    public ItemController(ItemService itemService){
        this.itemService = itemService;
    }

    @PostMapping
    public void addItem(@RequestBody Item item){
        itemService.addItem(item);
    }

    @GetMapping
    public List<Item> getAllItems(){return itemService.getAllItems();}
}
