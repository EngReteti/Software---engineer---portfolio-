/* DATABASE CREATION
 Create the main container */
CREATE DATABASE CUK_SchoolSystem;
USE CUK_SchoolSystem;

/* 2. TABLE CREATION (Schema) 
 Table 1: Students */
CREATE TABLE students (
    student_id INT PRIMARY KEY,
    name VARCHAR(50) NOT NULL,
    email VARCHAR(50)
);

/* Table 2: Units (Courses) */
CREATE TABLE units (
    unit_code VARCHAR(10) PRIMARY KEY,
    unit_name VARCHAR(100) NOT NULL
);

/* Table 3: Grades (The bridge table) */
CREATE TABLE grades (
    grade_id INT AUTO_INCREMENT PRIMARY KEY,
    student_id INT,
    unit_code VARCHAR(10),
    score INT,
    FOREIGN KEY (student_id) REFERENCES students(student_id),
    FOREIGN KEY (unit_code) REFERENCES units(unit_code)
);

/* DATA INSERT (Insertion)
 Adding Students */
INSERT INTO students VALUES (101, 'Alice Maina', 'alice@cuk.ac.ke');
INSERT INTO students VALUES (102, 'John Doe', 'john@cuk.ac.ke');

/* Adding Units */
INSERT INTO units VALUES ('SIT101', 'Database Systems');
INSERT INTO units VALUES ('SIT102', 'Software Engineering');

/* Assigning Grades */
INSERT INTO grades (student_id, unit_code, score) VALUES (101, 'SIT101', 85);
INSERT INTO grades (student_id, unit_code, score) VALUES (101, 'SIT102', 78);
INSERT INTO grades (student_id, unit_code, score) VALUES (102, 'SIT101', 92);

/* JOIN QUERY (The Result) 
 This merges all three tables into a readable report card */
SELECT 
    s.name AS "Student Name", 
    u.unit_name AS "Unit Name", 
    g.score AS "Marks"
FROM grades g
JOIN students s ON g.student_id = s.student_id
JOIN units u ON g.unit_code = u.unit_code
ORDER BY s.name ASC;
