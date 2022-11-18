package lotto.view.dto;

import java.util.Map;

import lotto.domain.Reward;

public class WinningStatisticDto {
	private final Map<Reward, Integer> winningStatistic;
	private final float performance;

	private WinningStatisticDto(Map<Reward, Integer> winningStatistic, int purchaseAmount) {
		this.winningStatistic = winningStatistic;

		this.performance = (float)calculateAllRewards() / purchaseAmount;
	}

	public static WinningStatisticDto of(Map<Reward, Integer> winningStatistic, int purchaseAmount) {
		return new WinningStatisticDto(winningStatistic, purchaseAmount);
	}

	private int calculateAllRewards() {
		return winningStatistic.keySet()
			.stream()
			.mapToInt(reward -> reward.getMoney() * winningStatistic.get(reward))
			.sum();
	}

	public Map<Reward, Integer> getWinningStatistic() {
		return winningStatistic;
	}

	public float getPerformance() {
		return performance;
	}
}
