package lotto;

import java.util.Arrays;

public enum Rank {
	FIRST(6, 2_000_000_000L),
	SECOND(5, 30_000_000L),
	THIRD(5, 1_500_000L),
	FOURTH(4, 50_000L),
	FIFTH(3, 5_000L),
	NONE(0, 0);

	private static final int SECOND_OR_THIRD = 5;

	private final int countOfMatch;
	private final long winningAward;

	Rank(int countOfMatch, long winningAward) {
		this.countOfMatch = countOfMatch;
		this.winningAward = winningAward;
	}

	public static Rank valueOf(long countOfMatch, boolean matchBonus) {
		validateWinnerValue(countOfMatch);

		if (countOfMatch == SECOND_OR_THIRD) {
			return matchBonus ? SECOND : THIRD;
		}

		return Arrays.stream(values())
			.filter(w -> w.countOfMatch == countOfMatch)
			.findFirst()
			.orElse(NONE);
	}

	private static void validateWinnerValue(long countOfMatch) {
		if (countOfMatch < 0L || 6L < countOfMatch) {
			throw new IllegalArgumentException("Winners only have values between 0 and 6.");
		}
	}

	public long award() {
		return winningAward;
	}
}
