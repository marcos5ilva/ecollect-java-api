package com.ecollect.app.service;

import com.ecollect.app.dao.CollectionSiteDao;
import com.ecollect.app.module.CollectionSite;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class CollectionSiteService {
    private final CollectionSiteDao collectionSiteDao;

    @Autowired
    public CollectionSiteService(@Qualifier("postgres") CollectionSiteDao collectionSiteDao){
        this.collectionSiteDao = collectionSiteDao;
    }

    public int addCollectionSite(CollectionSite collectionSite) {
        return collectionSiteDao.insertCollectionSite(collectionSite);
    }

    public List<CollectionSite> getAllCollectionSites(){
        return collectionSiteDao.selectAllCollectionSites();
    }

    public Optional<CollectionSite> getCollectionSiteById(UUID id){
        return collectionSiteDao.selectCollectionSiteById(id);
    }

    public int deleteCollectionSite(UUID id){
        return collectionSiteDao.deleteCollectionSiteById(id);
    }

    public int updateCollectionSite(UUID id, CollectionSite collectionSite){
        return collectionSiteDao.updateCollectionSiteById(id, collectionSite);
    }
}
