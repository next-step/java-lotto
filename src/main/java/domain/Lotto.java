package domain;

import java.util.Arrays;

public class Lotto {
	public static final Integer LOTTO_NUMBER_LENGTH = 6;

	private final Integer[] numbers;

	public Lotto (Integer[] numbers) {
		this.numbers = numbers;
	}

	public Integer[] numbers () {
		return numbers;
	}

	@Override
	public String toString() {
		return "[" + Arrays.toString(numbers) + "]";
	}
}
