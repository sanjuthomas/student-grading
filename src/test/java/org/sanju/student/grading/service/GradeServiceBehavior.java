package org.sanju.student.grading.service;

import static org.junit.Assert.assertEquals;

import java.text.DecimalFormat;

import org.junit.Before;
import org.junit.Test;
import org.sanju.student.grading.bean.Assignment;
import org.sanju.student.grading.bean.CourseWork;
import org.sanju.student.grading.bean.Examination;
import org.sanju.student.grading.bean.Score;
import org.sanju.student.grading.bean.Student;
import org.sanju.student.grading.bean.Teacher;
import org.sanju.student.grading.bean.Weightage;
import org.sanju.student.grading.bean.WeightageConfiguration;
import org.sanju.student.grading.enums.CourseWorkType;
import org.sanju.student.grading.service.GradeSerive;

/**
 * This class shall test all behavior of GradeService.
 * 
 * @author thosan
 *
 */
public class GradeServiceBehavior {
	
	private static final DecimalFormat decimalFormat = new DecimalFormat("#.##");

	private GradeSerive gradeService;
	private Student student;
	private WeightageConfiguration weightageConfiguration;
	private Teacher teacher;
	private Weightage assignmentWeightage;
	private Weightage examinationWeightage;
	private Weightage extraCreditWeightage;
	
	
	@Before
	public void setUp(){
		gradeService = new GradeSerive();
		student = new Student();
		student.setId(101);
		teacher = new Teacher();
		teacher.setId(1);
		extraCreditWeightage = new Weightage(CourseWorkType.EXTRA_CREDIT_ASSIGNMENT);
		extraCreditWeightage.setPercentage(2.0);
		assignmentWeightage = new Weightage(CourseWorkType.ASSIGNMENT);
		assignmentWeightage.setPercentage(10.1);
		examinationWeightage = new Weightage(CourseWorkType.EXAMINATION);
		examinationWeightage.setPercentage(89.9);
		weightageConfiguration = new WeightageConfiguration(teacher);
		weightageConfiguration.addWeightage(assignmentWeightage);
		weightageConfiguration.addWeightage(examinationWeightage);
		weightageConfiguration.addWeightage(extraCreditWeightage);
	}
	
	@Test
	public void shouldGradeStudent(){
		
		final CourseWork assignmentOne = getAssignment(85.0, false);
		student.addCourseWork(assignmentOne);
		gradeService.grade(student, weightageConfiguration);
		assertEquals(new Double(85.0), student.getGrade().getPercentage());
		
		final CourseWork assignmentTwo = getAssignment(88.0, false);
		student.addCourseWork(assignmentTwo);
		gradeService.grade(student, weightageConfiguration);
		assertEquals(new Double(86.5), student.getGrade().getPercentage());
		
		final CourseWork assignmentExtraCredit = getAssignment(90.0, true);
		student.addCourseWork(assignmentExtraCredit);
		gradeService.grade(student, weightageConfiguration);
		assertEquals(new Double(88.5), student.getGrade().getPercentage());
		
		final CourseWork assignmentThree = getAssignment(92.0, false);
		student.addCourseWork(assignmentThree);
		gradeService.grade(student, weightageConfiguration);
		assertEquals("90.33", decimalFormat.format(student.getGrade().getPercentage()));
		
		final CourseWork examination = getExmination(91.00);
		student.addCourseWork(examination);
		gradeService.grade(student, weightageConfiguration);
		assertEquals("90.93", decimalFormat.format(student.getGrade().getPercentage()));
	}
	
	@Test
	public void shouldGradeStudentWitExamination(){
		final CourseWork examination = getExmination(91.00);
		student.addCourseWork(examination);
		gradeService.grade(student, weightageConfiguration);
		assertEquals("91", decimalFormat.format(student.getGrade().getPercentage()));
	}
	
	@Test
	public void shouldGradeStudentWitExaminations(){
		final CourseWork examination = getExmination(91.00);
		student.addCourseWork(examination);
		gradeService.grade(student, weightageConfiguration);
		assertEquals("91", decimalFormat.format(student.getGrade().getPercentage()));
		
		final CourseWork examinationOne = getExmination(100.00);
		student.addCourseWork(examinationOne);
		gradeService.grade(student, weightageConfiguration);
		assertEquals("95.5", decimalFormat.format(student.getGrade().getPercentage()));
	}
	
	@Test
	public void shouldGradeStudentWithAssignment(){
		final CourseWork assignmentOne = getAssignment(85.0, false);
		student.addCourseWork(assignmentOne);
		gradeService.grade(student, weightageConfiguration);
		assertEquals(new Double(85.0), student.getGrade().getPercentage());
	}
	
	@Test
	public void shouldGradeStudentWithAssignments(){
		final CourseWork assignmentOne = getAssignment(85.0, false);
		student.addCourseWork(assignmentOne);
		gradeService.grade(student, weightageConfiguration);
		assertEquals(new Double(85.0), student.getGrade().getPercentage());
		
		final CourseWork assignmentTwo = getAssignment(88.0, false);
		student.addCourseWork(assignmentTwo);
		gradeService.grade(student, weightageConfiguration);
		assertEquals(new Double(86.5), student.getGrade().getPercentage());
	}
	
	@Test
	public void shouldGradeStudentWithAssignmentsAndExtraCredit(){
		final CourseWork assignmentOne = getAssignment(85.0, false);
		student.addCourseWork(assignmentOne);
		gradeService.grade(student, weightageConfiguration);
		assertEquals(new Double(85.0), student.getGrade().getPercentage());
		
		final CourseWork assignmentTwo = getAssignment(88.0, false);
		student.addCourseWork(assignmentTwo);
		gradeService.grade(student, weightageConfiguration);
		assertEquals(new Double(86.5), student.getGrade().getPercentage());
		
		final CourseWork assignmentExtraCredit = getAssignment(90.0, true);
		student.addCourseWork(assignmentExtraCredit);
		gradeService.grade(student, weightageConfiguration);
		assertEquals(new Double(88.5), student.getGrade().getPercentage());
	}
	
	@Test
	public void shouldNotExceedHundredPercentage(){
		final CourseWork assignmentOne = getAssignment(99.0, false);
		student.addCourseWork(assignmentOne);
		gradeService.grade(student, weightageConfiguration);
		assertEquals(new Double(99.0), student.getGrade().getPercentage());
		
		final CourseWork assignmentExtraCredit = getAssignment(90.0, true);
		student.addCourseWork(assignmentExtraCredit);
		gradeService.grade(student, weightageConfiguration);
		assertEquals(new Double(100), student.getGrade().getPercentage());
	}
	
	/**
	 * 
	 * 85, 88, extra credit, 92, 
	 * 
	 * @param courseWorkType
	 * @return
	 */
	private CourseWork getAssignment(final Double percentage, Boolean isExtraCredit){
		
		final CourseWork courseWork = new Assignment(isExtraCredit);
		courseWork.setId(10001);
		final Score score = new Score();
		score.setPercentage(percentage);
		courseWork.setScore(score);
		return courseWork;
	}
	
	/**
	 * exam 91
	 * 
	 * @param percentage
	 * @return
	 */
	private CourseWork getExmination(final Double percentage){
		
		final CourseWork courseWork = new Examination();
		courseWork.setId(1001);
		final Score score = new Score();
		score.setPercentage(percentage);
		courseWork.setScore(score);
		return courseWork;
	}
	
}
