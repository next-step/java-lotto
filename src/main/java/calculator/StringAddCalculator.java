package calculator;

public class StringAddCalculator {
	public static int splitAndSum(String input) {
		return StringParser.parse(input).sum();
	}
}
