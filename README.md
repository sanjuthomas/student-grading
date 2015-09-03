
Author : Sanju Thomas
contact : sanju@sanju.org



Student Grading Kata
--------------------

Imagine that you are working on one of a number of small teams building an application for schools to help manage students’ grades,
administration of sick days and other information. Your team has been chosen to implement the small server-side piece that manages
tracking of students’ grades.
The application should allow for tracking scores of an unlimited number of assignments and exams. The application should allow each
teacher to have configurable percentages for both types. Grading is done on a weighted average as per the percentages entered by the
teacher. In addition to the normal scores, students are allowed to do optional assignments for extra credit. Extra credit works as
follows: when a student turns in an extra credit assignment, it adds a configurable number of percentage points to the student’s then
current weighted average grade for Assignments only, and this amount is carried forward cumulatively.
In our first release, we are only going to consider one endless grading period, so do not allow for multiple periods (such as quarters or
semesters) or calculations across multiple periods.
Here is the minimal test data that must be showed to work in your sample:
Tom Teacherman percentage allocations:
Assignments: 10.1%
Exams: 89.9%
Extra Credit Assignment: add 2% to current weight average grade
Sally Student’s grade score log:
1.Assignment #1: 85/100
2. Assignment #2: 88/100
3. Extra Credit Assignment completed
4. Assignment #3: 92/100
5. Exam #1: 91/100

To demonstrate exactly how the program should calculate the average weight grade along with the Extra Credit, here is Sally’s
cumulative grade after each entry in the grade book:
1.After Assignment #1 is logged in the system: 85%
2.After Assignment #2 is logged in the system: 86.5%
3.After Extra Credit Assignment is logged in the system: 88.5%
4.After Assignment #3 is logged in the system: 90.33%
5.After Exam #1 is logged in the system: 90.93%


You can see from this result that the system should always report the grade as a percentage, and should consider the fact that if no
Exams (in this case) have taken place, the allocations are ignored.
