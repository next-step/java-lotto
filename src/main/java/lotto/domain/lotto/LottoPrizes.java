package lotto.domain.lotto;

import lotto.dto.LottoPrizeStat;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class LottoPrizes {

	private final List<LottoPrize> lottoPrizes;

	public LottoPrizes(List<LottoPrize> lottoPrizes) {
		this.lottoPrizes = lottoPrizes;
	}

	public double calculateEarningsRatio(int lottoPrice) {
		return (double) getRewardAmount() / getLottoPrices(lottoPrice);
	}

	private long getRewardAmount() {
		return lottoPrizes.stream()
				.mapToLong(LottoPrize::getRewardAmount)
				.sum();
	}

	private int getLottoPrices(int lottoPrice) {
		return lottoPrizes.size() * lottoPrice;
	}

	public LottoPrizeStat createStatistics() {
		Map<LottoPrize, Long> stat = new LinkedHashMap<>();
		for (LottoPrize prize : LottoPrize.displayedLottoPrizes()) {
			stat.put(prize, countWithSameLottoPrize(prize));
		}
		return new LottoPrizeStat(stat);
	}

	private Long countWithSameLottoPrize(LottoPrize prize) {
		return lottoPrizes.stream()
				.filter(lottoPrize -> lottoPrize.equals(prize))
				.count();
	}


}
