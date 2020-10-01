CREATE TABLE collection_site(
    id UUID NOT NULL PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    email VARCHAR(100) NOT NULL,
    latitude NUMERIC(20) NOT NULL,
    longitude NUMERIC(20) NOT NULL,
    city VARCHAR(100) NOT NULL,
    province VARCHAR(2) NOT NULL

)