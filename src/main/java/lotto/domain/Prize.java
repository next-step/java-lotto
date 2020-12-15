package lotto.domain;

import java.util.Arrays;

/**
 * @author : byungkyu
 * @date : 2020/12/15
 * @description :
 **/
public enum Prize {
	SIX(6, 2000000000),
	FIVE(5, 1500000),
	FOUR(4, 50000),
	THREE(3, 5000),
	NONE(0, 0);

	private int matchCount;
	private int reward;

	Prize(int matchCount, int reward) {
		this.matchCount = matchCount;
		this.reward = reward;
	}

	public static Prize of(Long count) {
		return Arrays.stream(values()).filter(one -> one.matchCount == count)
			.findFirst()
			.orElse(NONE);
	}

	public int getMatchCount() {
		return matchCount;
	}
	public int getReward() {
		return reward;
	}
}
