package lotto.collections;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import lotto.service.WinningService;
import lotto.util.LottoProfitCalculator;

public final class LottoResult {

	private Map<Integer, Integer> lottoStatistics;
	private List<RewardType> lottoStatistics2;

	public LottoResult(Map<Integer, Integer> lottoStatistics) {
		this.lottoStatistics = lottoStatistics;
	}

	public LottoResult(List<RewardType> lottoStatistics2) {
		this.lottoStatistics2 = lottoStatistics2;
	}

	public double getLottoProfitRate(final int lottoTicketSize) {
		double totalProfit = WinningService.calculateProfit(lottoStatistics2).getValue();
		return LottoProfitCalculator.getConvertProfit(totalProfit, lottoTicketSize);
	}

	public int countTicketsByRewardType(RewardType rewardType) {
		return Optional.of(
			Arrays.stream(RewardType.values())
				.filter(type -> type.equals(rewardType))
				.mapToInt(i -> 1)
				.sum())
			.orElse(0);
	}

	public Map<Integer, Integer> getLottoStatistics() {
		return lottoStatistics;
	}
}
