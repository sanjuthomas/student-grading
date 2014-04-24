package org.sanju.student.grading.bean;

/**
 * Score Pojo
 * 
 * @author Kalai
 *
 */
public class Score {
	
	private Double percentage;

	public Double getPercentage() {
		return this.percentage;
	}

	public void setPercentage(final Double percentage) {
		if(percentage <= 100){
			this.percentage = percentage;
		}else{
			throw new IllegalArgumentException("score percentage can't be greater than 100");
		}
	}

	@Override
	public String toString() {
		return "Score [percentage=" + percentage + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
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
		final Score other = (Score) obj;
		if (percentage == null) {
			if (other.percentage != null)
				return false;
		} else if (!percentage.equals(other.percentage))
			return false;
		return true;
	}
	
}
