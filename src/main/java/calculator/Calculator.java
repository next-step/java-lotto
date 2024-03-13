package calculator;

public class Calculator {
	private final String inputText;

	public Calculator(String inputText) {
		this.inputText = inputText;
	}

	public Integer calculatedInteger() {
		String[] splitInput = StringUtil.splitInput(inputText);

		int result = Integer.parseInt(splitInput[0]);

		for (int i = 1; i < splitInput.length; i++) {
			result = calculate(i, result, splitInput);
		}

		return result;
	}

	private static int calculate(final int i, int result, final String[] splitInput) {
		if (i % 2 == 1) {
			result = new Operator(splitInput[i], result, Integer.parseInt(splitInput[i + 1])).execute();
		}
		return result;
	}
}
