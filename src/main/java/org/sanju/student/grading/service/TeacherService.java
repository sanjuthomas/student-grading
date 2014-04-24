package org.sanju.student.grading.service;

import org.sanju.student.grading.bean.Teacher;

/**
 * Service class to handle teacher object.
 * 
 * @author thosan
 *
 */
public class TeacherService {

	/**
	 * This method shall take an teacher id and create a teacher.
	 * 
	 * @param id
	 */
	public Teacher addTeacher(final Integer id) {
		final Teacher teacher = new Teacher();
		teacher.setId(id);
		return teacher;
	}

}
