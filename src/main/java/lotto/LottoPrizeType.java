package lotto;

import java.math.BigDecimal;
import java.util.Arrays;

public enum LottoPrizeType {
	MISS(0, BigDecimal.ZERO),
	FIFTH(3, BigDecimal.valueOf(5_000)),
	FOURTH(4, BigDecimal.valueOf(50_000)),
	THIRD(5, BigDecimal.valueOf(1_500_000)),
	SECOND(5, BigDecimal.valueOf(30_000_000)),
	FIRST(6, BigDecimal.valueOf(2_000_000_000));

	private final int matchedNumberCount;
	private final BigDecimal prizeMoney;

	LottoPrizeType(int matchedNumberCount, BigDecimal prizeMoney) {
		this.matchedNumberCount = matchedNumberCount;
		this.prizeMoney = prizeMoney;
	}

	public static LottoPrizeType valueByMatchedNumberCount(int matchedNumberCount, boolean bonusBallMatched) {
		return Arrays.stream(LottoPrizeType.values())
				.filter(lottoPrizeType -> filterPrize(matchedNumberCount, bonusBallMatched, lottoPrizeType))
				.findFirst()
				.orElse(MISS);
	}

	private static boolean filterPrize(int matchedNumberCount, boolean bonusBallMatched, LottoPrizeType lottoPrizeType) {
		if (lottoPrizeType.matchedNumberCount == matchedNumberCount) {
			return lottoPrizeType != THIRD || !bonusBallMatched;
		}
		return false;
	}

	public boolean isWinningType() {
		return this != MISS;
	}

	public int getMatchedNumberCount() {
		return matchedNumberCount;
	}

	public BigDecimal getPrizeMoney() {
		return prizeMoney;
	}
}
