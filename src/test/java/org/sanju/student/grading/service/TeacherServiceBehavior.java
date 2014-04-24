package org.sanju.student.grading.service;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;
import org.sanju.student.grading.bean.Teacher;
import org.sanju.student.grading.service.TeacherService;

/**
 * Test class to test TeacherService class.
 * 
 * @author thosan
 *
 */
public class TeacherServiceBehavior {
	
	private TeacherService teacherService;
	
	@Before
	public void setUp(){
		teacherService = new TeacherService();
	}
	
	@Test
	public void shouldAddATeacher(){
		final Teacher teacher = teacherService.addTeacher(1);
		assertEquals(1, teacher.getId().intValue());
	}
	
}
