package com.ecollect.app.dao;

import com.ecollect.app.module.Item;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository("postgres")
public class ItemDataAccessService implements ItemDao{

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public  ItemDataAccessService(JdbcTemplate jdbcTemplate){
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public int insertItem(UUID id, Item item) {
        final String sql = "INSERT INTO item (id, name, image) VALUES (?, ?, ?)";

        String name = item.getName();
        String image = item.getImage();

        jdbcTemplate.update(sql, new Object[]{id, name, image});
        return 0;
    }

    @Override
    public List<Item> selectAllItems() {
        return null;
    }

    @Override
    public Optional<Item> selectItemById(UUID id) {
        return Optional.empty();
    }

    @Override
    public int deleteItemById(UUID id) {
        return 0;
    }

    @Override
    public int updateItemById(UUID id, Item item) {
        return 0;
    }
}
