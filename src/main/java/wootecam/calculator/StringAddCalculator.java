package wootecam.calculator;

import java.util.List;

public class StringAddCalculator {
	public static int splitAndSum(String input) {

		StringTokenizer stringTokenizer = StringTokenizerFactory.getStringTokenizer(input);
		List<String> numbers = stringTokenizer.getNumbers(input);

		return numbers.stream()
			.map(CalculatorNumber::new)
			.map(CalculatorNumber::parseNumber)
			.reduce(0, Integer::sum);
	}
}
