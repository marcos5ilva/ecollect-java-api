package com.ecollect.app.dao;

import com.ecollect.app.module.CollectionSite;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface CollectionSiteDao {
    int insertCollectionSite(UUID id, CollectionSite collectionSite);

    default int insertCollectionSite(CollectionSite collectionSite)
    {
        UUID id = UUID.randomUUID();
        return insertCollectionSite(id, collectionSite);
    }
    List<CollectionSite> selectAllCollectionSites();
    Optional<CollectionSite> selectCollectionSiteById(UUID id);
    int deleteCollectionSiteById(UUID id);
    int updateCollectionSiteById(UUID id, CollectionSite collectionSite);
}
