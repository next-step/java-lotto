package lotto.domain.util;

import lotto.domain.lotto.LottoPrize;
import lotto.dto.LottoDto;
import lotto.dto.LottoPrizeStat;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class LottoPrizeCounter {

	public static LottoPrizeStat countLottoPrizes(List<LottoDto> lottoDtos) {
		Map<LottoPrize, Long> stat = new LinkedHashMap<>();
		for (LottoPrize prize : LottoPrize.displayedLottoPrizes()) {
			stat.put(prize, countWithSameLottoPrize(lottoDtos, prize));
		}
		return new LottoPrizeStat(stat);
	}

	private static Long countWithSameLottoPrize(List<LottoDto> lottoDtos, LottoPrize prize) {
		return lottoDtos.stream()
				.filter(dto -> dto.hasSameStatus(prize))
				.count();
	}

}
