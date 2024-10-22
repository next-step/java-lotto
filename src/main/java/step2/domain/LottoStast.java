package step2.domain;

import static step2.domain.var.LottoConstant.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import step2.domain.var.LottoPrize;

public class LottoStast {
	private final Map<LottoPrize, Integer> winCountMap = new HashMap<>();
	private final Double profitRatio;

	public LottoStast(List<Lotto> lottos, List<LottoNumber> winNumbers) {
		Map<Lotto, Integer> lottoCorrectMap = new HashMap<>();

		for (Lotto lotto : lottos) {
			for (LottoNumber winNumber : winNumbers) {
				if (lotto.getLottoNumbers().contains(winNumber)) {
					lottoCorrectMap.put(lotto, lottoCorrectMap.getOrDefault(lotto, 0) + 1);
				}
			}
		}
		Integer inputtedMoney = lottos.size() * LOTTO_PRICE;
		Double gainnedMoney = 0d;

		for (Integer correctCount : lottoCorrectMap.values()) {
			if (correctCount.equals(LottoPrize.FIRST_WINNER.getCount())) {
				winCountMap.put(LottoPrize.FIRST_WINNER, winCountMap.getOrDefault(LottoPrize.FIRST_WINNER, 0) + 1);
				gainnedMoney += LottoPrize.FIRST_WINNER.getPrize();
			}
			if (correctCount.equals(LottoPrize.SECOND_WINNER.getCount())) {
				winCountMap.put(LottoPrize.SECOND_WINNER, winCountMap.getOrDefault(LottoPrize.SECOND_WINNER, 0) + 1);
				gainnedMoney += LottoPrize.SECOND_WINNER.getPrize();
			}
			if (correctCount.equals(LottoPrize.THIRD_WINNER.getCount())) {
				winCountMap.put(LottoPrize.THIRD_WINNER, winCountMap.getOrDefault(LottoPrize.THIRD_WINNER, 0) + 1);
				gainnedMoney += LottoPrize.THIRD_WINNER.getPrize();
			}
			if (correctCount.equals(LottoPrize.FOURTH_WINNER.getCount())) {
				winCountMap.put(LottoPrize.FOURTH_WINNER, winCountMap.getOrDefault(LottoPrize.FOURTH_WINNER, 0) + 1);
				gainnedMoney += LottoPrize.FOURTH_WINNER.getPrize();
			}
		}
		this.profitRatio = (gainnedMoney - inputtedMoney.doubleValue()) / inputtedMoney * 100;
	}

	public int getFirstWinnerCount() {
		return winCountMap.getOrDefault(LottoPrize.FIRST_WINNER, 0);
	}

	public int getSecondWinnerCount() {
		return winCountMap.getOrDefault(LottoPrize.SECOND_WINNER, 0);
	}

	public int getThirdWinnerCount() {
		return winCountMap.getOrDefault(LottoPrize.THIRD_WINNER, 0);
	}

	public int getFourthWinnerCount() {
		return winCountMap.getOrDefault(LottoPrize.FOURTH_WINNER, 0);
	}

	public Integer getProfitRatio() {
		return profitRatio.intValue();
	}
}
