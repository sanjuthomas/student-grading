package org.sanju.student.grading.bean;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;
import org.sanju.student.grading.bean.Assignment;
import org.sanju.student.grading.bean.CourseWork;
import org.sanju.student.grading.bean.Examination;
import org.sanju.student.grading.bean.Grade;
import org.sanju.student.grading.bean.Student;
import org.sanju.student.grading.bean.Teacher;
import org.sanju.student.grading.enums.CourseWorkType;

/**
 * Test class to test Student behaviors.
 * 
 * @author Kalai
 *
 */
public class StudentBehavior {
	
	private Student student;
	private Teacher teacher;
	private Grade grade;
	private CourseWork examination;
	private CourseWork assignment;
	
	@Before
	public void setUp(){
		student = new Student();
		teacher = new Teacher();
		grade = new Grade();
		grade.setPercentage(99.1);
		examination = new Examination();
		examination.setId(100001);
		assignment = new Assignment(false);
		assignment.setId(100003);
	}
	
	@Test
	public void shouldSetTheStudentId(){
		student.setId(100);
		assertNotNull(student.getId());
	}
	
	@Test
	public void shouldSetTeacher(){
		student.setTeacher(teacher);
		assertEquals(teacher, student.getTeacher());
	}
	
	@Test
	public void shouldSetGrade(){
		student.setGrade(grade);
		assertEquals(grade, student.getGrade());
	}
	
	@Test
	public void shouldAddExamination(){
		student.addCourseWork(examination);
		assertTrue(student.getCourseWorkByType(CourseWorkType.EXAMINATION).contains(examination));
	}
	
	@Test
	public void shouldAddAssignment(){
		student.addCourseWork(assignment);
		assertTrue(student.getCourseWorkByType(CourseWorkType.ASSIGNMENT).contains(assignment));
	}
}
