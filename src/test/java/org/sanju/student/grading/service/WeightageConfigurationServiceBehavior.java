package org.sanju.student.grading.service;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;
import org.sanju.student.grading.bean.Teacher;
import org.sanju.student.grading.bean.Weightage;
import org.sanju.student.grading.bean.WeightageConfiguration;
import org.sanju.student.grading.enums.CourseWorkType;
import org.sanju.student.grading.service.WeightageConfigurationService;

/**
 * This class shall test all the behavior in WeightageConfigurationService
 * 
 * @author thosan
 *
 */
public class WeightageConfigurationServiceBehavior {
	
	private WeightageConfigurationService weightageConfigurationService;
	private Teacher teacher;
	private Weightage examinationWeightage;
	private Weightage assignmentWeightage;
	private Weightage[] weightages = new Weightage[2];
	
	@Before
	public void setUp(){
		weightageConfigurationService = new WeightageConfigurationService();
		teacher = new Teacher();
		examinationWeightage = new Weightage(CourseWorkType.EXAMINATION);
		assignmentWeightage = new Weightage(CourseWorkType.ASSIGNMENT);
		weightages[0] = assignmentWeightage;
		weightages[1] = examinationWeightage;
	}
	
	@Test
	public void shouldConfigureWeightage(){
		final WeightageConfiguration weightageConfiguration =  weightageConfigurationService.configure(teacher, weightages);
		assertEquals(teacher, weightageConfiguration.getTeacher());
		assertEquals(examinationWeightage, weightageConfiguration.getWeightageByType(CourseWorkType.EXAMINATION));
		assertEquals(assignmentWeightage, weightageConfiguration.getWeightageByType(CourseWorkType.ASSIGNMENT));
	}
}
