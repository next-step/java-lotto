package lotto.domain.util;

import lotto.domain.lotto.LottoPrize;

import java.util.List;

public class EarningsRateCalculator {

	public static double calculate(List<LottoPrize> lottoPrizes, int lottoPrice) {
		return (double) getRewardAmount(lottoPrizes) / getLottoPrices(lottoPrizes, lottoPrice);
	}

	private static long getRewardAmount(List<LottoPrize> lottoPrizes) {
		return lottoPrizes.stream()
				.mapToLong(LottoPrize::getRewardAmount)
				.sum();
	}

	private static int getLottoPrices(List<LottoPrize> lottoPrizes, int lottoPrice) {
		return lottoPrizes.size() * lottoPrice;
	}

}
