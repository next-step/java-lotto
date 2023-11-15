package stringCalculator.domain;

public class Calculator {

	private Splitter splitter = new Splitter();
	private Parser parser = new Parser();

	public int calculate(String input) {
		String[] inputStrings = splitter.removeBlank(input);
		int result = parser.parseNumber(inputStrings[0]);
		for (int i = 1; i < inputStrings.length; i += 2) {
			Operator operator = Operator.toApply(inputStrings[i]);
			result = operator.calculate(result, parser.parseNumber(inputStrings[i + 1]));
		}
		return result;
	}
}
