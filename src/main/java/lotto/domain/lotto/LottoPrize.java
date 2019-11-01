package lotto.domain.lotto;

import java.util.*;
import java.util.stream.Collectors;

public enum LottoPrize {

	FIRST(6, 2_000_000_000, true),
	SECOND(5, 1_500_000, true),
	THIRD(4, 50_000, true),
	FIRTH(3, 5_000, true),
	FIFTH(2, 0, false),
	SIXTH(1, 0, false),
	LOST(0, 0, false),
	UNKNOWN(-1, 0, false);

	private final long sameNumberCount;
	private final long rewardAmount;
	private final boolean isDisplayed;

	LottoPrize(long sameNumberCount, long rewardAmount, boolean isDisplayed) {
		this.sameNumberCount = sameNumberCount;
		this.rewardAmount = rewardAmount;
		this.isDisplayed = isDisplayed;
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

	public static List<LottoPrize> displayedLottoPrizes() {
		return Arrays.stream(LottoPrize.values())
				.filter(LottoPrize::isDisplayed)
				.sorted(Comparator.comparing(LottoPrize::getRewardAmount))
				.collect(Collectors.toList());
	}

	public long getRewardAmount() {
		return rewardAmount;
	}

	public boolean isDisplayed() {
		return isDisplayed;
	}

	@Override
	public String toString() {
		return String.format("%s개 일치 (%s원)", sameNumberCount, rewardAmount);
	}

}
