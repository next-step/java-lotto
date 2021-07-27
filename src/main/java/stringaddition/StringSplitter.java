package stringaddition;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringSplitter {

	private static final String DELIMITER = ",|:";
	private static final String[] ZERO = {"0"};

	public String[] split(String text) {
		if (isBlank(text)) {
			return ZERO;
		}

		String[] split;
		if (text.startsWith("//")) {
			Matcher matcher = Pattern.compile("//(.)\n(.*)").matcher(text);
			matcher.find();
			String customDelimiter = matcher.group(1);
			split = matcher.group(2).split(customDelimiter);
		} else {
			split = text.split(DELIMITER);
		}

		validate(split);

		return split;
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
