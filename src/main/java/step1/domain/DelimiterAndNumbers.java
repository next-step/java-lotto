package step1.domain;

import java.util.Arrays;
import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DelimiterAndNumbers {

	private static final int ZERO = 0;

	private static final Pattern SPACE = Pattern.compile("\\s");

	private static final String EMPTY_STRING = "";

	private static final Pattern DEFAULT_DELIMITER = Pattern.compile("[,:]");

	private static final Pattern NON_CUSTOM_DELIMITER_PATTERN = Pattern.compile("(\\d"+DEFAULT_DELIMITER+")*\\d");

	private static final Pattern CUSTOM_DELIMITER_PATTERN = Pattern.compile("//(.)\\\\n((\\d\\1)*\\d)");

	private static final Pattern NON_NUMBER_PATTERN = Pattern.compile("\\D");

	private final Pattern delimiter;

	private final int[] numbers;

	public DelimiterAndNumbers(String input) {
		String removedSpace = removeSpace(input);
		this.delimiter = initDelimiter(removedSpace);
		this.numbers = initNumbers(removedSpace);
	}
	//For Test
	public DelimiterAndNumbers(Pattern delimiter, int[] numbers) {
		this.delimiter = delimiter;
		this.numbers = numbers;
	}

	public int sum() {
		return Arrays.stream(numbers)
				.reduce(ZERO, Integer::sum);
	}

	private static String removeSpace(String string) {
		return SPACE.matcher(string)
				.replaceAll(EMPTY_STRING);
	}

	private Pattern initDelimiter(String input) {
		if(NON_CUSTOM_DELIMITER_PATTERN.matcher(input)
										.matches()) {
			return DEFAULT_DELIMITER;
		}

		if(CUSTOM_DELIMITER_PATTERN.matcher(input).matches()) {
			return Pattern.compile(extractSpecificGroup(CUSTOM_DELIMITER_PATTERN.matcher(input),1));
		}

		throw new RuntimeException("숫자만 더할 수 있습니다.");
	}

	private int[] initNumbers(String input) {
		if(delimiter != DEFAULT_DELIMITER) {
			Matcher customDelimiterPatternMatcher = CUSTOM_DELIMITER_PATTERN.matcher(input);
			input = extractSpecificGroup(customDelimiterPatternMatcher, 2);
		}

		return parseInt(delimiter.split(input));
	}

	private String extractSpecificGroup(Matcher patternMatcher, int groupNumber) {
		String numbers = null;
		while (patternMatcher.find()) {
			numbers = patternMatcher.group(groupNumber);
		}
		return numbers;
	}

	private int[] parseInt(String[] split) {
		if(Arrays.stream(split)
				.mapToInt(Integer::parseInt)
				.anyMatch(number -> number < ZERO)) {
			throw new RuntimeException("양수만 더할 수 있습니다.");
		}
		return Arrays.stream(split)
					.mapToInt(Integer::parseInt)
					.toArray();
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
