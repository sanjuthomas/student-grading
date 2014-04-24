package org.sanju.student.grading.bean;

import org.sanju.student.grading.enums.CourseWorkType;

/**
 * Pojo class for examination
 * 
 * @author Kalai
 *
 */
public class Examination extends CourseWork {
	
	
	public Examination(){
		super.setCourseWorkType(CourseWorkType.EXAMINATION);
	}

}
