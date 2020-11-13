package nextstep.step1;

import java.util.stream.Stream;

public class StringSumCalculator {
	public int sum(String inputString) {
		if (inputString == null || inputString.isEmpty()) {
			return 0;
		}

		String[] inputStrings = inputString.split(",|:");
		return Stream.of(inputStrings)
				.mapToInt(input -> Integer.parseInt(input))
				.sum();
	}


}
