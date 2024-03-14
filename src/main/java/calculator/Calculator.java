package calculator;

public class Calculator {
	private final String inputText;

	public Calculator(String inputText) {
		this.inputText = inputText;
	}

	public Integer calculatedInteger() {
		validateInputText();

		String[] inputs = StringUtil.splitInput(inputText);

		int result = Integer.parseInt(inputs[0]);

		for (int i = 1; i < inputs.length; i++) {
			result = calculate(i, result, inputs);
		}

		return result;
	}

	private void validateInputText() {
		if(inputText == null || inputText.isEmpty()) {
			throw new IllegalArgumentException("null값이나 빈 공백 문자열은 입력할 수 없습니다. 다시 입력해주세요.");
		}
	}

	private static int calculate(final int index, int result, final String[] inputs) {
		if (index % 2 == 1) {
			result = new Operator(inputs[index], result, Integer.parseInt(inputs[index + 1])).execute();
		}
		return result;
	}
}
