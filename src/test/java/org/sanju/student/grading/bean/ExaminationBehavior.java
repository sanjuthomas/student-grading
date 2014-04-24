package org.sanju.student.grading.bean;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.sanju.student.grading.bean.Examination;
import org.sanju.student.grading.enums.CourseWorkType;

/**
 * This test shall test all behaviors in Examination class.
 * 
 * @author thosan
 *
 */
public class ExaminationBehavior {
	
	private Examination examination;
	
	@Before
	public void setUp(){
		examination = new Examination();
	}
	
	@Test
	public void shouldCheckNotNullCourseWorkType(){
		assertNotNull(examination);
	}
	
	@Test
	public void shouldCheckForCourseWorkTypeInExamination(){
		assertEquals(CourseWorkType.EXAMINATION, examination.getCourseWorkType());
	}

}
