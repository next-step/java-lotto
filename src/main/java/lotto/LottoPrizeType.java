package lotto;

import java.math.BigDecimal;
import java.util.Arrays;

public enum LottoPrizeType {
	NO_MATCHED(0, BigDecimal.ZERO),
	THREE_MATCHED(3, BigDecimal.valueOf(5_000)),
	FOUR_MATCHED(4, BigDecimal.valueOf(50_000)),
	FIVE_MATCHED(5, BigDecimal.valueOf(1_500_000)),
	SIX_MATCHED(6, BigDecimal.valueOf(2_000_000_000));

	private static final int MAXIMUM_MATCHED_NUMBER = 6;
	private static final int MINIMUM_WINNING_MATCHED_NUMBER = 3;

	private final int matchedNumberCount;
	private final BigDecimal prizeMoney;

	LottoPrizeType(int matchedNumberCount, BigDecimal prizeMoney) {
		this.matchedNumberCount = matchedNumberCount;
		this.prizeMoney = prizeMoney;
	}

	public static LottoPrizeType valueByMatchedNumberCount(int matchedNumberCount) {
		return Arrays.stream(LottoPrizeType.values())
				.filter(it -> it.matchedNumberCount == matchedNumberCount)
				.findFirst()
				.orElse(NO_MATCHED);
	}

	public boolean isWinningType() {
		return matchedNumberCount <= MAXIMUM_MATCHED_NUMBER && matchedNumberCount >= MINIMUM_WINNING_MATCHED_NUMBER;
	}

	public int getMatchedNumberCount() {
		return matchedNumberCount;
	}

	public BigDecimal getPrizeMoney() {
		return prizeMoney;
	}
}
