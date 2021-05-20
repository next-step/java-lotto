package wootecam.calculator;

import java.util.List;

import wootecam.util.StringUtils;

public class StringAddCalculator {
	public static int splitAndSum(String input) {

		if (StringUtils.isBlank(input)) {
			return 0;
		}

		StringTokenizer stringTokenizer = StringTokenizerFactory.getStringTokenizer(input);
		List<String> numbers = stringTokenizer.getNumbers(input);

		return sum(numbers);
	}

	private static Integer sum(List<String> numbers) {
		return numbers.stream()
			.map(CalculatorNumber::new)
			.map(CalculatorNumber::getNumber)
			.reduce(0, Integer::sum);
	}
}
