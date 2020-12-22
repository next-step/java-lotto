package step2.domain;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;

public class LottoResults {

	private final Map<LottoWin, Integer> lottoResults;

	public LottoResults(final Lottos lottos, final LottoNumber bonusNumber) {
		this.lottoResults = new LinkedHashMap<>();
		addResult(lottos, bonusNumber);
	}

	private void addResult(final Lottos lottos, final LottoNumber bonusNumber) {
		for (Lotto lotto : lottos.getLottos()) {
			LottoWin lottoWin = LottoWin.of(lotto.getMatchCount(), lotto.matchesBonusNumber(bonusNumber));
			this.lottoResults.merge(lottoWin, 1, (k, v) -> v + 1);
		}
	}

	public Map<LottoWin, Integer> getLottoResults() {
		return Collections.unmodifiableMap(lottoResults);
	}

	public long getWinPrice() {
		return this.lottoResults.entrySet().stream()
			.filter(lottoWinIntegerEntry -> lottoWinIntegerEntry.getKey().isWin())
			.mapToLong(entry -> entry.getKey().getPrice() * entry.getValue())
			.sum();
	}

	public Integer get(final LottoWin lottoWin) {
		return this.lottoResults.get(lottoWin);
	}
}
