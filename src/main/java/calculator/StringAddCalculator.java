package calculator;

import java.util.Arrays;

public class StringAddCalculator {

	private StringAddCalculator() {

	}

	public static int splitAndAdd(String input) {
		String[] splitString = splitString(input);

		return addStringElements(splitString);
	}

	private static String[] splitString(String input) {
		return input.split("[,;]");
	}

	private static int addStringElements(String[] elements) {
		return Arrays.stream(elements)
					.map(Integer::parseInt)
					.reduce(0, Integer::sum);
	}
}
