package lotto.model;

import java.util.Arrays;
import java.util.Comparator;
import java.util.NoSuchElementException;
import java.util.Optional;

public enum LottoPrizePolicy {
	THREE_MATCH_PRIZE(3, 5_000),
	FOUR_MATCH_PRIZE(4, 50_000),
	FIVE_MATCH_PRIZE(5, 1_500_000),
	SIX_MATCH_PRIZE(6, 2_000_000_000);

	private int matchCount;

	private int prizeMoney;

	LottoPrizePolicy(int matchCount, int prizeMoney) {
		this.matchCount = matchCount;
		this.prizeMoney = prizeMoney;
	}

	public int getMatchCount() {
		return matchCount;
	}

	public int getPrizeMoney() {
		return prizeMoney;
	}

	public static int getPrizeMoney(int matchCount) {
		int totalPrizeMoney = 0;
		for (LottoPrizePolicy policy : LottoPrizePolicy.values()) {
			totalPrizeMoney += getPrizeMoneypolicy(policy, matchCount);
		}
		return totalPrizeMoney;
	}

	private static int getPrizeMoneypolicy(LottoPrizePolicy policy, int inputMatchCount) {
		if (policy.getMatchCount() == inputMatchCount) {
			return policy.getPrizeMoney();
		}
		return 0;
	}

	public static int getMinMatchCount() {
		LottoPrizePolicy minMatchPolicy = Arrays.asList(LottoPrizePolicy.values())
				.stream()
				.min(Comparator.comparing(LottoPrizePolicy::getMatchCount))
				.orElse(THREE_MATCH_PRIZE);
		return minMatchPolicy.getMatchCount();
	}
}



