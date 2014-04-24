package org.sanju.student.grading.bean;

import java.util.HashMap;
import java.util.Map;

import org.sanju.student.grading.enums.CourseWorkType;

/**
 * Relationship Object between Teacher and Weightage.
 * 
 * Since ExaminationWeightage and AssignmentWeightage are not 
 * part of the Teacher object we are creating a configuration object.
 * 
 * @author Kalai
 *
 */
public class WeightageConfiguration {
	
	private final Map<CourseWorkType, Weightage> courseTypeWeigtageMap = new HashMap<CourseWorkType, Weightage>();
	
	private Teacher teacher;
	
	public WeightageConfiguration(final Teacher teacher){
		this.teacher = teacher;
	}

	public Teacher getTeacher() {
		return this.teacher;
	}
	
	public void addWeightage(final Weightage weightage){
		courseTypeWeigtageMap.put(weightage.getCourseWorkType(), weightage);
	}
	
	public Weightage getWeightageByType(final CourseWorkType courseWorkType){
		return courseTypeWeigtageMap.get(courseWorkType);
	}
}
