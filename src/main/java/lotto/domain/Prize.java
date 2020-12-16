package lotto.domain;

import java.util.Arrays;

/**
 * @author : byungkyu
 * @date : 2020/12/15
 * @description :
 **/
public enum Prize {

	SIX(6, 2_000_000_000),
	FIVE(5, 1_500_000),
	FOUR(4, 50_000),
	THREE(3, 5_000),
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
