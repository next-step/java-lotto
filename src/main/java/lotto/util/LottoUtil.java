package lotto.util;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import lotto.domain.LottoBalls;
import lotto.domain.PrizeMoney;

public class LottoUtil {
	public static Map<Integer, Integer> getLottoStatistics(List<LottoBalls> lotteries, int[] winnerNumbers) {
		Map<Integer, Integer> winStatistics = new HashMap<>();
		for (LottoBalls lottery : lotteries) {
			int key = lottery.countMatchNumber(winnerNumbers);
			winStatistics.put(key, winStatistics.getOrDefault(key, 0) + 1);
		}
		return winStatistics;
	}

	public static long calculatePrizeMoney(int matchCount, int lottoCount) {
		PrizeMoney money = Arrays.stream(PrizeMoney.values())
			.filter(e -> matchCount == e.getMatchCount())
			.findFirst()
			.orElse(PrizeMoney.NON_MATCH);

		return money.getPrizeMoney(lottoCount);
	}

	public static float getRateOfReturn(int lottoCount, Map<Integer, Integer> winStatistics) {
		long prizeMoneySum = winStatistics.entrySet().stream()
			.mapToLong(e -> LottoUtil.calculatePrizeMoney(e.getKey(), e.getValue()))
			.sum();
		return Math.round(prizeMoneySum / (lottoCount * 10.0f)) / 100.0f ;

	}
}
