package com.ecollect.app.dao;

import com.ecollect.app.module.CollectionSite;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository("postgres")
public class CollectionSiteDataAccessService implements CollectionSiteDao{

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public CollectionSiteDataAccessService(JdbcTemplate jdbcTemplate){
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public int insertCollectionSite(UUID id, CollectionSite collectionSite) {

        final String sql = "INSERT INTO collection_site (id, name, email, latitude, longitude, city , province) VALUES (?, ?,?,?,?,?,?)";
        String name = collectionSite.getName();
        String email =  collectionSite.getEmail();
        double latitude = collectionSite.getLatitude();
        double longitude = collectionSite.getLongitude();
        String city = collectionSite.getCity();
        String province =  collectionSite.getProvince();

        jdbcTemplate.update(sql, new Object[]{id,name,email,latitude,longitude,city,province});
        return 1;
    }

    @Override
    public List<CollectionSite> selectAllCollectionSites() {
        final String sql = "SELECT id, name, email, latitude, longitude, city, province FROM collection_site";
        List<CollectionSite> collectionSites = jdbcTemplate.query(sql, (resultSet, i)->{
            UUID id = UUID.fromString(resultSet.getString("id"));
            String name = resultSet.getString("name");
            String email = resultSet.getString("email");
            double latitude = resultSet.getFloat("latitude");
            double longitude = resultSet.getFloat("longitude");
            String city = resultSet.getString("city");
            String province = resultSet.getString("province");

            return new CollectionSite(
                    id,
                    name,
                    email,
                    latitude,
                    longitude,
                    city,
                    province);
        });
        return collectionSites;
    }

    @Override
    public Optional<CollectionSite> selectCollectionSiteById(UUID id) {

        final String sql = "SELECT id, name, email, latitude, longitude, city, province FROM collection_site WHERE id = ?";
        CollectionSite collectionSite = jdbcTemplate.queryForObject(sql,new Object[]{id},(resultSet, i)->{
            UUID uuid = UUID.fromString(resultSet.getString("id"));
            String name = resultSet.getString("name");
            String email = resultSet.getString("email");
            double latitude = resultSet.getFloat("latitude");
            double longitude = resultSet.getFloat("longitude");
            String city = resultSet.getString("city");
            String province = resultSet.getString("province");

            return new CollectionSite(
                    uuid,
                    name,
                    email,
                    latitude,
                    longitude,
                    city,
                    province);
        });
        return Optional.ofNullable(collectionSite);
    }

    @Override
    public int deleteCollectionSiteById(UUID id) {
        Optional<CollectionSite> collectionSiteMaybe = selectCollectionSiteById(id);
        if(collectionSiteMaybe.isEmpty()){
            return 0;
        }
        final String sql = "DELETE FROM collection_site WHERE id = ?";

        jdbcTemplate.update(sql, new Object[]{id});
        return 1;
    }

    @Override
    public int updateCollectionSiteById(UUID id, CollectionSite collectionSite) {
        Optional<CollectionSite> collectionSiteMaybe = selectCollectionSiteById(id);

        if(collectionSiteMaybe.isEmpty()){
            return 0;
        }

        final String sql = "UPDATE collection_site SET name=?, email=?, latitude=?, longitude=?, city=?, province=? WHERE id = ?";

        UUID uuid = collectionSite.getId();
        String name = collectionSite.getName();
        String email =  collectionSite.getEmail();
        double latitude = collectionSite.getLatitude();
        double longitude = collectionSite.getLongitude();
        String city = collectionSite.getCity();
        String province =  collectionSite.getProvince();

        jdbcTemplate.update(sql, new Object[]{name,email,latitude,longitude,city,province, uuid});

        return 1;
    }
}
