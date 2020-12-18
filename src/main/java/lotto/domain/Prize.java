package lotto.domain;

import java.util.Arrays;

/**
 * @author : byungkyu
 * @date : 2020/12/15
 * @description :
 **/
public enum Prize {

	FIRST(6, 2_000_000_000),
	SECOND(5, 30_000_000),
	THIRD(5, 1_500_000),
	FOURTH(4, 50_000),
	FIFTH(3, 5_000),
	NONE(0, 0);

	private int matchCount;
	private int reward;

	Prize(int matchCount, int reward) {
		this.matchCount = matchCount;
		this.reward = reward;
	}

	public static Prize of(Long count, boolean isMatchBonus) {
		return Arrays.stream(values()).filter(prize -> prize.isEqualMatchCount(count))
			.filter(prize -> !prize.equals(SECOND) || isMatchBonus)
			.findFirst()
			.orElse(NONE);
	}

	private boolean isEqualMatchCount(Long count) {
		return this.matchCount == count;
	}

	public int getMatchCount() {
		return matchCount;
	}

	public int getReward() {
		return reward;
	}

}
