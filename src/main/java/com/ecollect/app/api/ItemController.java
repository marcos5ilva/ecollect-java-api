package com.ecollect.app.api;

import com.ecollect.app.module.Item;
import com.ecollect.app.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RequestMapping("api/v1/item")
@RestController
public class ItemController {
    private final ItemService itemService;

    @Autowired
    public ItemController(ItemService itemService){
        this.itemService = itemService;
    }

    @PostMapping
    public void addItem(@RequestBody Item item){
        itemService.addItem(item);
    }

    @GetMapping
    public List<Item> getAllItems(){return itemService.getAllItems();}

    @GetMapping(path="/{id}")
    public Item getItemById(@PathVariable("id") UUID id){
        return itemService.getItemById(id)
                .orElse(null);
    }

    @DeleteMapping(path="/{id}")
    public void deleteItemById(@PathVariable("id") UUID id){
        itemService.deleteItemById(id);
    }

    @PutMapping(path="/{id}")
    public void updateItemById(@PathVariable("id") UUID id,
            @RequestBody Item item){
            itemService.updateItemById(id, item);
        }



}
