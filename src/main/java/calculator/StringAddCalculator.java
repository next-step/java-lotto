package calculator;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringAddCalculator {

	private static final String CUSTOM_PATTERN = "//(.)\n(.*)";

	private final Matcher matcher;
	private String seperators = ",;";
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
		return input.split("[" + seperators + "]");
	}

	private int addStringElements(String[] elements) {
		return Arrays.stream(elements)
					.map(Integer::parseInt)
					.reduce(0, Integer::sum);
	}

	private void addCustomSeparator() {
		if (hasCustomSeparator()) {
			addSeparator(matcher.group(1));
			input = matcher.group(2);
		}
	}

	private boolean hasCustomSeparator() {
		return matcher.find();
	}

	private void addSeparator(String separator) {
		StringBuilder sb = new StringBuilder();
		sb.append(seperators);
		seperators = sb.append(separator).toString();
	}
}
