DROP TABLE IF EXISTS person;

CREATE TABLE person (
  id INT AUTO_INCREMENT  PRIMARY KEY,
  first_name VARCHAR(250) NOT NULL,
  last_name VARCHAR(250) NOT NULL,
  age INT
);

INSERT INTO person (first_name, last_name, age) VALUES
  ('Aliko', 'Dangote', 23),
  ('Bill', 'Gates', 35),
  ('Folrunsho', 'Alakija', 46);
