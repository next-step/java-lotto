package lotto;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LottoResult {
	private final Map<LottoMatch, Integer> lottoMatchResult;
	private final long purchaseAmount;
	private int rateOfReturn;

	public LottoResult(long purchaseAmount) {
		lottoMatchResult = new HashMap<>();
		this.purchaseAmount = purchaseAmount;
	}

	public void matchesWinningNumbers(LottoList lottoList, LottoWinningNumbers lottoWinningNumbers) {
		lottoMatchResult.clear();
		List<Lotto> lottos = lottoList.lottoList();

		for (Lotto lotto : lottos) {
			lotto.matches(lottoWinningNumbers, lottoMatchResult);
		}

		calculateRateOfReturn();
	}

	private void calculateRateOfReturn() {
		long amount = 0;
		LottoMatch lottoMatch = null;
		int count = 0;
		for (Map.Entry<LottoMatch, Integer> entry : lottoMatchResult.entrySet()) {
			lottoMatch = entry.getKey();
			count = entry.getValue();

			amount += lottoMatch.amount() * count;
		}

		this.rateOfReturn = (int) ((amount / purchaseAmount) * 100);
	}

	public Map<LottoMatch, Integer> result() {
		return Collections.unmodifiableMap(this.lottoMatchResult);
	}

	public double rateOfReturn() {
		return this.rateOfReturn;
	}
}
