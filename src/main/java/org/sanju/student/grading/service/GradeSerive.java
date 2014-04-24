package org.sanju.student.grading.service;

import java.math.BigDecimal;

import org.sanju.student.grading.bean.CourseWork;
import org.sanju.student.grading.bean.Grade;
import org.sanju.student.grading.bean.Student;
import org.sanju.student.grading.bean.Weightage;
import org.sanju.student.grading.bean.WeightageConfiguration;
import org.sanju.student.grading.enums.CourseWorkType;

/**
 * Service class for grading.
 * 
 * @author Kalai
 *
 */
public class GradeSerive {

	/**
	 * This method shall calculate the grade of the student.
	 * 
	 * @param student
	 * @param weightageConfiguration
	 */
	public void grade(final Student student, final WeightageConfiguration weightageConfiguration) {
		
		final Weightage assignmentWeightage = weightageConfiguration.getWeightageByType(CourseWorkType.ASSIGNMENT);
		final Weightage examinationWeightage = weightageConfiguration.getWeightageByType(CourseWorkType.EXAMINATION);
		
		calculateAssignmentAverage(student);
		addExtraCreditAssignmentToAverage(student, weightageConfiguration.getWeightageByType(CourseWorkType.EXTRA_CREDIT_ASSIGNMENT));
		calculateExaminationAverage(student);
		
		if(student.getGrade().getAssignmentAverage() > BigDecimal.ZERO.doubleValue() && 
				student.getGrade().getExaminationAverage() > BigDecimal.ZERO.doubleValue()){
			final Double assginmentGrade = ((student.getGrade().getAssignmentAverage() * assignmentWeightage.getPercentage()) / 100);
			final Double examinationGrade = ((student.getGrade().getExaminationAverage() * examinationWeightage.getPercentage()) / 100);
			student.getGrade().setPercentage(assginmentGrade + examinationGrade); 
		}
	}
	
	/**
	 * This method shall calculate the average of assignment.
	 * 
	 * @param student
	 * @param weightageConfiguration
	 * @return
	 */
	private void calculateAssignmentAverage(final Student student){
		
		Double assignmentPercentage = new Double(BigDecimal.ZERO.doubleValue());
		
		if(student.getCourseWorkByType(CourseWorkType.ASSIGNMENT).size() > BigDecimal.ZERO.intValue()){
			for(final CourseWork assignment : student.getCourseWorkByType(CourseWorkType.ASSIGNMENT)){
					assignmentPercentage += assignment.getScore().getPercentage();
			}
			assignmentPercentage = (assignmentPercentage / student.getCourseWorkByType(CourseWorkType.ASSIGNMENT).size());
		}
			
		final Grade grade = new Grade();
		grade.setAssignmentAverage(assignmentPercentage);
		grade.setPercentage(assignmentPercentage);
		student.setGrade(grade);
	}
	
	/**
	 * This method shall calculate and add the extra credit to assignment average.
	 * 
	 * @param student
	 * @param extraCreditWeightage
	 */
	private void addExtraCreditAssignmentToAverage(final Student student, final Weightage extraCreditWeightage){
		
		Double assignmentPercentage = student.getGrade().getAssignmentAverage();
		assignmentPercentage +=  (student.getCourseWorkByType(CourseWorkType.EXTRA_CREDIT_ASSIGNMENT).size() 
				* extraCreditWeightage.getPercentage());
		
		//after adding extra credit if the assignment percentage goes above 100 then we will set the assignment percentage as 100
		assignmentPercentage = (assignmentPercentage.doubleValue() > 100.00 ? 100 : assignmentPercentage);
		
		student.getGrade().setAssignmentAverage(assignmentPercentage);
		student.getGrade().setPercentage(assignmentPercentage);
	}
	
	
	/**
	 * This method shall calculate the examination average.
	 * 
	 * @param student
	 * @param weightageConfiguration
	 * @return
	 */
	private void calculateExaminationAverage(final Student student){
		
		Double examinationPercentage = new Double(BigDecimal.ZERO.doubleValue());
		
		if(student.getCourseWorkByType(CourseWorkType.EXAMINATION).size() > BigDecimal.ZERO.intValue()){
			for(final CourseWork examination : student.getCourseWorkByType(CourseWorkType.EXAMINATION)){
				examinationPercentage += examination.getScore().getPercentage();
			}
			examinationPercentage = (examinationPercentage / student.getCourseWorkByType(CourseWorkType.EXAMINATION).size());
		}
		student.getGrade().setExaminationAverage(examinationPercentage);
		
		if(student.getGrade().getPercentage() == BigDecimal.ZERO.doubleValue()){
			student.getGrade().setPercentage(examinationPercentage);
		}
	}
}
