package org.sanju.student.grading.bean;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.sanju.student.grading.enums.CourseWorkType;

/**
 * Student pojo class.
 * 
 * @author Kalai
 *
 */ 
public class Student {

	private Integer id;
	
	private Teacher teacher;
	
	private Grade grade;
	
	private Map<CourseWorkType, List<CourseWork>> courseWorkTypeMap = new HashMap<CourseWorkType, List<CourseWork>>();
	

	public void setId(final Integer id) {
		this.id = id;
	}

	public Integer getId() {
		return this.id;
	}

	public Teacher getTeacher() {
		return teacher;
	}

	public void setTeacher(final Teacher teacher) {
		this.teacher = teacher;
	}

	public Grade getGrade() {
		return grade;
	}

	public void setGrade(final Grade grade) {
		this.grade = grade;
	}
	
	public void addCourseWork(final CourseWork courseWork){
		if(null != this.courseWorkTypeMap.get(courseWork.getCourseWorkType())){
			this.courseWorkTypeMap.get(courseWork.getCourseWorkType()).add(courseWork);
		}else{
			final List<CourseWork> courseWorks = new ArrayList<CourseWork>();
			courseWorks.add(courseWork);
			this.courseWorkTypeMap.put(courseWork.getCourseWorkType(), courseWorks);
		}
	}

	public List<CourseWork> getCourseWorkByType(final CourseWorkType courseWorkType){
		List<CourseWork> courseWorks = courseWorkTypeMap.get(courseWorkType);
		if(null == courseWorks){
			courseWorks = new ArrayList<CourseWork>();
		}
		return courseWorks;
	}
}
