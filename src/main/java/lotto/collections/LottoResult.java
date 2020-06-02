package lotto.collections;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import lotto.service.WinningService;
import lotto.util.LottoProfitCalculator;

public final class LottoResult {

	private final List<RewardType> lottoStatistics;

	public LottoResult(List<RewardType> lottoStatistics) {
		this.lottoStatistics = lottoStatistics;
	}

	public double getLottoProfitRate(final int lottoTicketSize) {
		double totalProfit = new WinningService().calculateProfit(lottoStatistics).getValue();
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

	public List<RewardType> getLottoStatistics() {
		return lottoStatistics;
	}
}
