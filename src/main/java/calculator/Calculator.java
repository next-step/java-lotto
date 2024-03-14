package calculator;

public class Calculator {
	private final String inputText;

	public Calculator(String inputText) {
		this.inputText = inputText;
	}

	public Integer calculatedInteger() {
		String[] inputs = StringUtil.splitInput(inputText);

		int result = Integer.parseInt(inputs[0]);

		for (int i = 1; i < inputs.length; i++) {
			result = calculate(i, result, inputs);
		}

		return result;
	}

	private static int calculate(final int index, int result, final String[] inputs) {
		if (index % 2 == 1) {
			result = new Operator(inputs[index], result, Integer.parseInt(inputs[index + 1])).execute();
		}
		return result;
	}
}
