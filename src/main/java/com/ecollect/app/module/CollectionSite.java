package com.ecollect.app.module;

import java.util.UUID;

public class CollectionSite {
    private final UUID id;
    private final String name;
    private final String email;
    private final double latitude;
    private final double longitude;
    private final String city;
    private final String province;

    public CollectionSite(UUID id,
                          String name,
                          String email,
                          double latitude,
                          double longitude,
                          String city,
                          String province)
    {
        this.id = id;
        this.name = name;
        this.email = email;
        this.latitude = latitude;
        this.longitude = longitude;
        this.city = city;
        this.province = province;
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
}
