package org.sanju.student.grading.bean;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;
import org.sanju.student.grading.bean.Teacher;
import org.sanju.student.grading.bean.Weightage;
import org.sanju.student.grading.bean.WeightageConfiguration;
import org.sanju.student.grading.enums.CourseWorkType;

/**
 * This test class shall test all the behavior of WeightageConfiguration
 * 
 * @author thosan
 *
 */
public class WeightageConfigurationBehavior {
	
	private WeightageConfiguration weightageConfiguration;
	private Weightage examinationWeightage;
	private Weightage assignmentWeightage;
	private Teacher teacher;
	
	@Before
	public void setUp(){
		teacher = new Teacher();
		teacher.setId(1);
		weightageConfiguration = new WeightageConfiguration(teacher);
		examinationWeightage = new Weightage(CourseWorkType.EXAMINATION);
		examinationWeightage.setPercentage(90.0);
		assignmentWeightage = new Weightage(CourseWorkType.ASSIGNMENT);
		assignmentWeightage.setPercentage(10.0);
	}
	
	public void shouldInitWeightageConfigurationProperly(){
		assertEquals(teacher, weightageConfiguration.getTeacher());
	}
	
	@Test
	public void shouldAddExaminationWeightage(){
		weightageConfiguration.addWeightage(examinationWeightage);
		assertEquals(CourseWorkType.EXAMINATION, weightageConfiguration.getWeightageByType(CourseWorkType.EXAMINATION).getCourseWorkType());
		assertEquals(new Double(90.0), weightageConfiguration.getWeightageByType(CourseWorkType.EXAMINATION).getPercentage());
	}
	
	@Test
	public void shouldAddAssignmentWeightage(){
		weightageConfiguration.addWeightage(assignmentWeightage);
		assertEquals(CourseWorkType.ASSIGNMENT, weightageConfiguration.getWeightageByType(CourseWorkType.ASSIGNMENT).getCourseWorkType());
		assertEquals(new Double(10.0), weightageConfiguration.getWeightageByType(CourseWorkType.ASSIGNMENT).getPercentage());
	}
}
