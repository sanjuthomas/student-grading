package org.sanju.student.grading.bean;

import org.sanju.student.grading.enums.CourseWorkType;

/**
 * Pojo class for Weightage.
 * 
 * @author thosan
 *
 */
public class Weightage {
	
	private CourseWorkType courseWorkType;
	
	private Double percentage;
	
	public Weightage(final CourseWorkType courseWorkType){
		this.courseWorkType = courseWorkType;
	}

	public CourseWorkType getCourseWorkType() {
		return this.courseWorkType;
	}

	public void setPercentage(final Double percentage) {
		this.percentage = percentage;
	}

	public Double getPercentage() {
		return this.percentage;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((courseWorkType == null) ? 0 : courseWorkType.hashCode());
		result = prime * result
				+ ((percentage == null) ? 0 : percentage.hashCode());
		return result;
	}

	@Override
	public boolean equals(final Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		final Weightage other = (Weightage) obj;
		if (courseWorkType != other.courseWorkType)
			return false;
		if (percentage == null) {
			if (other.percentage != null)
				return false;
		} else if (!percentage.equals(other.percentage))
			return false;
		return true;
	}

}
