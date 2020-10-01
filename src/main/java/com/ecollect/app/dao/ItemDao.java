package com.ecollect.app.dao;

import com.ecollect.app.module.Item;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface ItemDao {
    int insertItem(UUID id, Item item);

    default int insertItem(Item item){
        UUID id = UUID.randomUUID();
        return insertItem(id, item);
    }

    List<Item> selectAllItems();
    Optional<Item> selectItemById(UUID id);
    int deleteItemById(UUID id);
    int updateItemById(UUID id, Item item);
}
