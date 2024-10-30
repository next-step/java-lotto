package step2.domain;

import static step2.domain.var.LottoConstant.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import step2.domain.var.LottoPrize;

public class LottoStatistics {
	private final Map<LottoPrize, Integer> winCountMap = new HashMap<>();
	private final Double profitRatio;
	private int gainedMoney = 0;

	public LottoStatistics(List<Lotto> lottos, Lotto winningLotto) {
		setWinCountMap(lottos, winningLotto);
		Money inputtedMoney = new Money(lottos.size() * LOTTO_PRICE);
		this.profitRatio = inputtedMoney.getProfitByGainedMoney(gainedMoney);
	}

	private void setWinCountMap(List<Lotto> lottos, Lotto winningLotto) {
		for (Lotto lotto : lottos) {
			int correctCount = (int)winningLotto.getLottoNumbers()
				.stream()
				.filter(lotto::contains)
				.count();
			LottoPrize lottoPrize = LottoPrize.getByCount(correctCount);
			winCountMap.put(lottoPrize, winCountMap.getOrDefault(lottoPrize, 0) + 1);
			gainedMoney += lottoPrize.getPrize();
		}
	}

	public int getWinnerCount(LottoPrize prize) {
		return winCountMap.getOrDefault(prize, 0);
	}

	public Integer getProfitRatio() {
		return profitRatio.intValue();
	}
}
