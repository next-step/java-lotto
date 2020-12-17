package step1.domain;

import java.util.Arrays;

public class StringAddCalculator {

	public static int splitAndSum(final String input) {
		if (input == null || input.isEmpty()) {
			return 0;
		}
		InputSplitter inputSplitter = InputSplitterFactory.of(input);
		int[] numbers = inputSplitter.split(input);
		return Arrays.stream(numbers).sum();
	}

}
