DROP TABLE IF EXISTS person;

CREATE TABLE person (
  id INT AUTO_INCREMENT  PRIMARY KEY,
  first_name VARCHAR(250) NOT NULL,
  last_name VARCHAR(250) NOT NULL,
  age INT NOT NULL
);

INSERT INTO person (first_name, last_name, age) VALUES
    ('April', 'Maillet', 43),
    ('Ping', 'Tilton', 25),
    ('Fritz', 'Strandberg', 66),
    ('Loreen', 'Yerger', 37),
    ('Remedios', 'Ellenburg', 17),
    ('Bart', 'Houde', 38),
    ('Herbert', 'Wilber', 61),
    ('Cheryle', 'Crose', 43),
    ('Tad', 'Rouleau', 32),
    ('Skye', 'Cronin', 14);