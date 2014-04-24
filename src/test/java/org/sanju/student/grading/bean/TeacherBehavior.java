package org.sanju.student.grading.bean;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.sanju.student.grading.bean.Teacher;

/**
 * This test class shall test all behaviors of Teacher class.
 * 
 * @author thosan
 *
 */
public class TeacherBehavior {
	
	private Teacher teacher;
	
	@Before
	public void setUp(){
		teacher = new Teacher();
	}
	
	@Test
	public void shouldSetId(){
		teacher.setId(1);
		assertEquals(1, teacher.getId().intValue());
	}

}
