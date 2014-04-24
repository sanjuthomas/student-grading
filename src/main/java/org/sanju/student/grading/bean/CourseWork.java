package org.sanju.student.grading.bean;

import org.sanju.student.grading.enums.CourseWorkType;

/**
 * This class shall encapsulate the common state and behavior for assignment and examination.
 * 
 * @author thosan
 *
 */
public abstract class CourseWork {
	
	private Integer id;
	
	private CourseWorkType courseWorkType;
	
	private Score score;
	
	public Integer getId() {
		return id;
	}

	public void setId(final Integer id) {
		this.id = id;
	}

	public Score getScore() {
		return score;
	}

	public void setScore(Score score) {
		this.score = score;
	}

	public CourseWorkType getCourseWorkType() {
		return this.courseWorkType;
	}

	protected void setCourseWorkType(final CourseWorkType courseWorkType) {
		this.courseWorkType = courseWorkType;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
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
		final CourseWork other = (CourseWork) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
}
