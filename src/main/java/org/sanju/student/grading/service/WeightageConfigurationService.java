package org.sanju.student.grading.service;

import org.sanju.student.grading.bean.Teacher;
import org.sanju.student.grading.bean.Weightage;
import org.sanju.student.grading.bean.WeightageConfiguration;

/**
 * This class shall contains all service method related WeightageConfiguration
 * 
 * @author thosan
 *
 */
public class WeightageConfigurationService {

	/**
	 * This method shall configure weightage for given teacher.
	 * 
	 * @param teacher
	 * @param weightage
	 * @return
	 */
	public WeightageConfiguration configure(Teacher teacher, Weightage... weightages) {
		final WeightageConfiguration weightageConfiguration = new WeightageConfiguration(teacher);
		for(Weightage weightage : weightages){
			weightageConfiguration.addWeightage(weightage);
		}
		return weightageConfiguration;
	}

}
