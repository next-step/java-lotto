package step2.domain;

import static step2.domain.var.LottoConstant.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import step2.domain.var.LottoPrize;

public class LottoStast {
	private final Map<LottoPrize, Integer> winCountMap = new HashMap<>();
	private Double profitRatio;
	private int gainnedMoney = 0;

	public LottoStast(List<Lotto> lottos, List<LottoNumber> winNumbers) {
		setWinCountMap(lottos, winNumbers);

		int inputtedMoney = lottos.size() * LOTTO_PRICE;
		setProfitRatio(inputtedMoney);
	}

	private void setWinCountMap(List<Lotto> lottos, List<LottoNumber> winNumbers) {
		for (Lotto lotto : lottos) {
			int correctCount = (int)winNumbers
				.stream()
				.filter(lotto::contains)
				.count();
			LottoPrize lottoPrize = LottoPrize.getByCount(correctCount);
			winCountMap.put(lottoPrize, winCountMap.getOrDefault(lottoPrize, 0) + 1);
			gainnedMoney += lottoPrize.getPrize();
		}
	}

	public int getWinnerCount(LottoPrize prize) {
		return winCountMap.getOrDefault(prize, 0);
	}

	public Integer getProfitRatio() {
		return profitRatio.intValue();
	}

	private void setProfitRatio(int inputtedMoney) {
		this.profitRatio = (double)(gainnedMoney - inputtedMoney) / inputtedMoney * 100;
	}
}
