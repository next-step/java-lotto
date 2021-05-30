package lotto.view;

public class OverZeroIntegertInput {
	int input;

	public OverZeroIntegertInput(String stringInput) {
		int input;

		try {
			input = Integer.parseInt(stringInput);
		} catch (Exception e) {
			throw new RuntimeException("input must be number type");
		}

		this.input = input;

		if (this.input < 0) {
			throw new RuntimeException("input must be over 0");
		}
	}

	public int getNumber() {
		return input;
	}
}
