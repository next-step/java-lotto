package utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SeparatedText {
	private static final int DELIMITER_GROUP_NUMBER = 1;
	private static final int TEXTS_GROUP_NUMBER = 2;
	private static final String PATTERN = "//(.)\n(.*)";
	private static final String DEFAULT_DELIMITER = ",|:";
	private static final String PATTERN_DELIMITER = "|";

	private String delimiter;
	private String texts;


	public SeparatedText(final String delimiter, final String texts){
		this.delimiter = delimiter;
		this.texts = texts;
	}

	public String getDelimiter(){
		return this.delimiter;
	}

	public String getTexts(){
		return this.texts;
	}

	public static SeparatedText findSeparator(final String text){
		if (StringUtils.isEmpty(text)) {
			return new SeparatedText(DEFAULT_DELIMITER, "");
		}
		Matcher m = Pattern.compile(PATTERN).matcher(text);
		if (false == m.find()) {
			return new SeparatedText(DEFAULT_DELIMITER, text);
		}
		String delimiter = m.group(DELIMITER_GROUP_NUMBER);
		String texts= m.group(TEXTS_GROUP_NUMBER);
		return new SeparatedText(addDelimiter(delimiter), texts);
	}

	private static String addDelimiter(final String delimiter){
		return new StringBuilder(DEFAULT_DELIMITER)
			.append(PATTERN_DELIMITER)
			.append(delimiter)
			.toString();
	}
}
