package lotto;

import java.util.Arrays;

public enum Winner {
	FIRST_PRIZE(6, 2000000000L),
	SECOND_PRIZE(5, 1500000L),
	THIRD_PRIZE(4, 50000L),
	FOURTH_PRIZE(3, 5000L),
	NONE(0, 0);

	int count;
	long prize;

	Winner(int count, long prize) {
		this.count = count;
		this.prize = prize;
	}

	public static Winner valueOf(int value) {
		validateWinnerValue(value);

		return Arrays.stream(values())
			.filter(winner -> winner.count == value)
			.findFirst()
			.orElse(Winner.NONE);
	}

	private static void validateWinnerValue(int value) {
		if (value < 0 || 6 < value) {
			throw new IllegalArgumentException("Winners only have values between 0 and 6.");
		}
	}
}
