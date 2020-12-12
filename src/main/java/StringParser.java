import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

import org.apache.commons.lang3.StringUtils;

public class StringParser {

	private static final String DEFAULT_DELIMITER = ",|:";
	private static final String CUSTOM_DELIMITER_REGX = "//(.)\n(.*)";
	private static final int DELIMITER_INDEX = 1;
	private static final int SPLIT_TARGET_TEXT_INDEX = 2;

	private StringParser() {
		throw new AssertionError();
	}

	public static ParsedNumbers parse(String input) {
		if (StringUtils.isEmpty(input)) {
			return new ParsedNumbers(new ParsedNumber());
		}
		return new ParsedNumbers(parseToNumberList(input));
	}

	private static List<ParsedNumber> parseToNumberList(String input) {
		return splitString(input).stream()
			.map(ParsedNumber::new)
			.collect(Collectors.toList());
	}

	private static List<String> splitString(String input) {
		Matcher m = Pattern.compile(CUSTOM_DELIMITER_REGX).matcher(input);
		String delimiter = DEFAULT_DELIMITER;
		if (m.find()) {
			delimiter = m.group(DELIMITER_INDEX);
			input = m.group(SPLIT_TARGET_TEXT_INDEX);
		}
		return splitByCustomDelimiter(delimiter, input);
	}

	private static List<String> splitByCustomDelimiter(String delimiter, String targetText) {
		return Arrays.asList(targetText.split(delimiter));
	}
}
