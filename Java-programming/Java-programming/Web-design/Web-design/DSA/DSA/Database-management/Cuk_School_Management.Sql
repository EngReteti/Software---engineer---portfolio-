/* DATABASE CREATION */
CREATE DATABASE CUK_SchoolSystem;
USE CUK_SchoolSystem;

/* CREATE TABLES (Relational Structure) 
  Table for Student details */
CREATE TABLE students (
    student_id INT PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    email VARCHAR(100) UNIQUE
);

 /* Table for Units/Courses offered at CUK */
CREATE TABLE units (
    unit_code VARCHAR(10) PRIMARY KEY,
    unit_name VARCHAR(100) NOT NULL
);

 /* Table for Grades (Links Students to Units) */
CREATE TABLE grades (
    grade_id INT AUTO_INCREMENT PRIMARY KEY,
    student_id INT,
    unit_code VARCHAR(10),
    score INT,
    FOREIGN KEY (student_id) REFERENCES students(student_id),
    FOREIGN KEY (unit_code) REFERENCES units(unit_code)
);

 /* INSERT SAMPLE DATA */
INSERT INTO students VALUES (202401, 'Alice Maina', 'alice@cuk.ac.ke');
INSERT INTO students VALUES (202402, 'Bob Otieno', 'bob@cuk.ac.ke');

INSERT INTO units VALUES ('SIT101', 'Database Systems');
INSERT INTO units VALUES ('SIT102', 'Java Programming');

 /* Recording Alice's grade for Databases */
INSERT INTO grades (student_id, unit_code, score) VALUES (202401, 'SIT101', 85);

/* SELECT (The Power of Joins).
 This pulls data from all 3 tables into one clean report! */
SELECT s.name, u.unit_name, g.score 
FROM grades g
JOIN students s ON g.student_id = s.student_id
JOIN units u ON g.unit_code = u.unit_code;

  /* UPDATE & DELETE */
UPDATE grades SET score = 90 WHERE student_id = 202401 AND unit_code = 'SIT101';
DELETE FROM students WHERE student_id = 202402;
