package lotto.collections;

import java.util.List;

import lotto.domain.RewardType;
import lotto.service.WinningService;

public final class LottoResult {

	private List<RewardType> lottoStatistics;

	public LottoResult(List<RewardType> lottoStatistics) {
		this.lottoStatistics = lottoStatistics;
	}

	public double getLottoProfitRate(final int lottoTicketSize) {
		return WinningService.calculateProfit(lottoStatistics, lottoTicketSize);
	}

	public int countTicketsByRewardType(final RewardType rewardType) {
		return Math.toIntExact(lottoStatistics.stream()
			.filter(type -> type.equals(rewardType))
			.count());
	}

	public List<RewardType> getLottoStatistics() {
		return lottoStatistics;
	}
}
