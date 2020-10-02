
CREATE TABLE item(
id UUID NOT NULL PRIMARY KEY,
name VARCHAR(100) NOT NULL,
image VARCHAR(200) NOT NULL
);

CREATE TABLE IF NOT EXISTS collection_site(
    id UUID NOT NULL PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    email VARCHAR(100) NOT NULL,
    latitude DECIMAL(20) NOT NULL,
    longitude DECIMAL(20) NOT NULL,
    city VARCHAR(100) NOT NULL,
    province VARCHAR(2) NOT NULL,
    items int[] default '{}'

);

CREATE TABLE IF NOT EXISTS sites_items(
collection_site_id UUID,
FOREIGN KEY(collection_site_id)
REFERENCES collection_site(id),

item_id UUID,
FOREIGN KEY(item_id)
REFERENCES item(id)
)

