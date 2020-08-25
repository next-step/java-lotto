package step1;

import org.apache.commons.lang3.StringUtils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringAddCalculator {

	private static final String DEFAULT_DELIMITER = ",|:";

	private static String[] splitString(String text){
		// java.util.regex 패키지의 Matcher, Pattern import
		if(StringUtils.isEmpty(text)) return new String[0];

		Matcher m = Pattern.compile("//(.)\n(.*)").matcher(text);
		if (m.find()) {
			String customDelimiter = m.group(1);
			String[] tokens= m.group(2).split(customDelimiter);
			// 덧셈 구현

			return tokens;
		}

		return text.split(DEFAULT_DELIMITER);
	}

	public static int splitAndSum(String str) {
		String[] tokens = splitString(str);
		Number result = new Number();

		for(String s : tokens){
			result.add(new Number(s));
		}

		return result.getNumber();
	}
}
