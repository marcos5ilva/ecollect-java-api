package com.ecollect.app.module;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.UUID;

public class Item {
    private final UUID id;
    private final String name;
    private final String image;

    public Item(@JsonProperty("id") UUID id,
                @JsonProperty("name") String name,
                @JsonProperty("image") String image){
        this.id = id;
        this.name = name;
        this.image = image;
    }

    public UUID getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getImage() {
        return image;
    }
}
