package lotto.enums;

import lotto.exceptions.NumberOutOfBoundsException;

public enum Prize {
	ZERO(0),
	ONE(0),
	TWO(0),
	THREE(5_000),
	FOUR(50_000),
	FIVE(1_500_000),
	SIX(2_000_000_000);

	private int prize;
	private static final int MIN_NUMBER = 0;
	private static final int MAX_NUMBER = 6;

	Prize(int prize) {
		this.prize = prize;
	}

	public int getPrize() {
		return this.prize;
	}

	public static Prize valueOf(int number) {
		if (number < MIN_NUMBER || MAX_NUMBER < number) {
			throw new NumberOutOfBoundsException(ErrorMessage.PRIZE_OUT_OF_BOUNDS.toString());
		}
		Prize[] prizes = Prize.values();
		return prizes[number];
	}
}
