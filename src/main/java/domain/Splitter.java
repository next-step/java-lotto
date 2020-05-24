package domain;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Splitter {

	public static String[] split(String operationTargetString) {
		
		String[] operationTargets = customSplit(operationTargetString);

		if (operationTargets == null) {
			operationTargets = generalSplit(operationTargetString);
		}
		
		return operationTargets;
	}

	private static String[] generalSplit(String operationTargetString) {
		return operationTargetString.split(":|,");
	}

	private static String[] customSplit(String operationTargetString) {
		
		String[] operationTargets = null;
		
		Matcher matcher = Pattern.compile("//(.)\n(.*)").matcher(operationTargetString);
		if (matcher.find()) {
		    String customDelimiter = matcher.group(1);
		    operationTargets = matcher.group(2).split(customDelimiter);
		}

		return operationTargets;
	}
	
}
