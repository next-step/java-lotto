package lotto;

import java.util.Collections;
import java.util.EnumMap;
import java.util.Map;

public class LottoResult {
	private static final int LOTTO_PRICE = 1000;

	private final Map<LottoMatch, Integer> lottoMatchResult;
	private final LottoList lottoList;
	private int rateOfReturn;

	public LottoResult(LottoList lottoList) {
		lottoMatchResult = new EnumMap<>(LottoMatch.class);
		this.lottoList = lottoList;
	}

	public void matchesWinningNumbers(LottoWinningNumbers lottoWinningNumbers) {
		initializeLottoMatchMap();
		for (Lotto lotto : lottoList) {
			lotto.matches(lottoWinningNumbers, lottoMatchResult);
		}

		calculateRateOfReturn();
	}

	private void initializeLottoMatchMap() {
		for(LottoMatch lottoMatch : LottoMatch.values()) {
			lottoMatchResult.put(lottoMatch, 0);
		}
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

		this.rateOfReturn = (int) ((amount / (lottoList.size() * LOTTO_PRICE)) * 100);
	}

	public Map<LottoMatch, Integer> lottoMatchMap() {
		return Collections.unmodifiableMap(this.lottoMatchResult);
	}

	public double rateOfReturn() {
		return this.rateOfReturn;
	}
}
