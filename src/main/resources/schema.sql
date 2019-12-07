DROP TABLE IF EXISTS team;

CREATE TABLE team (
  id INT AUTO_INCREMENT  PRIMARY KEY,
  name VARCHAR(250) NOT NULL
);



DROP TABLE IF EXISTS hero;

CREATE TABLE hero (
  id INT AUTO_INCREMENT  PRIMARY KEY,
  full_name VARCHAR(250) NOT NULL,
  team_id INT
);



DROP TABLE IF EXISTS user;

CREATE TABLE user (
  id INT PRIMARY KEY,
  hero_id INT NOT NULL,
  username VARCHAR(250) NOT NULL,
  password VARCHAR(250) NOT NULL,
  email VARCHAR(250),
  renewAt DATE
);



DROP TABLE IF EXISTS mission;

CREATE TABLE mission (
  id INT AUTO_INCREMENT PRIMARY KEY,
  name VARCHAR(250) NOT NULL,
  created DATE
);



DROP TABLE IF EXISTS hero_mission;

CREATE TABLE hero_mission (
  hero_id INT,
  mission_id INT
);