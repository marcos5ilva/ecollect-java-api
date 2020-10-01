package com.ecollect.app.service;

import com.ecollect.app.dao.ItemDao;
import com.ecollect.app.module.Item;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class ItemService {
    private final ItemDao itemDao;

    public ItemService(@Qualifier("item-postgres") ItemDao itemDao){
        this.itemDao = itemDao;
    }

    public int addItem(Item item){
        return itemDao.insertItem( item);
    }
}
