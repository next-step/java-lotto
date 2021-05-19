package wootecam.calculator;

import java.util.List;

public class StringAddCalculator {
	public static int splitAndSum(String input) {

		DefaultStringTokenizer dst = new DefaultStringTokenizer();

		List<String> numbers = dst.getNumbers(input);

		return numbers.stream()
			.map(CalculatorNumber::new)
			.map(CalculatorNumber::parseNumber)
			.reduce(0, Integer::sum);
	}
}
