package study;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringAddCalculator {

	public static int splitAndSum(String input) {
		if (input == null || input.isEmpty()) {
			return 0;
		}
		return sum(splitStr(input));
	}

	private static String[] splitStr(String text){
		String regex = ",|:";
		Matcher m = Pattern.compile("//(.)\n(.*)").matcher(text);
		if (m.find()) {
			String customDelimiter = m.group(1);
			return m.group(2).split(customDelimiter);
		}
		return text.split(regex);
	}

	private static int sum(String[] inputs) {
		int result = 0;
		for (String str : inputs) {
			int num = Integer.parseInt(str);
			if (num < 0) {
				throw new RuntimeException();
			}
			result += num;
		}
		return result;
	}

}
