package lotto.domain;

public class Number {
	private static final int MIN_NUMBER = 1;
	private static final int MAX_NUMBER = 45;
	private final int value;

	public Number(int value) {
		isBetweenOneAndFortyFive(value);
		this.value = value;
	}

	public int getValue() {
		return value;
	}

	private void isBetweenOneAndFortyFive(int value) {
		if (value < MIN_NUMBER || value > MAX_NUMBER) {
			throw new RuntimeException();
		}
	}
}
