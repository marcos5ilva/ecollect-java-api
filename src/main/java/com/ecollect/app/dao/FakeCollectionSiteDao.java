package com.ecollect.app.dao;

import com.ecollect.app.module.CollectionSite;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository("fakeDao")
public class FakeCollectionSiteDao implements CollectionSiteDao{

    private static List<CollectionSite> DB = new ArrayList<>();

    @Override
    public int insertCollectionSite(UUID id, CollectionSite collectionSite) {
        DB.add( new CollectionSite(id,
                collectionSite.getName(),
                collectionSite.getEmail(),
                collectionSite.getLatitude(),
                collectionSite.getLongitude(),
                collectionSite.getCity(),
                collectionSite.getProvince(),
                collectionSite.getItems()
                ));
        return 1;
    }

    @Override
    public List<CollectionSite> selectAllCollectionSites() {
        return DB;
    }

    @Override
    public Optional<CollectionSite> selectCollectionSiteById(UUID id) {
        return DB.stream()
                .filter(collectionSite->collectionSite.getId().equals(id))
                .findFirst();
    }

    @Override
    public int deleteCollectionSiteById(UUID id) {
        Optional<CollectionSite> collectionSiteMaybe = selectCollectionSiteById(id);
        if(collectionSiteMaybe.isEmpty()){
            return 0;
        }
        DB.remove(collectionSiteMaybe.get());
        return 1;
    }

    @Override
    public int updateCollectionSiteById(UUID id, CollectionSite collectionSite) {
        return selectCollectionSiteById(id)
                .map(c -> {
                    int indexOfSiteToUpdate = DB.indexOf(c);
                            if(indexOfSiteToUpdate>=0){
                                DB.set(indexOfSiteToUpdate, new CollectionSite(
                                        id,
                                        collectionSite.getName(),
                                        collectionSite.getEmail(),
                                        collectionSite.getLatitude(),
                                        collectionSite.getLongitude(),
                                        collectionSite.getCity(),
                                        collectionSite.getProvince(),
                                        collectionSite.getItems()));
                                return 1;
                            }
                            return 0;
                })
                .orElse(0);
    }
}
