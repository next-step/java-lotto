package domain;

import utils.StringUtils;
import utils.ValidationUtils;

public class StringAddCalculator {

	public static int splitAndSum(String operationTargetString) {
		
		if(ValidationUtils.checkEmpty(operationTargetString)) {
			return 0;
		}
		
		String[] operationTargets = OperatorSplitter.split(operationTargetString);
		
		return calculate(operationTargets);
	}

	private static int calculate(String[] operationTargets) {
		int result = 0;
		for(String inputValue : operationTargets) {
			int targetValue = StringUtils.parseInt(inputValue);
			result += ValidationUtils.checkNegativeValue(targetValue);
		}
		return result;
	}
}
