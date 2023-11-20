package lotto;

import java.util.Collections;
import java.util.EnumMap;
import java.util.Map;

public class LottoResult {
	private static final long LOTTO_PRICE = 1000;

	private final Map<LottoMatch, Integer> lottoMatchResult;
	private final LottoList lottoList;

	public LottoResult(LottoList lottoList) {
		checkLottoListSizeIsValid(lottoList);
		lottoMatchResult = new EnumMap<>(LottoMatch.class);
		this.lottoList = lottoList;
	}

	private void checkLottoListSizeIsValid(LottoList lottoList) {
		if(lottoList == null || lottoList.size() == 0) {
			throw new IllegalArgumentException("최소 1개 이상의 로또 번호가 존재해야 합니다");
		}
	}

	public void matchesWinningNumbers(LottoWinningNumbers lottoWinningNumbers) {
		initializeLottoMatchMap();
		for (Lotto lotto : lottoList) {
			LottoMatch lottoMatch = lottoWinningNumbers.matchesLotto(lotto);
			lottoMatchResult.merge(lottoMatch, 1, Integer::sum);
		}
	}

	private void initializeLottoMatchMap() {
		for(LottoMatch lottoMatch : LottoMatch.values()) {
			lottoMatchResult.put(lottoMatch, 0);
		}
	}

	public double rateOfReturn() {
		long winningAmount = 0;
		LottoMatch lottoMatch = null;
		int count = 0;

		for (Map.Entry<LottoMatch, Integer> entry : lottoMatchResult.entrySet()) {
			lottoMatch = entry.getKey();
			count = entry.getValue();

			winningAmount += lottoMatch.amount() * count;
		}

		long purchaseAmount = lottoList.size() * LOTTO_PRICE;

		return (double) (winningAmount / purchaseAmount * 100);
	}

	public Map<LottoMatch, Integer> lottoMatchMap() {
		return Collections.unmodifiableMap(this.lottoMatchResult);
	}
}
