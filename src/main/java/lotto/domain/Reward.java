package lotto.domain;

import java.util.Arrays;

import calculator.exception.ErrorMessage;
import lotto.exception.InvalidMatchCountException;

public enum Reward {
	THREE_MATCH_REWARD(3, 5000),
	FOUR_MATCH_REWARD(4, 50000),
	FIVE_MATCH_REWARD(5, 1500000),
	SIX_MATCH_REWARD(6, 2000000000);

	int matchCount;
	int money;

	Reward(int matchCount, int money) {
		this.matchCount = matchCount;
		this.money = money;
	}

	public static Reward getRewardByMatchCount(int matchCount) {
		return Arrays.stream(values())
			.filter(reward -> reward.getMatchCount() == (matchCount))
			.findFirst()
			.orElseThrow(() -> new InvalidMatchCountException(ErrorMessage.INVALID_MATCH_COUNT));
	}

	public int getMatchCount() {
		return matchCount;
	}

	public int getMoney() {
		return money;
	}
}
