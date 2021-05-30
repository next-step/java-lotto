package lotto.view;

import java.util.Optional;

public class OverZeroIntegertInput {
	int input;

	public OverZeroIntegertInput(String stringInput) {
		this.input = Optional.of(stringInput)
			.map(Integer::parseInt)
			.orElseThrow(() -> new RuntimeException("input must be integer number type"));

		if (this.input < 0) {
			throw new RuntimeException("input must be over 0");
		}
	}

	public int getNumber() {
		return input;
	}
}
