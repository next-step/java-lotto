package generate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Separator {
	private static final String SPLIT_COMMA_COLON = ",|:";

	public static List<String> split (String input) {

		checkSpecialCharacters(input);

		return removeSpace(input);
	}
	private static List<String> removeSpace (String input) {
		List<String> numbers = new ArrayList<>();

		for (String number : input.split(SPLIT_COMMA_COLON)) {
			numbers.add(number.trim());
		}

		return numbers;
	}

	private static void checkSpecialCharacters (String input) {
		checkCustomSeparator(input);
	}

	private static void checkCustomSeparator (String input) {

	}
}
