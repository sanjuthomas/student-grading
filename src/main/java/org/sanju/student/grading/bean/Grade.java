package org.sanju.student.grading.bean;

/**
 * Pojo class for Grade
 * 
 * @author Kalai
 *
 */
public class Grade {
	
	private Double percentage = new Double(0);
	
	private Double assignmentAverage;
	
	private Double examinationAverage;
	
	public Double getAssignmentAverage() {
		return assignmentAverage;
	}

	public void setAssignmentAverage(final Double assignmentAverage) {
		this.assignmentAverage = assignmentAverage;
	}

	public Double getExaminationAverage() {
		return examinationAverage;
	}

	public void setExaminationAverage(final Double examinationAverage) {
		this.examinationAverage = examinationAverage;
	}

	public Double getPercentage() {
		return this.percentage;
	}

	public void setPercentage(final Double percentage) {
		this.percentage = percentage;
	}
	
}
