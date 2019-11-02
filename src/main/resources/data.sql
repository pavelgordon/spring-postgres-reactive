DROP TABLE IF EXISTS users;

CREATE TABLE users
(
    id         INTEGER PRIMARY KEY,
    first_name text NOT NULL,
    last_name  text NOT NULL,
    role       text
);

INSERT INTO users VALUES (1, 'Pavel', 'Gordon', 'dev');
INSERT INTO users VALUES (2, 'Ilya', 'Lyamkin', 'dev');