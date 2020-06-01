package lotto.collections;

import java.util.Arrays;
import java.util.Map;

public enum RewardType {
	FAIL(0, 0),
	FIRST(1, 0),
	SECOND(2, 0),
	THIRD(3, 5000),
	FOURTH(4, 50000),
	FIFTH(5, 1500000),
	SIXTH(6, 2_000_000_000);

	private final int code;
	private final int reward;

	RewardType(int code, int reward) {
		this.code = code;
		this.reward = reward;
	}

	public static int calculateProfit(Map<Integer, Integer> lottoStatistics) {
		return Arrays.stream(values())
			.filter(type -> lottoStatistics.containsKey(type.code))
			.map(type -> type.reward * lottoStatistics.get(type.code))
			.reduce(0, Integer::sum);
	}

	public int getCode() {
		return code;
	}

	public int getReward() {
		return reward;
	}
}
