package lotto.domain;

import java.util.Arrays;

public enum Reward {
	FIRST(6, 2_000_000_000),
	SECOND(5, 30_000_000),
	THIRD(5, 1_500_000),
	FOURTH(4, 50_000),
	FIFTH(3, 5_000),
	MISS(0, 0);

	int matchCount;
	int money;

	Reward(int matchCount, int money) {
		this.matchCount = matchCount;
		this.money = money;
	}

	public static Reward getRewardByMatchCount(int matchCount, boolean hasBonusNumber) {
		if (isSecond(matchCount, hasBonusNumber)) {
			return SECOND;
		}
		return Arrays.stream(values())
			.filter(reward -> reward.getMatchCount() == (matchCount))
			.findFirst()
			.orElse(MISS);
	}

	private static boolean isSecond(int matchCount, boolean hasBonusNumber) {
		return matchCount == 5 && hasBonusNumber;
	}

	public int getMatchCount() {
		return matchCount;
	}

	public int getMoney() {
		return money;
	}
}
