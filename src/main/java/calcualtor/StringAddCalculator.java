package calcualtor;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringAddCalculator {
	public static int splitAndSum(String input) {
		if (input == null || input.isEmpty()) {
			return 0;
		}
		if (input.length() == 1) {
			return Integer.parseInt(input);
		}
		if (Pattern.compile("^-?\\d+[,]-?\\d+$").matcher(input).matches()) {
			String[] tokens = input.split(",");
			return Integer.parseInt(tokens[0]) + Integer.parseInt(tokens[1]);
		}
		if (Pattern.compile("^(-?\\d+[,:])+-?\\d+$").matcher(input).matches()) {
			String[] tokens = input.split(",|:");

			int result = 0;
			for (String token : tokens) {
				result += Integer.parseInt(token);
			}
			return result;
		}
		Matcher matcher = Pattern.compile("//(.)\n(.*)").matcher(input);
		if (matcher.find()) {
			String customDelimiter = matcher.group(1);
			String[] tokens = matcher.group(2).split(customDelimiter);

			int result = 0;
			for (String token : tokens) {
				result += Integer.parseInt(token);
			}
			return result;
		}

		throw new IllegalArgumentException("처리할 수 없는 input 입니다.");
	}
}
