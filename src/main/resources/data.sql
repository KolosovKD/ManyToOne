DROP TABLE IF EXISTS lifeboard CASCADE;
DROP TABLE IF EXISTS ship CASCADE;

CREATE TABLE ship (
    name VARCHAR(150) PRIMARY KEY,
    type VARCHAR(250) NOT NULL
);

CREATE TABLE lifeboard (
    ship_id VARCHAR(150) NOT NULL,
    number INT NOT NULL,
    capacity INT NOT NULL,
    FOREIGN KEY(ship_id) REFERENCES ship(name),
    PRIMARY KEY(ship_id, number)
);