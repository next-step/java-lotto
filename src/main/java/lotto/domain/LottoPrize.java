package lotto.domain;

import java.util.Arrays;

public enum LottoPrize {

	FIRST(6, 2_000_000_000),
	SECOND(5, 30_000_000),
	THIRD(5, 1_500_000),
	FOURTH(4, 50_000),
	FIFTH(3, 5_000),
	NONE(0, 0);

	private final int matchCount;
	private final int prizeMoney;

	LottoPrize(int matchCount, int prizeMoney) {
		this.matchCount = matchCount;
		this.prizeMoney = prizeMoney;
	}

	public static LottoPrize from(int matchCount, boolean hasBonusNumber) {
		LottoPrize lottoPrize = Arrays.stream(values())
									.filter(prize -> prize.matchCount == matchCount)
									.findFirst()
									.orElse(LottoPrize.NONE);

		if (lottoPrize == SECOND && !hasBonusNumber) {
			return THIRD;
		}
		return lottoPrize;
	}

	public long matchCount() {
		return matchCount;
	}

	public int prizeMoney() {
		return prizeMoney;
	}

	public boolean isNone() {
		return this == NONE;
	}
}
