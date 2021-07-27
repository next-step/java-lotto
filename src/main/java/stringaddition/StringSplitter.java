package stringaddition;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringSplitter {

	private static final String[] ZERO = {"0"};
	private static final String DELIMITER = "[,:]";
	private static final String CUSTOM_DELIMITER = "//(.)\n(.*)";

	public String[] split(String text) {
		if (isBlank(text)) {
			return ZERO;
		}

		String[] split = customSplit(text);
		validate(split);

		return split;
	}

	private String[] customSplit(String text) {
		Matcher matcher = Pattern.compile(CUSTOM_DELIMITER).matcher(text);
		if (matcher.find()) {
			String customDelimiter = matcher.group(1);
			return matcher.group(2).split(customDelimiter);
		}
		return text.split(DELIMITER);
	}

	private void validate(String[] split) {
		for (String s : split) {
			invalidText(s);
			validInt(s);
		}
	}

	private void validInt(String s) {
		if (isNegative(s)) {
			throw new SplitException();
		}
	}

	private boolean isNegative(String s) {
		return Integer.parseInt(s) < 0;
	}

	private void invalidText(String s) {
		try {
			Integer.parseInt(s);
		} catch (NumberFormatException e) {
			throw new SplitException("숫자가 아닌 문자를 포함하는 문자열은 계산할 수 없습니다.");
		}
	}

	private boolean isBlank(String text) {
		return text == null || text.trim().isEmpty();
	}

}
