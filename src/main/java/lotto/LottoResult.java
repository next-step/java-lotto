package lotto;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class LottoResult {
	private final LottoList lottoList;
	private final Map<LottoMatch, Integer> lottoMatchResult = new HashMap<>();

	public LottoResult(LottoList lottoList) {
		this.lottoList = lottoList;
	}

	public void matchesWinningNumbers(LottoWinningNumbers lottoWinningNumbers) {
		lottoMatchResult.put(LottoMatch.valueOf("THREE"), 1);
		lottoMatchResult.put(LottoMatch.valueOf("FOUR"), 1);
	}

	public Map<LottoMatch, Integer> result() {
		return Collections.unmodifiableMap(this.lottoMatchResult);
	}
}
