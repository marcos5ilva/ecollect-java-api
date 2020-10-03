package com.ecollect.app.module;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.sql.Array;
import java.util.UUID;

public class CollectionSite {
    private final UUID id;
    private final String name;
    private final String email;
    private final double latitude;
    private final double longitude;
    private final String city;
    private final String province;
    private final String[] items;

    public CollectionSite(@JsonProperty("id") UUID id,
                          @JsonProperty("name") String name,
                          @JsonProperty("email") String email,
                          @JsonProperty("latitude") double latitude,
                          @JsonProperty("longitude") double longitude,
                          @JsonProperty("city") String city,
                          @JsonProperty("province") String province,
                          @JsonProperty("items") String[] items)
    {
        this.id = id;
        this.name = name;
        this.email = email;
        this.latitude = latitude;
        this.longitude = longitude;
        this.city = city;
        this.province = province;
        this.items = items;
    }

    public UUID getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public double getLatitude() {
        return latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public String getCity() {
        return city;
    }

    public String getProvince() {
        return province;
    }

    public String[] getItems() {
        return items;
    }
}
