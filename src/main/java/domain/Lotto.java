package domain;

import java.util.Arrays;

public class Lotto {
	public static final Integer LOTTO_NUMBER_LENGTH = 6;
	private Integer matchCount;

	private final Integer[] numbers;

	public Lotto (Integer[] numbers) {
		this.numbers = numbers;
	}

	@Override
	public String toString() {
		return Arrays.toString(numbers);
	}

	public Integer[] numbers () {
		return numbers;
	}

	public Integer matchCount () {
		return matchCount;
	}

	public void matchCount (Integer matchCount) {
		this.matchCount = matchCount;
	}
}
