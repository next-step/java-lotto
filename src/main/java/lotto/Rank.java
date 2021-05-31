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
		validateCount(countOfMatch);

		if (countOfMatch == SECOND_OR_THIRD) {
			return matchBonus ? SECOND : THIRD;
		}

		return Arrays.stream(values())
			.filter(w -> w.countOfMatch == countOfMatch)
			.findFirst()
			.orElse(NONE);
	}

	private static void validateCount(long countOfMatch) {
		if (countOfMatch < 0L || 6L < countOfMatch) {
			throw new OutOfBoundValueException("일치 갯수는 0 에서 6 사이의 숫자만 존재합니다.");
		}
	}

	public long award() {
		return winningAward;
	}
}
