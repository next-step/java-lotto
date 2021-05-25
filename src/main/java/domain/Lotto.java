package domain;

import java.util.Arrays;

public class Lotto {
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
