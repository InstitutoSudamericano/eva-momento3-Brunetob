CREATE TABLE IF NOT EXISTS film(
    id SERIAL,
    title VARCHAR (100),
    director VARCHAR (100),
    duration INT,
    PRIMARY KEY (id)
);

-- Scene table
CREATE TABLE IF NOT EXISTS scene(
    id SERIAL PRIMARY KEY,
    description TEXT NOT NULL,
    budget DECIMAL(10, 2) NOT NULL,
    minutes INT NOT NULL,
    film_id INT REFERENCES Film(id)
);

-- Character table
CREATE TABLE IF NOT EXISTS character (
    id SERIAL PRIMARY KEY,
    description TEXT NOT NULL,
    cost DECIMAL(10, 2) NOT NULL,
    hability VARCHAR(20),
    scene_id INT REFERENCES scene(id)
);