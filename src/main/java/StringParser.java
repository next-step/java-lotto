import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

import org.apache.commons.lang3.StringUtils;

public class StringParser {
	public static List<Integer> parse(String input) {
		if (isEmptyString(input)) {
			return Collections.singletonList(0);
		}
		return splitToIntList(input);
	}

	private static boolean isEmptyString(String input) {
		return StringUtils.isEmpty(input);
	}

	private static List<Integer> splitToIntList(String input) {
		return splitString(input).stream()
			.map(StringParser::parseToInt)
			.collect(Collectors.toList());
	}

	private static List<String> splitString(String input) {
		Matcher m = Pattern.compile("//(.)\n(.*)").matcher(input);
		if (m.find()) {
			return splitByCustomDelimiter(m.group(1), m.group(2));
		}
		return splitByCommaOrColon(input);
	}

	private static List<String> splitByCommaOrColon(String input) {
		return Arrays.asList(input.split(",|:"));
	}

	private static List<String> splitByCustomDelimiter(String delimiter, String input) {
		return Arrays.asList(input.split(delimiter));
	}

	private static int parseToInt(String number) {
		int parsedInt = Integer.parseInt(number);
		if (parsedInt < 0) {
			throw new RuntimeException();
		}
		return parsedInt;
	}
}
