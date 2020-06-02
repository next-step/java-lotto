package lotto.collections;

import java.util.Arrays;
import java.util.Map;

public enum RewardType {
	THIRD(1, new Money(5000)),
	FOURTH(2, new Money(50000)),
	FIFTH(3, new Money(1500000)),
	FIFTH_BONUS(4, new Money(30000000)),
	SIXTH(5, new Money(2_000_000_000));

	private final int code;
	private final Money reward;

	RewardType(int code, Money reward) {
		this.code = code;
		this.reward = reward;
	}

	public static int calculateProfit(Map<Integer, Integer> lottoStatistics) {
		return Arrays.stream(values())
			.filter(type -> lottoStatistics.containsKey(type.code))
			.map(type -> type.reward.getMoney() * lottoStatistics.get(type.code))
			.reduce(0, Integer::sum);
	}

	public int getCode() {
		return code;
	}

	public Money getReward() {
		return reward;
	}
}
