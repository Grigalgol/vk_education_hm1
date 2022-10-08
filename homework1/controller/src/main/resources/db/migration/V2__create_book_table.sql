CREATE TABLE "book"
(
    id SERIAL PRIMARY KEY NOT NULL,
    title TEXT NULL,
    author_id INTEGER REFERENCES author (id) NOT NULL,
    count_pages INTEGER NULL,
    genre TEXT NULL,
    age INTEGER NULL
);