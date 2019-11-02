package lotto.domain.util;

import lotto.domain.lotto.LottoPrize;
import lotto.dto.LottoDto;

import java.util.List;

public class EarningsRateCalculator {

	public static double calculate(List<LottoDto> lotteries, int lottoPrice) {
		return (double) getRewardAmount(lotteries) / getLottoPrices(lotteries, lottoPrice);
	}

	private static long getRewardAmount(List<LottoDto> lotteries) {
		return lotteries.stream()
				.map(LottoDto::getStatus)
				.mapToLong(LottoPrize::getRewardAmount)
				.sum();
	}

	private static int getLottoPrices(List<LottoDto> lotteries, int lottoPrice) {
		return lotteries.size() * lottoPrice;
	}

}
