package lotto;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Arrays;
import java.util.EnumMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;
import java.util.stream.Collectors;

public class LottoResult {
	private static final int ROUNDING_OFF_SCALE = 2;

	private final Map<LottoPrizeType, AtomicLong> lottoResults;

	private LottoResult(List<LottoPrizeType> lottoResults) {
		this.lottoResults = enumMapOf(lottoResults);
	}

	public static LottoResult of(List<LottoPrizeType> lottoResults) {
		return new LottoResult(lottoResults);
	}

	private Map<LottoPrizeType, AtomicLong> enumMapOf(List<LottoPrizeType> lottoResults) {
		Map<LottoPrizeType, AtomicLong> map = new EnumMap<>(LottoPrizeType.class);
		lottoResults.forEach(it -> map.computeIfAbsent(it, result -> new AtomicLong(0))
				.getAndIncrement());
		return map;
	}

	public Long getNumberOfLottosMatchedWith(LottoPrizeType lottoPrizeType) {
		return lottoResults.get(lottoPrizeType)
				.longValue();
	}

	public float getProfitRate() {
		return lottoResults.keySet()
				.stream()
				.map(LottoPrizeType::getPrizeMoney)
				.reduce(BigDecimal.ZERO, BigDecimal::add)
				.divide(BigDecimal.valueOf(lottoResults.values()
								.stream()
								.mapToInt(AtomicLong::intValue)
								.sum())
								.multiply(Constants.LOTTO_PRICE),
						ROUNDING_OFF_SCALE, RoundingMode.FLOOR)
				.floatValue();
	}

	@Override
	public String toString() {
		return Arrays.stream(LottoPrizeType.values())
				.filter(LottoPrizeType::isWinningType)
				.map(it -> it.getMatchedNumberCount() + "개 일치 (" + it.getPrizeMoney() + "원)- " + lottoResults.getOrDefault(it, new AtomicLong(0)) + "개")
				.collect(Collectors.joining(Constants.JOINING_DELIMITER));
	}
}
