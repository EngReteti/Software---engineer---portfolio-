SELECT 
    students.name AS "Student", 
    units.unit_name AS "Course", 
    grades.score AS "Marks"
FROM grades
/* Join grades to students using the ID */
JOIN students ON grades.student_id = students.student_id
/* Join grades to units using the Unit Code */
JOIN units ON grades.unit_code = units.unit_code;
