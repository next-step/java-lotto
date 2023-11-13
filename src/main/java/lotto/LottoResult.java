package lotto;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LottoResult {
	private final Map<LottoMatch, Integer> lottoMatchResult;

	public LottoResult() {
		lottoMatchResult = new HashMap<>();
	}

	public void matchesWinningNumbers(LottoList lottoList, LottoWinningNumbers lottoWinningNumbers) {
		lottoMatchResult.clear();
		List<Lotto> lottos = lottoList.lottoList();

		for (Lotto lotto : lottos) {
			lotto.matches(lottoWinningNumbers, lottoMatchResult);
		}
	}

	public Map<LottoMatch, Integer> result() {
		return Collections.unmodifiableMap(this.lottoMatchResult);
	}
}
