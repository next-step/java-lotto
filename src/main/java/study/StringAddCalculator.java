package study;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringAddCalculator {

	public static int splitAndSum(String input) {
		int result = 0;
		if (input == null || input.isEmpty()) {
			return result;
		}

		String regex = ",|:";
		Matcher m = Pattern.compile("//(.)\n(.*)").matcher(input);
		if (m.find()) {
			String customDelimiter = m.group(1);
			String[] tokens = m.group(2).split(customDelimiter);
			result = sum(result, tokens);
		} else {
			String[] inputs = input.split(regex);
			result = sum(result, inputs);
		}

		return result;
	}

	private static int sum(int result, String[] inputs) {
		for (String str : inputs) {
			result += Integer.parseInt(str);;
		}
		return result;
	}

}
