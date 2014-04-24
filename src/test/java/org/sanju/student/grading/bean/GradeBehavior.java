package org.sanju.student.grading.bean;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.sanju.student.grading.bean.Grade;

/**
 * Test class to test all behavior in Grade
 * 
 * @author Kalai
 *
 */
public class GradeBehavior {
	
	private Grade grade;
	
	@Before
	public void setUp(){
		grade = new Grade();
	}
	
	@Test
	public void shouldSetPercentage(){
		assertEquals(new Double(0), grade.getPercentage());
		grade.setPercentage(90.2);
		assertEquals(new Double(90.2), grade.getPercentage());
	}

}
