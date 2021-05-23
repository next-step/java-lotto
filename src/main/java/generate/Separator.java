package generate;

import util.ExceptionMessage;
import util.InputValidation;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static util.SeparateDelimiter.*;

public class Separator {
	public static List<String> split (String input) {
		List<String> numbers = new ArrayList<>();

		checkFormat(input, numbers);

		if (numbers.size() < 1) {
			throw new IllegalArgumentException(ExceptionMessage.SEPARATOR_EXCEPTION);
		}

		return numbers;
	}

	private static List<String> removeSpace (String[] input) {
		List<String> numbers = new ArrayList<>();

		for (String number : input) {
			numbers.add(number.trim());
		}

		return numbers;
	}

	private static void checkFormat (String input, List<String> numbers) {
		if (input.contains(SPLIT_COMMA) || input.contains(SPLIT_COLON)) {
			String[] split = input.split(SPLIT_COMMA + "|" + SPLIT_COLON);

			if (split.length > 1) {
				numbers.addAll(removeSpace(split));
			}
		}
		final Matcher matcher = Pattern.compile(SPLIT_CUSTOM).matcher(input);
		if (matcher.find()) {
			String separator = matcher.group(1);

			numbers.addAll(removeSpace(matcher.group(2).split(separator)));
		}
	}
}
