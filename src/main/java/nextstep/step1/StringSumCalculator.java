package nextstep.step1;

import java.util.stream.Stream;

public class StringSumCalculator {
	public int sum(String inputString) {
		if (inputString == null || inputString.isEmpty()) {
			return 0;
		}

		String[] inputStrings = inputString.split(",|:");
		return Stream.of(inputStrings)
				.mapToInt(input -> getPositiveNumber(input))
				.sum();
	}

	private int getPositiveNumber(String input) {
		try {
			int positiveNumber = Integer.parseInt(input);
			if (positiveNumber < 0) {
				throw new RuntimeException("input값은 양수만 가능합니다.");
			}
			return positiveNumber;
		} catch (NumberFormatException ex) {
			throw new RuntimeException("input값은 양수만 가능합니다.");
		}
	}

}
