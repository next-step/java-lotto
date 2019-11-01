package lotto.domain.person;

import lotto.domain.lotto.Lotto;
import lotto.domain.lotto.LottoPrize;

import java.util.List;

public class EarningsRateCalculator {

	public static double calculate(List<Lotto> lotteries, int lottoPrice) {
		return (double) getRewardAmount(lotteries) / getLottoPrices(lotteries, lottoPrice);
	}

	private static long getRewardAmount(List<Lotto> lotteries) {
		return lotteries.stream()
				.map(Lotto::getStatus)
				.mapToLong(LottoPrize::getRewardAmount)
				.sum();
	}

	private static int getLottoPrices(List<Lotto> lotteries, int lottoPrice) {
		return lotteries.size() * lottoPrice;
	}

}
