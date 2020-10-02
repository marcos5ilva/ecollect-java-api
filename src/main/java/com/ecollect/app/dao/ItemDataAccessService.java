package com.ecollect.app.dao;

import com.ecollect.app.module.Item;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository("item-postgres")
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
        return 1;
    }

    @Override
    public List<Item> selectAllItems() {
        final String sql = "SELECT id, name, image FROM item";
        List<Item> items = jdbcTemplate.query(sql, (resultSet,i) -> {
            UUID id = UUID.fromString(resultSet.getString("id"));
            String name = resultSet.getString("name");
            String image = resultSet.getString("image");

            return new Item(
                    id,
                    name,
                    image
            );
        });
        return items;
    }

    @Override
    public Optional<Item> selectItemById(UUID id) {

        final String sql = "SELECT id, name, image FROM item WHERE id =?";
        Item item = jdbcTemplate.queryForObject(sql, new Object[]{id}, (resultSet, i)->{
            UUID uuid = UUID.fromString(resultSet.getString("id"));
            String name = resultSet.getString("name");
            String image = resultSet.getString("image");

            return new Item(
                    uuid,
                    name,
                    image
            );
        });

        return Optional.ofNullable(item);
    }

    @Override
    public int deleteItemById(UUID id) {
        Optional<Item> itemMaybe = selectItemById(id);

        if(itemMaybe.isEmpty())
        {
            return 0;
        }
        final  String sql = "DELETE FROM item WHERE id = ?";
        jdbcTemplate.update(sql, new Object[]{id});

        return 1;
    }

    @Override
    public int updateItemById(UUID id, Item item) {
        Optional<Item> itemMaybe = selectItemById(id);
        if(itemMaybe.isEmpty())
        {
            return 0;
        }

        final String sql =  "UPDATE item SET name=?, image=? WHERE id=?";
        UUID uuid = item.getId();
        String name = item.getName();
        String image = item.getImage();

        jdbcTemplate.update(sql, new Object[]{name, image, id});
        return 1;
    }
}
