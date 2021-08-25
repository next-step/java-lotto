package lotto.domain;

public class Number {
	private final int value;

	public Number(int value) {
		isBetweenOneAndFortyFive(value);
		this.value = value;
	}

	public int getValue() {
		return value;
	}

	private void isBetweenOneAndFortyFive(int value) {
		if (value < 1 || value > 45) {
			throw new RuntimeException();
		}
	}
}
