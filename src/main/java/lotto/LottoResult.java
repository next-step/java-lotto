package lotto;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class LottoResult {
	private static final int ROUNDING_OFF_SCALE = 2;


	private final List<LottoPrizeType> lottoResults;

	private LottoResult(List<LottoPrizeType> lottoResults) {
		this.lottoResults = lottoResults;
	}

	public static LottoResult of(List<LottoPrizeType> lottoResults) {
		return new LottoResult(lottoResults);
	}

	public long getNumberOfLottosMatchedWith(int matchedNumberCount) {
		return lottoResults.stream()
				.filter(it -> it.getMatchedNumberCount() == matchedNumberCount)
				.count();
	}

	public float getProfitRate() {
		return lottoResults.stream()
				.map(LottoPrizeType::getPrizeMoney)
				.reduce(BigDecimal.ZERO, BigDecimal::add)
				.divide(BigDecimal.valueOf(lottoResults.size())
								.multiply(Constants.LOTTO_PRICE),
						ROUNDING_OFF_SCALE, RoundingMode.FLOOR)
				.floatValue();
	}

	@Override
	public String toString() {
		return Arrays.stream(LottoPrizeType.values())
				.filter(LottoPrizeType::isWinningType)
				.map(it -> it.getMatchedNumberCount() + "개 일치 (" + it.getPrizeMoney() + "원)- " + getNumberOfLottosMatchedWith(it.getMatchedNumberCount()) + "개")
				.collect(Collectors.joining(Constants.JOINING_DELIMITER));
	}
}
