package lotto.domain.lotto;

import java.util.HashMap;
import java.util.Map;

public enum LottoPrize {

	FIRST(6, 2_000_000_000),
	SECOND(5, 1_500_000),
	THIRD(4, 50_000),
	FIRTH(3, 5_000),
	FIFTH(2, 0),
	SIXTH(1, 0),
	LOST(0, 0),
	UNKNOWN(-1, 0);

	private final long sameNumberCount;
	private final long rewardAmount;

	LottoPrize(long sameNumberCount, long rewardAmount) {
		this.sameNumberCount = sameNumberCount;
		this.rewardAmount = rewardAmount;
	}

	private static final Map<Long, LottoPrize> cachingLottoPrize = new HashMap<>();

	static {
		for (LottoPrize lottoPrize : LottoPrize.values()) {
			cachingLottoPrize.put(lottoPrize.sameNumberCount, lottoPrize);
		}

	}

	public static LottoPrize of(long sameNumberCount) {
		return cachingLottoPrize.getOrDefault(sameNumberCount, UNKNOWN);
	}

}
