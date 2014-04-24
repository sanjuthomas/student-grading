package org.sanju.student.grading.bean;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;
import org.sanju.student.grading.bean.Assignment;
import org.sanju.student.grading.enums.CourseWorkType;

/**
 * Test class to test Assignment behaviors.
 * 
 * @author Kalai
 *
 */
public class AssignmentBehavior {
	
	private Assignment assignment;
	
	private Assignment extraCreditAssignment;
	
	@Before
	public void setUp(){
		assignment = new Assignment(false);
		extraCreditAssignment = new Assignment(true);
	}
	
	@Test
	public void shouldCheckForNotNullCourseWorkType(){
		assertNotNull(assignment.getCourseWorkType());
	}
	
	@Test
	public void shouldCheckCourseWorkTypeInAssignment(){
		assertFalse(assignment.isExtraCredit());
	}
	
	@Test
	public void shoudlCheckForExtraCredit(){
		assertTrue(extraCreditAssignment.isExtraCredit());
		assertEquals(CourseWorkType.EXTRA_CREDIT_ASSIGNMENT, extraCreditAssignment.getCourseWorkType());
	}
	
	@Test
	public void shoudSetId(){
		assignment.setId(122);
		assertEquals(122, assignment.getId().intValue());
	}
	
	

}
