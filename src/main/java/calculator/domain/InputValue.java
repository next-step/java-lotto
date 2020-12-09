package calculator.domain;

public class InputValue {
	private final int value;

	public InputValue(String inputText) {
		this.value = parseInteger(inputText);
	}

	public int getValue() {
		return this.value;
	}

	private int parseInteger(String text) {
		try {
			int parseInt = Integer.parseInt(text);
			isNegativeNumber(parseInt);
			return parseInt;
		} catch (NumberFormatException numberFormatException) {
			throw new NumberFormatException();
		}
	}

	private void isNegativeNumber(int parseInt) {
		if (parseInt < 0) {
			throw new RuntimeException();
		}
	}
}
