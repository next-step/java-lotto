package calculator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringAddCalculator {

	public static int splitAndSum(String text) {
		if(text == null) {
			return 0;
		}

		if(text.isEmpty()) {
			return 0;
		}

		String[] tokens= text.split(",|:");
		Matcher m = Pattern.compile("//(.)\n(.*)").matcher(text);
		if (m.find()) {
			String customDelimiter = m.group(1);
			tokens = m.group(2).split(customDelimiter);
		}

		Numbers numbers = new Numbers();

		for(String input : tokens) {
			numbers.add(new Number(input));
		}

		return numbers.sum();
	}
}
