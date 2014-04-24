package org.sanju.student.grading.bean;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.sanju.student.grading.bean.Score;

/**
 * This test class test all behaviors in Score class.
 * 
 * @author Kalai
 *
 */
public class ScoreBehavior {

	private Score score;
	
	@Before
	public void setUp(){
		score = new Score ();
	}
	
	@Test
	public void shuldSetPercentage(){
		score.setPercentage(10.0);
		assertEquals(new Double(10.0), score.getPercentage());
	}
	
	@Test(expected = java.lang.IllegalArgumentException.class)
	public void shouldThrowIllegalArgumentException(){
		score.setPercentage(102.0);
	}
	
	@Test(expected = java.lang.NullPointerException.class)
	public void shouldThrowNullPointerException(){
		score.setPercentage(null);
	}
}
