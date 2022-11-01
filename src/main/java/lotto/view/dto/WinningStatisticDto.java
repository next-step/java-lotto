package lotto.view.dto;

import java.util.Map;
import java.util.stream.IntStream;

import lotto.domain.Reward;

public class WinningStatisticDto {

	public static final int MIN_MATCHING_COUNT = 3;
	public static final int MAX_MATCHING_COUNT = 6;

	private final Map<Integer, Integer> winningStatistic;
	private final float performance;

	private WinningStatisticDto(Map<Integer, Integer> winningStatistic, int purchaseAmount) {
		this.winningStatistic = winningStatistic;

		this.performance = (float)calculateAllRewards() / purchaseAmount;
	}

	public static WinningStatisticDto of(Map<Integer, Integer> winningStatistic, int purchaseAmount) {
		return new WinningStatisticDto(winningStatistic, purchaseAmount);
	}

	private int calculateAllRewards() {
		return IntStream.rangeClosed(MIN_MATCHING_COUNT, MAX_MATCHING_COUNT)
			.map(i -> Reward.getRewardByMatchCount(i).getMoney() * winningStatistic.getOrDefault(i, 0))
			.sum();
	}

	public Map<Integer, Integer> getWinningStatistic() {
		return winningStatistic;
	}

	public float getPerformance() {
		return performance;
	}
}
