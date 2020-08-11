package step1;

import java.util.Arrays;
import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DelimiterAndNumbers {

	private static final int ZERO = 0;

	private static final Pattern SPACE = Pattern.compile("\\s");

	private static final String EMPTY_STRING = "";

	private static final String CUSTOM_DELIMITER_PREFIX = "//";

	private static final Pattern DEFAULT_DELIMITER = Pattern.compile("[,:]");

	private static final Pattern CUSTOM_DELIMITER_PATTERN = Pattern.compile("(//)(.)(\\\\n)(.+)");

	private final Pattern delimiter;

	private final String[] numbers;

	public DelimiterAndNumbers(String input) {
		String removedSpace = removeSpace(input);
		this.delimiter = initDelimiter(removedSpace);
		this.numbers = initNumbers(removedSpace);
	}
	//For Test
	public DelimiterAndNumbers(Pattern delimiter, String[] numbers) {
		this.delimiter = delimiter;
		this.numbers = numbers;
	}

	public int sum() {
		return Arrays.stream(numbers)
				.map(Integer::parseInt)
				.reduce(ZERO, Integer::sum);
	}

	private static String removeSpace(String string) {
		return SPACE.matcher(string)
				.replaceAll(EMPTY_STRING);
	}

	private Pattern initDelimiter(String input) {
		if(!input.startsWith(CUSTOM_DELIMITER_PREFIX)) {
			return DEFAULT_DELIMITER;
		}
		Matcher customDelimiterPatternMatcher = CUSTOM_DELIMITER_PATTERN.matcher(input);
		return Pattern.compile(extractSpecificGroup(customDelimiterPatternMatcher,2));

	}

	private String[] initNumbers(String input) {
		if(delimiter != DEFAULT_DELIMITER) {
			Matcher customDelimiterPatternMatcher = CUSTOM_DELIMITER_PATTERN.matcher(input);
			input = extractSpecificGroup(customDelimiterPatternMatcher, 4);
		}

		return delimiter.split(input);
	}

	private String extractSpecificGroup(Matcher patternMatcher, int groupNumber) {
		String numbers = null;
		while (patternMatcher.find()) {
			numbers = patternMatcher.group(groupNumber);
		}
		return numbers;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		DelimiterAndNumbers that = (DelimiterAndNumbers) o;
		return delimiter.pattern().equals(that.delimiter.pattern()) &&
				Arrays.equals(numbers, that.numbers);
	}

	@Override
	public int hashCode() {
		int result = Objects.hash(delimiter.pattern());
		result = 31 * result + Arrays.hashCode(numbers);
		return result;
	}
}
