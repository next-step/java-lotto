package stringAddCalculator;

public class StringAddCalculator {
	public static int splitAndReturnSum(String inputFromUser) {
		Input input = new Input(inputFromUser);

		return getSum(input.getStringNumbers());
	}

	private static int getSum(String[] stringNumbers) {
		Numbers numbers = new Numbers(stringNumbers);

		return numbers.getSum();
	}
}
