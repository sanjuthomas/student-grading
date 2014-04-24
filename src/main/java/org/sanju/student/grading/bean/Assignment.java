package org.sanju.student.grading.bean;

import org.sanju.student.grading.enums.CourseWorkType;

/**
 * Pojo class for assignment.
 * 
 * @author Kalai
 *
 */
public class Assignment extends CourseWork{
	
	public Assignment(final Boolean isExtraCredit){
		if(isExtraCredit){
			super.setCourseWorkType(CourseWorkType.EXTRA_CREDIT_ASSIGNMENT);
		}else{
			super.setCourseWorkType(CourseWorkType.ASSIGNMENT);
		}
	}

	public Boolean isExtraCredit(){
		return CourseWorkType.EXTRA_CREDIT_ASSIGNMENT == super.getCourseWorkType();
	}
}