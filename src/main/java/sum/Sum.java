package sum;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Sum {
	private static final Pattern delimiterPattern = Pattern.compile("//(.)\n(.*)");
	private static final String DEFAULT_DELIMITER_REGEX = "[,:]";

	public static int sum(String sumParam) {
		if (sumParam == null) {
			return 0;
		}

		return new ValueList(parseValueList(sumParam)).sum();
	}

	private static String[] parseValueList(String sumParam) {
		Matcher m = delimiterPattern.matcher(sumParam);
		if (m.find()) {
			String customDelimiter = m.group(1);
			return m.group(2).split(customDelimiter);
		}

		return sumParam.split(DEFAULT_DELIMITER_REGEX);
	}
}
