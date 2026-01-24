/* DATABASE CREATION */
CREATE DATABASE CUK_University;
USE CUK_University;

/* TABLE CREATION */
CREATE TABLE students (
    student_id INT PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    course VARCHAR(50),
    balance DECIMAL(10, 2)
);

/* INSERTING DATA */
INSERT INTO students (student_id, name, course, balance) 
VALUES (202401, 'Alice Maina', 'Software Engineering', 50000.00);

/* SELECTING DATA (To view the entry) */
SELECT * FROM students;

/* UPDATING DATA (Changing Alice's balance) */
UPDATE students 
SET balance = 25000.00 
WHERE student_id = 202401;

/* DELETING DATA (Removing the record) */
DELETE FROM students 
WHERE student_id = 202401;

/* FINAL VERIFICATION */
SELECT * FROM students;
