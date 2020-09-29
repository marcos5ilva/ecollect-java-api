package com.ecollect.app.api;

import com.ecollect.app.module.CollectionSite;
import com.ecollect.app.service.CollectionSiteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RequestMapping("api/v1/collection-site")
@RestController
public class CollectionSiteController {
    private final CollectionSiteService collectionSiteService;

    @Autowired
    CollectionSiteController(CollectionSiteService collectionSiteService){
        this.collectionSiteService = collectionSiteService;
    }

    @PostMapping
    public void addPerson(@RequestBody CollectionSite collectionSite){
        collectionSiteService.addCollectionSite(collectionSite);
    }

    @GetMapping
    public List<CollectionSite> getAllCollectionSites(){
        return collectionSiteService.getAllCollectionSites();
    }

    @GetMapping(path="/{id}")
    public CollectionSite getCollectionSiteById(@PathVariable("id") UUID id){
        return collectionSiteService.getCollectionSiteById(id)
                .orElse(null);
    }

    @DeleteMapping(path="/{id}")
    public void deleteCollectionSiteById(@PathVariable("id") UUID id){
        collectionSiteService.deleteCollectionSite(id);
    }

    @PutMapping(path="/{id}")
    public void updateCollectionSiteById(@PathVariable("id") UUID id,
                                         @RequestBody CollectionSite collectionSite){
        collectionSiteService.updateCollectionSite(id, collectionSite);
    }

}
