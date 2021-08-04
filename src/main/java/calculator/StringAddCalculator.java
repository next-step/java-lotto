package calculator;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringAddCalculator {

	private static final String CUSTOM_PATTERN = "//(.)\n(.*)";
	private static final int SEPARATOR_GROUP = 1;
	private static final int FORMULA_GROUP = 2;

	private final Matcher matcher;
	private String separators = ",;";
	private String input;

	public StringAddCalculator(String input) {
		this.input = input;
		this.matcher = Pattern.compile(CUSTOM_PATTERN).matcher(input);
	}

	public int splitAndAdd() {
		addCustomSeparator();

		String[] splitString = splitString();

		return addStringElements(splitString);
	}

	private String[] splitString() {
		return input.split("[" + separators + "]");
	}

	private int addStringElements(String[] elements) {
		return Arrays.stream(elements)
					.map(StringUtils::toInt)
					.reduce(0, Integer::sum);
	}

	private void addCustomSeparator() {
		if (hasCustomSeparator()) {
			addSeparator(matcher.group(SEPARATOR_GROUP));
			input = matcher.group(FORMULA_GROUP);
		}
	}

	private boolean hasCustomSeparator() {
		return matcher.find();
	}

	private void addSeparator(String separator) {
		StringBuilder sb = new StringBuilder();
		sb.append(separators);
		separators = sb.append(separator).toString();
	}
}
