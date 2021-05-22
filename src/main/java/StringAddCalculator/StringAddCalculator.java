package StringAddCalculator;

public class StringAddCalculator {
	public static int splitAndReturnSum(String input) {
		Input input1 = new Input(input);

		return getSum(input1.getStringNumbers());
	}

	private static int getSum(String[] stringNumbers) {
		Numbers numbers = new Numbers(stringNumbers);

		return numbers.getSum();
	}
}
