package domain;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringAddCalculator {

	public static int splitAndSum(String operationTargetString) {
		if(operationTargetString == null || operationTargetString.isEmpty()) {
			return 0;
		}
		String[] operationTargets = null;
		int result = 0;
		Matcher m = Pattern.compile("//(.)\n(.*)").matcher(operationTargetString);
		if (m.find()) {
		    String customDelimiter = m.group(1);
		    operationTargets= m.group(2).split(customDelimiter);
		    // 덧셈 구현
		}

		if (operationTargets == null) {
			operationTargets = operationTargetString.split(":|,");
		}
		
		for(String inputValue : operationTargets) {
			if(Integer.parseInt(inputValue) < 0) {
				throw new RuntimeException();
			}
			result += Integer.parseInt(inputValue);
		}
		return result;
	}
}
