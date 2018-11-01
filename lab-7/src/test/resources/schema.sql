--DROP TABLE countries IF EXISTS;

CREATE TABLE country (
  id         INTEGER PRIMARY KEY,
  name VARCHAR(30),
  code_name  VARCHAR(50)
);