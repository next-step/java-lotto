package lotto.domain.util;

import lotto.domain.lotto.LottoPrize;
import lotto.dto.LottoPrizeStat;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class LottoPrizeCounter {

	public static LottoPrizeStat countLottoPrizes(List<LottoPrize> lottoPrizes) {
		Map<LottoPrize, Long> stat = new LinkedHashMap<>();
		for (LottoPrize prize : LottoPrize.displayedLottoPrizes()) {
			stat.put(prize, countWithSameLottoPrize(lottoPrizes, prize));
		}
		return new LottoPrizeStat(stat);
	}

	private static Long countWithSameLottoPrize(List<LottoPrize> lottoPrizes, LottoPrize prize) {
		return lottoPrizes.stream()
				.filter(lottoPrize -> lottoPrize.equals(prize))
				.count();
	}

}
