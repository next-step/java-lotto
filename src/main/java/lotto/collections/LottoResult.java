package lotto.collections;

import java.util.List;

import lotto.domain.Money;
import lotto.domain.RewardType;
import lotto.service.WinningService;
import lotto.util.LottoProfitCalculator;

public final class LottoResult {

	private List<RewardType> lottoStatistics;

	public LottoResult(List<RewardType> lottoStatistics) {
		this.lottoStatistics = lottoStatistics;
	}

	public double getLottoProfitRate(final int lottoTicketSize) {
		Money profitAsMoney = WinningService.calculateProfit(lottoStatistics);
		double totalProfitValue = profitAsMoney.getValue();
		return LottoProfitCalculator.getConvertProfit(totalProfitValue, lottoTicketSize);
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
