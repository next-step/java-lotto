package study.step2.domain.value;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class InputText {
	private static final String BASIC_DELIMITER = ",|:";

	public static String[] split(String text) {
		Matcher m = Pattern.compile("//(.)\n(.*)").matcher(text);
		if (m.find()) {
			String customDelimiter = m.group(1) + "|" + BASIC_DELIMITER;
			return m.group(2).split(customDelimiter);
		}
		return text.split(BASIC_DELIMITER);
	}



}
