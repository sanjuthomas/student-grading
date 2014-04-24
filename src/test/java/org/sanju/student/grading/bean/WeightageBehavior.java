package org.sanju.student.grading.bean;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.sanju.student.grading.bean.Weightage;
import org.sanju.student.grading.enums.CourseWorkType;

/**
 * This test class shall test all behaviors for Weightage
 * 
 * @author thosan
 *
 */
public class WeightageBehavior {
	
	private Weightage examinationWeightage;
	
	private Weightage assignmentWeightage;
	
	@Before
	public void setUp(){
		examinationWeightage = new Weightage(CourseWorkType.EXAMINATION);
		assignmentWeightage= new Weightage(CourseWorkType.ASSIGNMENT);
	}

	@Test
	public void shouldInitExaminationWeightage(){
		assertEquals(CourseWorkType.EXAMINATION, examinationWeightage.getCourseWorkType());
	}
	
	@Test
	public void shouldInitAssignmentWeightage(){
		assertEquals(CourseWorkType.ASSIGNMENT, assignmentWeightage.getCourseWorkType());
	}
	
	@Test
	public void shouldSetPercentage(){
		assignmentWeightage.setPercentage(10.1);
		assertEquals(new Double(10.1), assignmentWeightage.getPercentage());
	}
}
