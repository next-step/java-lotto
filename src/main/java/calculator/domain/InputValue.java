package calculator.domain;

public class InputValue {
	public static final String NEGATIVE_NUMBER_ERROR_MESSAGE = "음수를 입력할수 없습니다.";
	private final int value;

	public InputValue(String inputText) {
		this.value = parseInteger(inputText);
	}

	public int getValue() {
		return this.value;
	}

	private int parseInteger(String text) {
		int parseInt = Integer.parseInt(text);
		isNegativeNumber(parseInt);
		return parseInt;
	}

	private void isNegativeNumber(int parseInt) {
		if (parseInt < 0) {
			throw new RuntimeException(NEGATIVE_NUMBER_ERROR_MESSAGE);
		}
	}
}
