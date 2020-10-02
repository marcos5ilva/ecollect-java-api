package com.ecollect.app.service;

import com.ecollect.app.dao.ItemDao;
import com.ecollect.app.module.Item;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class ItemService {
    private final ItemDao itemDao;

    public ItemService(@Qualifier("item-postgres") ItemDao itemDao){
        this.itemDao = itemDao;
    }

    public int addItem(Item item){
        return itemDao.insertItem( item);
    }

    public List<Item> getAllItems(){return itemDao.selectAllItems();}

    public Optional<Item> getItemById(UUID id){ return itemDao.selectItemById(id); }

    public int deleteItemById(UUID id){ return itemDao.deleteItemById(id);}

    public int updateItemById(UUID id, Item item){return itemDao.updateItemById(id, item);}
}
